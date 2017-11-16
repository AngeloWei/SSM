package cn.learn.ssm.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

        private final  static long minute = 60 * 1000;
        private final  static long hour = 60 * minute;
        private final  static long day =24 * hour;
        private final  static long month=30 * day;
        private final static long year = 365 * day;

        private static final SimpleDateFormat DATE_FORMAT_S = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        private static final SimpleDateFormat DATE_FORMAT_D = new SimpleDateFormat("yyyy-MM-dd");
        private static final SimpleDateFormat DATE_FORMAT_M = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        /*
            私有化构造函数
         */
        private TimeUtils() {
            throw  new AssertionError();
        }
        /*
            Time converts
           @Param TimeOfMillis
           @Param dateFormat
           @return

         */
        public  static String getTime(long TimeOfMillis ,SimpleDateFormat dateFormat){
            return dateFormat.format(new Date(TimeOfMillis)) ;
        }

        public static String getTime(long timeOfMillis){
            return getTime(timeOfMillis,DATE_FORMAT_S);
        }

        /*
        get CurrentTime
         */
        public static  String getCurrentTime(){
            return getTime(System.currentTimeMillis());
        }



}
