package com.zzl.example.excel.parse;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author: zhile.zhang
 * @date: 2019/10/8
 * @desc:
 **/
public class SqlTest {

    public static void main(String[] args) {
        String activityId = "10000025";
        String storeIdList = "18122";
        List<String> saleOrderList = Lists.newArrayList("XSD20191219001000015",
                "XSD20191219001000017",
                "XSD20191220001000018");
        String storeId = "18122";

        String head = "## 对应关系 activityId = %s | sale_order={%s}";
        System.out.println(String.format(head, activityId, saleOrderList));
        genSql(activityId, storeIdList, saleOrderList, storeId);
        System.out.println("#=================================================================================");
    }


    private static void genSql(String activityId, String storeIdList, List<String> saleOrderList, String storeId) {
        String activitySql = "INSERT INTO `activity` ( `activity_id`, `activity_name`, `activity_content`, `activity_url`, `activity_type`, `ware_range`, `rule_content`, `asset_type`, `coid`, `channel_id`, `vendor_id`, `store_id`, `order_type`, `sales_type_list`, `brand_ids`, `limit_type`, `status`, `discount_label`, `start_time`, `end_time`, `create_user`, `modified_user`, `created`, `modified`, `yn`) VALUES ( '%s', '重百规则数据迁移%s', '', '', '0', '0', '', '2', '10', '998000', '69', '%s', '0', '', '', '10', '2', '2', NOW(), '2050-08-04 09:00:00', '张志乐', '张志乐', NOW(), NOW(), '1');";
        String limitDetailSql = "INSERT INTO `limit_detail` (`activity_id`, `limit_type`, `limit_key`, `created`, `modified`, `yn`) VALUES ('%s', '1', '%s', NOW(), NOW(), '1');";

        String[] split = storeIdList.split("\\,");
        System.out.println(String.format(activitySql, activityId, activityId, storeId));
        for (String s : split) {
            System.out.println(String.format(limitDetailSql, activityId, s));
        }
        System.out.println("#--------------user_card----------------");
        String saleOrderStr = genSaleOrderStr(saleOrderList);
        for (int i = 0; i < 100; i++) {
            String tableSuffix = String.format("%2d", i).replace(" ", "0");
            String userCard = "update user_card_0%s set activity_limit_type='10',activity_id='%s' WHERE sale_order in (%s);";
            System.out.println(String.format(userCard, tableSuffix, activityId, saleOrderStr));
        }

    }

    private static String genSaleOrderStr(List<String> saleOrderList) {
        int size = saleOrderList.size();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            String s = saleOrderList.get(i);
            stringBuilder.append("\"");
            stringBuilder.append(s);
            stringBuilder.append("\"");
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }
}


