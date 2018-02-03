package com.me.sustainable.living.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.me.sustainable.living.model.core.EntityType;
import com.me.sustainable.living.model.core.User;
import com.me.sustainable.living.service.DelegatorService;

@RestController
public class Controller {
	DelegatorService delegatorService;
	@RequestMapping("/getUser")
    public User getUser(@RequestParam("userId") int userId) {
        return (User) delegatorService.getEntity(EntityType.USER).getEntity(userId);
    }
	
}
