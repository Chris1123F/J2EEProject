package com.nju.training.util.ResultMessage;

public enum OrderMessage {
    booksuccess,//预定成功
    bookfail,//预定失败
    cancelsuccess,//取消成功
    paysuccess,//支付成功
    nobalance,//余额不足
    timesup,//自动取消
    cancelfail,
    dispaysuccess,//退订成功
    dispayfail,//退订失败
}
