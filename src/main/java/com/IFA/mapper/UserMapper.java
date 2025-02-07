package com.IFA.mapper;

import com.IFA.entity.Users;
import com.IFA.model.request.UsersRequest;
import org.springframework.beans.BeanUtils;

public class UserMapper {

    public  static Users toUser(UsersRequest usersRequest){
        Users users = new Users();
        BeanUtils.copyProperties(usersRequest, users);
        return users;
    }
}