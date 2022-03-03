package com.zzl.example.exam;

/**
 * @author: zhile.zhang
 * @date: 2020/5/26
 * @desc: 线程创建
 **/
public class Test {


    public static void main(String[] args) {
        a  t=new a();

        t.start();
    }


}
  class  a extends  Thread{


    @Override
    public  void  run(){

    }
  }