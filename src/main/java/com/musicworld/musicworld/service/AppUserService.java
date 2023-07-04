package com.musicworld.musicworld.service;

import com.musicworld.musicworld.model.AppUser;
import com.musicworld.musicworld.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    public List<AppUser> getAppUsers() {
        return appUserRepository.findAll();
    }

    public AppUser getAppUserById(Long id) {
        return appUserRepository.findById(id);
    }

    public AppUser createAppUser(AppUser appUser) {
        return appUserRepository.create(appUser);
    }

    public AppUser updateAppUser(AppUser existingAppUser) {
        return appUserRepository.update(existingAppUser);
    }

    public void deleteAppUser(Long id) {
        appUserRepository.delete(id);
    }
}