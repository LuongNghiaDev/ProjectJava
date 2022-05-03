package com.laptrinhjavaweb.api.web;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterAPI {

    @Autowired
    private IRegisterService registerService;

    @PostMapping("/api/addUser")
    public UserEntity addUser(@RequestBody UserDTO dto){
        return registerService.addUserWithRole(dto);
    }

}
