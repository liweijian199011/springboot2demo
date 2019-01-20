package com.jack.mapper;

import com.jack.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Description
 * <p>
 * </p>
 * DATE 2018/3/13.
 *
 * @author liweijian.
 */
public interface UserMapper {

    @Select("select * from user")
    List<User> selectUser();

    @Insert("insert into user(username, password, age, gender) " +
            "values(#{username}, #{password}, #{age, jdbcType=INTEGER}, #{gender})")
    int addUser(User user);

    @Update("update user set username = #{username}, password=#{password}, age=#{age}, gender=#{gender} where id = #{id}")
    int updateUser(User user);
}
