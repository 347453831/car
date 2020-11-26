package com.fengf.carrental.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author zyf
 * @date 2020/10/24 20:29
 */
public  class OrderUtil {

    public static String getOrderIdByUUId() {
        String machineId = (int) (Math.random() * 9) + "";
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {
            //有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        String orderId = machineId + String.format("%015d", hashCodeV);
        return orderId;
    }
}
