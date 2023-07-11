package com.zpy.service;

import com.zpy.pojo.Account;

public interface AccountService {
    boolean login(String user,String password);

    boolean updatePwd(Account account);
}
