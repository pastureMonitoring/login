package com.ndd.pasturelogin.service;

import com.ndd.pasturelogin.component.security.AES;
import com.ndd.pasturelogin.component.security.MD5;
import com.ndd.pasturelogin.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ndd
 * @version 2.x
 * @date 2020/4/21 15:09
 */
@Service
public class LoginService {

    @Autowired
    LoginMapper loginMapper;

    public boolean loginJudge(String userAccount,String password){
        //判断AES加密
        String aesEncode= AES.AESEncode("encoding",password);
        //应用MD5加密,获得固定32位长的结果数据
        String md5Data= MD5.strToMD5(aesEncode);
        System.out.println(md5Data+",长度为:"+md5Data.length());
        //从数据库中取出数据
        String passwordByuserAccount = loginMapper.selectUserPasswordByuserAccount(userAccount);
        if(passwordByuserAccount.equals(md5Data)) return true;
        return false;
//        loginMapper.updateUserpasswordByuserAccount(userAccount,md5Data);
//        return true;
    }
}
