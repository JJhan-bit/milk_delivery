package com.zpy.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mysql.jdbc.StringUtils;
import com.zpy.mapper.AccountMapper;
import com.zpy.pojo.Account;
import com.zpy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    @Override
    public boolean login(String user, String password) {
        QueryWrapper<Account>qw=new QueryWrapper<>();
        qw.eq("user_name",user);
        Account account=accountMapper.selectOne(qw);
        if (account==null){
            return false;
        }
        String userPwd = account.getUserPwd();
        String s = DigestUtil.md5Hex(password);
        if (Objects.equals(userPwd,s)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updatePwd(Account account) {
        String userName = account.getUserName();
        QueryWrapper<Account>qw=new QueryWrapper<>();
        qw.eq("user_name",userName);
        int update = accountMapper.update(account, qw);
        if (update>0){
            return true;
        }else {
            return false;
        }
    }
}
