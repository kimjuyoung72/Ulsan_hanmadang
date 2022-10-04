package com.kh.examAccount;

public class WithdrawException extends Throwable {
    public WithdrawException(String message) {
        System.out.println(message);
    }

    public WithdrawException(String message, Throwable cause) {
        super(message, cause);
    }

    public WithdrawException(Throwable cause) {
        super(cause);
    }

    public WithdrawException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public WithdrawException() {
    }
}
