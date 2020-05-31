package com.example.server.exception;

/**
 * @author ：vivaciousis
 * @date ：Created in 2020/5/31 21:16
 * @description：验证异常
 */
public class ValidatorException extends RuntimeException{

    public ValidatorException(String message) {
        super(message);
    }
}
