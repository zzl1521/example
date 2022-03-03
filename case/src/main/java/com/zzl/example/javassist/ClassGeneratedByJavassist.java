package com.zzl.example.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.Modifier;
import javassist.bytecode.AccessFlag;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author: zhile.zhang
 * @date: 2021/12/14
 * @desc:
 **/
public class ClassGeneratedByJavassist {

    public static void main(String[] args) throws Exception {

        ClassPool pool = ClassPool.getDefault();

        CtClass ctClass = pool.makeClass("com.study.javassist.MyCC");

        // 添加一个参数
        CtField ctField = new CtField(CtClass.intType, "id", ctClass);
        ctField.setModifiers(Modifier.PUBLIC);
        ctField.setModifiers(AccessFlag.VOLATILE);
        ctClass.addField(ctField);

        // 把生成的class文件写入文件
        byte[] byteArr = ctClass.toBytecode();
        FileOutputStream fos = new FileOutputStream(new File("D://MyCC.class"));
        fos.write(byteArr);
        fos.close();
        System.out.println("over!!");
    }
}
