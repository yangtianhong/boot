package com.tian.boot.one.mapper;

import com.tian.boot.common.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


/**
 * Created by yingxh on 2017/1/18.
 */
@Service
public interface OneUserMapper {

    public void insertUser(User user);

	public User selectByPrimaryKey(@Param(value = "id") Integer id);
}
