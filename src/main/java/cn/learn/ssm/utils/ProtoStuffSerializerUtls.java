package cn.learn.ssm.utils;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProtoStuffSerializerUtls {

    /*
    serializer object
    @Param obj
    @return
     */
    public static <T> byte[] serializer(T obj){

        Schema<T> schema = (Schema<T>) RuntimeSchema.getSchema(obj.getClass());
        LinkedBuffer buff = LinkedBuffer.allocate(1024 * 1024);
        byte[] bytes = ProtobufIOUtil.toByteArray(obj, schema, buff);
        return bytes;
    }

    /*
    deserializer object
     */
    public  static <T> T deserializer(byte[] bytes ,Class<T> clazz){
        T instance = null;
        try {
            instance = clazz.newInstance();
        } catch (InstantiationException |IllegalAccessException e) {
           throw  new RuntimeException("deserializer fail",e);
        }
        Schema<T> schema = RuntimeSchema.getSchema(clazz);
        ProtostuffIOUtil.mergeFrom(bytes,instance,schema);
        return instance;
    }
    /*
    serializer list
     */
    public  static<T> byte[] serializerList(List<T> list){
        if(list == null){
            throw new RuntimeException("list is null");
        }
        ByteArrayOutputStream ops = null;

        Schema<T> schema = (Schema<T>) RuntimeSchema.getSchema(list.get(0).getClass());
        LinkedBuffer buff = LinkedBuffer.allocate(1024*1024);

        try {
            ops =new ByteArrayOutputStream();
            ProtostuffIOUtil.writeListTo(ops, list, schema, buff);
        } catch (IOException e) {
           throw  new RuntimeException("serializer list fail",e);
        }finally {
            buff.clear();
            try {
                if(ops!=null)
                ops.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return ops.toByteArray();
    }
    /*
      反序列化列表
     */
    public static<T> List<T> deserializerList(byte[] bytes,Class<T> clazz){
        Schema<T> schema = RuntimeSchema.getSchema(clazz);
        List<T> list = null;
        try {
             list = ProtostuffIOUtil.parseListFrom(new ByteArrayInputStream(bytes), schema);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static<T> List<T> deserializerList(List<byte[]> list,Class<T> clazz){
        Iterator<byte[]> iterator = list.iterator();
        List<T> newList= new ArrayList<T>();
        while(iterator.hasNext()){
            newList.add(deserializer(iterator.next(), clazz)) ;
        }
        return newList;
    }
}
