package com.doth;

import java.text.SimpleDateFormat;

class  ThreadSafeFormatter{
    //Each thread in the threadpool have a SimpleDateFormat object{ memory efficient  and thread safe}
    public static ThreadLocal<SimpleDateFormat> dateFormatter =  ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-mm-dd"));

    public static ThreadLocal<SimpleDateFormat> dateFormatter1 = new ThreadLocal<>(){

        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-mm-dd");
        }

        @Override
        public SimpleDateFormat get() {
            return super.get();
        }
    };
}