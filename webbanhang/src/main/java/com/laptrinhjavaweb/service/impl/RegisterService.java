package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.RegisterRepository;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RegisterService implements IRegisterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserEntity addUserWithRole(UserDTO dto) {
        RoleDTO roleDTO = new RoleDTO();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(dto.getId());
        userEntity.setUserName(dto.userName);
        userEntity.setFullName(dto.fullName);
        userEntity.setPassWord(dto.passWord);
        userEntity.setStatus(1);
        userEntity.setRoles(dto.roleEntityList
        .stream()
        .map(role -> {
            RoleEntity roles = role;
            roles.setId(roleDTO.getId());
            roles.setCode("USER");
            roles.setName("Người dùng");
            if(roles.getId() > 0){
                roles = roleRepository.findById(roles.getId());
            }
            roles.addRole(userEntity);
            return roles;
        })
        .collect(Collectors.toSet()));
        return userRepository.save(userEntity);
    }

}
