package com.ndd.pasturelogin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author ndd
 * @version 2.x
 * @date 2020/4/21 15:10
 */
@Mapper
public interface LoginMapper {
    @Select("select password from user_info where user_account=#{userAccount}")
    public String selectUserPasswordByuserAccount(String userAccount);

    @Update("update user_info set password=#{password} where user_account=#{userAccount}")
    public void updateUserpasswordByuserAccount(String userAccount,String password);
}
