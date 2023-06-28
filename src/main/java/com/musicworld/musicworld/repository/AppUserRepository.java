package com.musicworld.musicworld.repository;

import com.musicworld.musicworld.model.AppUser;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserRepository extends ParentRepository<AppUser> {

    @Override
    public Class<AppUser> getEntityClass(){
        return AppUser.class;
    }

}