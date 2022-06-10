package com.doth.user.manager.ui.controller;

import com.doth.user.manager.service.implementation.UserServiceImplementation;
import com.doth.user.manager.shared.dto.UserDto;
import com.doth.user.manager.ui.model.request.UserDetailsRequestModel;
import com.doth.user.manager.ui.model.response.UserDetailsResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    final UserServiceImplementation userService;

    public UserController(UserServiceImplementation userService) {
        this.userService = userService;
    }

    @GetMapping(path="/{userId}")
    public UserDetailsResponseModel getUser(@PathVariable String userId){
        UserDetailsResponseModel returnValue = new UserDetailsResponseModel();

        UserDto savedValue = userService.findByUserId(userId);

        BeanUtils.copyProperties(savedValue, returnValue);

        return  returnValue;
    }

    @PostMapping
    public UserDetailsResponseModel createUser(@RequestBody UserDetailsRequestModel userDetails){

        UserDetailsResponseModel returnValue = new UserDetailsResponseModel();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto savedValue = userService.createUser(userDto);

        BeanUtils.copyProperties(savedValue, returnValue);

        return  returnValue;
    }

    @PutMapping
    public String updateUser(){
        return  "update user";
    }

    @DeleteMapping
    public String deleteUser(){
        return  "delete user";
    }
}
