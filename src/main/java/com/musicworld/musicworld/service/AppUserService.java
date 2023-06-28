package com.musicworld.musicworld.service;

import com.musicworld.musicworld.model.AppUser;
import com.musicworld.musicworld.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public void getAppUserById(Long id) {
        AppUser appUser = appUserRepository.findById(id);
        System.out.println(appUser.getUsername());
    }

    public void createAppUser(AppUser appUser) {
        appUserRepository.create(appUser);
        getAppUserById(appUser.getId());
    }

    public void updateAppUser(AppUser existingAppUser) {
        appUserRepository.update(existingAppUser);
        getAppUserById(existingAppUser.getId());
    }

    public void deleteAppUser(Long id) {
        appUserRepository.delete(id);
    }
}