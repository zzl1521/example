package com.zzl.example.excel.parse;

/**
 * @author: zhile.zhang
 * @date: 2019/10/8
 * @desc:
 **/
public class SqlTest2 {

    public static void main(String[] args) {
        genSql2();
        System.out.println("#=================================================================================");
    }


    private static void genSql() {
        System.out.println("#--------------user_card----------------");
        for (int i = 0; i < 100; i++) {
            String tableSuffix = String.format("%2d", i).replace(" ", "0");
            String userCard = "update user_card_0%s set STATUS = 0,modified_user='限品劵测试数据注销' where created > '2020-09-08' and sale_order in ('00020200908001000036','00020200908001000037','00020200908001000038','00020200909001000039','00020200909001000040','00020200908000212905','00020200908000212906','00020200908000212907') and status=1;";
            System.out.println(String.format(userCard,tableSuffix));
        }
    }

    private static void genSql1() {
        System.out.println("#--------------user_card----------------");
        for (int i = 0; i < 100; i++) {
            String tableSuffix = String.format("%2d", i).replace(" ", "0");
            String userCard = "select sum(balance) as tmpcount from user_card_0%s where created > '2020-09-08' and sale_order in ('00020200908001000036','00020200908001000037','00020200908001000038','00020200909001000039','00020200909001000040','00020200908000212905','00020200908000212906','00020200908000212907') and status=1\n" +
                    "UNION ALL";
            System.out.println(String.format(userCard,tableSuffix));
        }
    }

    private static void genSql2() {
        System.out.println("#--------------user_card----------------");
        for (int i = 0; i < 100; i++) {
            String tableSuffix = String.format("%2d", i).replace(" ", "0");
            String userCard = "select * from user_card_0%s where user_id =225000%s  \n" +
                    "UNION ALL";
            String replace = userCard.replace("%s", tableSuffix);
            System.out.println(replace);
        }
    }



}


