package com.musicworld.musicworld.controller;

import com.musicworld.musicworld.model.AppUser;
import com.musicworld.musicworld.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appUsers")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;

    @GetMapping("/all")
    public List<AppUser> getAllAppUsers(){
        return appUserService.getAppUsers();
    }

    @GetMapping("/appUser/{id}")
    public AppUser getAppUser(@PathVariable Long id){
        return appUserService.getAppUserById(id);
    }

    @PostMapping("/add")
    public AppUser addAppUser(@RequestBody AppUser appUser){
        return appUserService.createAppUser(appUser);
    }

    @PutMapping("/update")
    public AppUser updateAppUser(@RequestBody AppUser existingAppUser){
        return appUserService.updateAppUser(existingAppUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAppUser(@PathVariable Long id){
        appUserService.deleteAppUser(id);
    }
}