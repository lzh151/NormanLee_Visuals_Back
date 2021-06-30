package com.cn.normanleevisuals.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public int getUserByLoginName(@Param("userName") String userName, @Param("password") String password);
}
