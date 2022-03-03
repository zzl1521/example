package com.zzl.example.excel.parse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhile.zhang
 * @date: 2022/2/15
 * @desc:
 **/
public class ExcelUtil<T> {


    public List<T> parse(Class tClass, String path, boolean hasHeader) {
        List<T> list = new ArrayList<>();
        try {
            InputStream is = new FileInputStream(path);
            jxl.Workbook wb = Workbook.getWorkbook(is);
            int sheetSize = wb.getNumberOfSheets();
            Sheet sheet = wb.getSheet(0);
            int row_total = sheet.getRows();
            for (int j = 0; j < row_total; j++) {
                if (hasHeader){
                    if (j == 0){
                        continue;
                    }
                }
                T t = (T) tClass.newInstance();
                Field[] declaredFields = tClass.getDeclaredFields();
                Cell[] cells = sheet.getRow(j);
                int length = declaredFields.length;
                for (int i = 0; i < length; i++) {
                    declaredFields[i].setAccessible(true);
                    declaredFields[i].set(t, cells[i].getContents());
                }
                list.add(t);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        ExcelUtil<User> excelUtil = new ExcelUtil();
        List<User> parse = excelUtil.parse(User.class, "D:\\download\\新建查询-20220217_163518754.xls", true);
        Map<String, Integer> map = new HashMap();
        int i = 0;
        for (User user : parse) {
            Integer integer = map.get(user.getCardInnerNo());
            if (integer != null) continue;
            String sql = "update user_card_0%s set sale_source = %s where id = %s and card_inner_no ='%s';";
            String replace = user.getUserId().replace("-", "");
            if (replace.length() > 2) {
                replace = replace.substring(replace.length() - 2);
            }
            String suffix = String.format("%02d", Integer.valueOf(replace));
            String format = String.format(sql, suffix, user.getSaleSource(), user.getId(), user.getCardInnerNo());
            System.out.println(format);
            map.put(user.getCardInnerNo(), 1);
            i ++ ;
        }
        System.out.println(i);
    }

}
