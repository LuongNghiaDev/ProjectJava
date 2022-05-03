package com.laptrinhjavaweb.service;


import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;

public interface IRegisterService {

    UserEntity addUserWithRole(UserDTO dto);
}
