package com.zzl.example.exam;

/**
 * @author: zhile.zhang
 * @date: 2020/5/26
 * @desc: 单例
 **/
public class Singleton {
    private  static Singleton  obj=null;
    private Singleton(){};
    public  Singleton getObj(){

        if(obj==null)
        {
            synchronized (Singleton.class)
            {
                if(obj==null)
                {
                    obj=new Singleton();
                }
            }
        }

        return   obj;
    }

}
