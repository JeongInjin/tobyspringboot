package com.me.spring.tobyspring.pay;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalPayClient implements PayClient{
    @Override
    public void pay(int money) {
      log.info("local 결제 money={}", money);
    }
}
