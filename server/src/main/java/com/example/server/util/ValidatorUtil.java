package com.example.server.util;

import com.example.server.exception.ValidatorException;
import org.springframework.util.StringUtils;

/**
 * @author ：vivaciousis
 * @date ：Created in 2020/5/31 21:17
 * @description：数据验证工具
 */
public class ValidatorUtil {

    /**
     * 空校验（null or ""）
     */
    public static void require(String str, String fieldName) {
        if (StringUtils.isEmpty(str)) {
            throw new ValidatorException(fieldName + "不能为空");
        }
    }

    /**
     * 长度校验
     */
    public static void length(String str, String fieldName, int min, int max) {
        int length = 0;
        if (!StringUtils.isEmpty(str)) {
            length = str.length();
        }
        if (length < min || length > max) {
            throw new ValidatorException(fieldName + "长度" + min + "~" + max + "位");
        }
    }

}
