package com.qirsam.http.service;

import com.qirsam.http.dao.UserDao;
import com.qirsam.http.dto.CreateUserDto;
import com.qirsam.http.entity.User;
import com.qirsam.http.exception.ValidationException;
import com.qirsam.http.mapper.CreateUserMapper;
import com.qirsam.http.validator.CreateUserValidator;
import com.qirsam.http.validator.ValidationResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.*;

@NoArgsConstructor(access = PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();

    public Integer create(CreateUserDto userDto) {
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.mapFrom(userDto);
        userDao.save(userEntity);

//         validation
//         map dto --> entity
//         userDao.save
//        return Id (entity)
        return userEntity.getId();
    }


    public static UserService getInstance() {
        return INSTANCE;
    }
}
