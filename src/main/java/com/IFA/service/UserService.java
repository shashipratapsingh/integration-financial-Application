package com.IFA.service;

import com.IFA.model.request.UsersRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    int createUser(UsersRequest usersRequest);
}