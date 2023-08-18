package com.jac.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jac.mpdemo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 以下皆为mybatis的写法
     */

    // 查询所有用户
    // @Select("select * from user")
    // public List<User> find();

    // 插入新用户
    // @Insert("insert into user values(#{id}, #{username}, #{password}, #{birthday    })")
    // public int insert(User user);
}
