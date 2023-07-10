package com.musicworld.musicworld.controller;

import com.musicworld.musicworld.converter.AppUserConverter;
import com.musicworld.musicworld.dto.AppUserDTO;
import com.musicworld.musicworld.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/appUsers")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private AppUserConverter appUserConverter;

    @GetMapping("/all")
    public List<AppUserDTO> getAllAppUsers(){
        return appUserService.getAppUsers().stream().map(appUser -> appUserConverter.convertEntityToDto(appUser))
                .collect(Collectors.toList());
    }

    @GetMapping("/appUser/{id}")
    public AppUserDTO getAppUser(@PathVariable Long id){
        if(appUserService.getAppUserById(id) == null){
            return null;
        }
        return appUserConverter.convertEntityToDto(appUserService.getAppUserById(id));
    }

    @PostMapping("/add")
    public AppUserDTO addRecord(@RequestBody AppUserDTO appUserDTO){
        return appUserConverter.convertEntityToDto(appUserService.createAppUser
                (appUserConverter.convertDtoToEntity(appUserDTO)));
    }

    @PutMapping("/update")
    public AppUserDTO updateRecord(@RequestBody AppUserDTO appUserDTO){
        return appUserConverter.convertEntityToDto(appUserService.updateAppUser
                (appUserConverter.convertDtoToEntity(appUserDTO)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRecord(@PathVariable Long id){
        appUserService.deleteAppUser(id);
    }
}