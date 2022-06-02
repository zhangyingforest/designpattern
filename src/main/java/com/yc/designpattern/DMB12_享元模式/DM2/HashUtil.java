package com.yc.designpattern.DMB12_享元模式.DM2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: design-pattern-yc
 * @description: HashUtil工具类
 */
public class HashUtil {
    //根据key获取 hash值   MD5算法
    public static String computeHashId(String key) {
        String cacheKey;
        try {
            final MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(    key.getBytes()    );
            cacheKey = bytesToHexString(mDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            cacheKey = String.valueOf(key.hashCode());
        }
        return cacheKey;
    }

    //将hash值回传为  String的键
    private static String bytesToHexString(byte[] bytes) {
        // http://stackoverflow.com/questions/332079
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}
