package com.dapeng.ces.util;

import java.util.UUID;

/**
 * 主键生成器
 * 
 * @author DS
 *
 */
public class PrimaryKeyGenerator {
    /**
     * 随机生成32位主键
     * 
     * @return
     */
    public static String getUuid32() {
        UUID uuid = UUID.randomUUID();
        return String.valueOf(uuid).replaceAll("-", "").substring(0, 32);
    }

    /**
     * 随机生成32位主键
     * 
     * @return
     */
    public static String getUuid16() {
        UUID uuid = UUID.randomUUID();
        return String.valueOf(uuid).replaceAll("-", "").substring(0, 16);
    }
}
