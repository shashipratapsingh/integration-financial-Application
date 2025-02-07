package com.IFA.service.impl;

import com.IFA.entity.Users;
import com.IFA.mapper.UserMapper;
import com.IFA.model.request.UsersRequest;
import com.IFA.repository.UsersRepository;
import com.IFA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository repository;

    @Override
    public int createUser(UsersRequest usersRequest) {
        Users users = UserMapper.toUser(usersRequest);
        users = repository.save(users);
        return users.getId();
    }
}
