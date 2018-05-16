package com.nju.training.dao;

import com.nju.training.model.Account;
import com.nju.training.util.ResultMessage.AccountMessage;

public interface AccountDao {
    public int getAccountLength();

    public Account getAccount(String id);

    public AccountMessage pay(String id, double money);

    public AccountMessage income(String id, double money);
}
