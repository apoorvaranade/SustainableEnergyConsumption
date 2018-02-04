package com.me.sustainable.living.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.me.sustainable.living.model.core.EntityType;
import com.me.sustainable.living.model.core.User;
import com.me.sustainable.living.model.resource.AbstractEnergySource;
import com.me.sustainable.living.service.DelegatorService;
import com.me.sustainable.living.service.IService;
import com.me.sustainable.living.service.UserService;

@RequestMapping("sustainableLiving/")
@RestController
public class Controller {
	
	@Autowired
	@Qualifier("delegatorService")
	private DelegatorService<?> delegatorService;
	
	 @RequestMapping("/test")
	    public Map<String,String> sample(@RequestParam(value="name", defaultValue="World") String name) {
	    Map<String,String> result = new HashMap<>();
	    result.put("message", String.format("Hello, %s", name));
	    return result;
	    }
	 
	 
	@SuppressWarnings("unchecked")
	@RequestMapping("/getUser")
    public User getUser(@RequestParam(value="userId") int userId) {
		return ((IService<User>) delegatorService.getService(EntityType.USER)).getEntity(userId);
		
    }
	
	@RequestMapping(value = "/saveHomeResources", method = RequestMethod.POST ,consumes="application/json")
    public ResponseEntity<List<AbstractEnergySource>>  saveHomeResources(@RequestBody List<AbstractEnergySource> energyResourceList ) {
		
		((UserService) delegatorService.getService(EntityType.USER)).setHomeResources(energyResourceList, 1);
		
		return new ResponseEntity<List<AbstractEnergySource>>(energyResourceList, HttpStatus.OK);
		
    }
	
	@RequestMapping(value = "/getConsumption", method = RequestMethod.GET ,produces="application/json")
    public List<AbstractEnergySource> getConsumption(@RequestParam(value="userId") int userId) {
		return ((UserService) delegatorService.getService(EntityType.USER)).getConsumption( userId); 
		
    }
	
	
}
