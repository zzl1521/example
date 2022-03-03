package com.zzl.example.redis;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author: zhile.zhang
 * @date: 2020/8/21
 * @desc:
 **/
public class RedisBatchTest {
    public static void main(String[] args) {
        String outputFile = "D:\\log\\redis_input.txt";
        RedisBatchTest test = new RedisBatchTest();
        test.generateFile(outputFile);

    }

    /**
     * 格式化成输入字符串
     *
     * @param args
     * @return
     */
    private String getString(String key, String value) {
        StringBuilder sb = new StringBuilder();
        sb.append("*3").append("\r\n");
        sb.append("$3").append("\r\n");
        sb.append("SET\r\n");

        sb.append("$").append(key.getBytes().length).append("\r\n");
        sb.append(key).append("\r\n");

        sb.append("$").append(value.getBytes().length).append("\r\n");
        sb.append(value).append("\r\n");

        return sb.toString();
    }

    public void generateFile(String file) {

        BufferedWriter w = null;
        String key = null;
        String value = null;
        StringBuilder sb = new StringBuilder();
        try {
            w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
            for (int i = 1; i <= 380; i++) {
                key = "test_batch_" + i;
                value = "v_" + i + "注册即送水电费ServiceTest"; // 这是key对应的value
                sb.append(this.getString(key, value));
                if (i % 10 == 0) {
                    w.write(sb.toString());
                    w.flush();
                    sb.delete(0, sb.length());
                    System.out.println("Current write: " + i);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                w.flush();
                w.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
