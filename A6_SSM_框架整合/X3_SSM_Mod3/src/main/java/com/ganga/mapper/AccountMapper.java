package com.ganga.mapper;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    /**
     * 转出
     * @param user 转出人
     * @param money 转出的钱
     */
    void out(@Param("user")String user, @Param("money")double money);

    /**
     * 转入
     * @param user 转入人
     * @param money 转入的钱
     */
    void in(@Param("user")String user,@Param("money")double money);

}
