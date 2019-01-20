package com.jack.service;

import com.jack.entity.User;
import com.jack.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description
 * <p>
 * </p>
 * DATE 2018/3/13.
 *
 * @author liweijian.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> listUser() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        return userMapper.selectUser();
    }

    public int addUser(User user) {
        return userMapper.addUser(user);
    }
}
