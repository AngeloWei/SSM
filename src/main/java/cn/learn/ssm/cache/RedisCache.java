package cn.learn.ssm.cache;

import cn.learn.ssm.utils.ProtoStuffSerializerUtls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.List;

@Component
public class RedisCache {
    private static final String CACHENAME ="cache";
    private static final long EXPIRETIME =1000;


    @Autowired
    private StringRedisTemplate redisTemplate;

    /*
    use StringRedisTemplage serializer
     */
    public void setCacheNoReturn(String keyName,String value){
        redisTemplate.opsForValue().set(keyName,value);
    }
    /*
    use protoStuffSerializerUtils
     */
    public<T> boolean setCache( String key , T obj){

         final  byte[] bkey= key.getBytes();
         final byte[] bvalue = ProtoStuffSerializerUtls.serializer(obj);

        Boolean execute = redisTemplate.execute(new RedisCallback<Boolean>() {
             @Override
             public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return (connection.setNX(bkey,bvalue));
             }
         });
        return execute;
    }
    public<T> void setCacheWithExpireTime(String key ,T obj,final long ExpTime){
        final byte[] bkey = key.getBytes();
        final byte[] bvalue = ProtoStuffSerializerUtls.serializer(obj);
         redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.setEx(bkey, ExpTime, bvalue);
                return true;
            }
        });

    }
    public <T> boolean setCacheList(String key, List<T> list){
        final byte[] bkey = key.getBytes();
        final byte[] blist =  ProtoStuffSerializerUtls.serializerList(list);
        Boolean execute = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.setNX(bkey, blist);
            }
        });
        return execute;
    }
    public<T> Long pushCacheListByOne(String key,T obj){
        final byte[] bkey = key.getBytes();
        final byte[] bvalue= ProtoStuffSerializerUtls.serializer(obj);
        Object execute = redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.lPush(bkey, bvalue);
            }
        });
        return (Long) execute;

    }
    /*
    get value by key,for String
     */
    public String getCache(String pattern){
        return(redisTemplate.opsForValue().get(pattern));
    }
    /*
    get value by key,for anyObject
     */
    public<T> T getCache(String pattern,Class<T> clazz) {
        final byte[] bkey = pattern.getBytes();
        byte[] result = redisTemplate.execute(new RedisCallback<byte[]>() {

            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.get(bkey);
            }
        });
        return ProtoStuffSerializerUtls.deserializer(result,clazz);
    }
    /*
    get list<T> ,return t[]
     */
    public<T> List<T> getCacheListByAll(String key,Class<T> clazz){
        final byte[] bkey = key.getBytes();

        List<byte[]> result = redisTemplate.execute(new RedisCallback<List<byte[]>>() {
            @Override
            public List<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.lRange(bkey,0,-1);
            }
        });
        return ProtoStuffSerializerUtls.deserializerList(result,clazz);
    }
    /*
    list<T> to byte, get list byte;
     */
    public<T> List<T> getCacheList(String key,Class<T> clazz){
        final byte[] bkey = key.getBytes();
        byte[] listResult = redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.get(bkey);
            }
        });
        return ProtoStuffSerializerUtls.deserializerList(listResult,clazz);

    }
}
