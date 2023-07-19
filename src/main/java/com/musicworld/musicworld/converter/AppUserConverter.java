package com.musicworld.musicworld.converter;

import com.musicworld.musicworld.dto.AppUserDTO;
import com.musicworld.musicworld.model.AppUser;
import com.musicworld.musicworld.service.AppUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AppUserConverter {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private OrderConverter orderConverter;

    public AppUserDTO convertEntityToDto(AppUser appUser){
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<AppUser, AppUserDTO> typeMap = modelMapper.createTypeMap(AppUser.class, AppUserDTO.class);
        typeMap.addMappings(mapper -> mapper.skip((AppUserDTO::setPassword)));
        AppUserDTO map = modelMapper.map(appUser, AppUserDTO.class);
        if(appUser.getOrders() != null) {
            map.setOrders(appUser.getOrders()
                    .stream()
                    .map(order -> orderConverter.convertEntityToDto(order))
                    .collect(Collectors.toSet()));
        }
        return map;
    }

    public AppUser convertDtoToEntity(AppUserDTO appUserDTO){
        ModelMapper modelMapper = new ModelMapper();
        AppUser map = modelMapper.map(appUserDTO, AppUser.class);
        if(appUserDTO.getId() != null) {
            AppUser existingAppUser = appUserService.getAppUserById(appUserDTO.getId());
            checkAppUserFields(appUserDTO, map, existingAppUser);
        }
        return map;
    }

    private void checkAppUserFields(AppUserDTO appUserDTO, AppUser map, AppUser existingAppUser) {
        if(appUserDTO.getUsername() == null){
            map.setUsername(existingAppUser.getUsername());
        }
        if(appUserDTO.getEmail() == null){
            map.setEmail(existingAppUser.getEmail());
        }
        if(appUserDTO.getPassword() == null){
            map.setPassword(existingAppUser.getPassword());
        }
        if(appUserDTO.getOrders() == null){
            map.setOrders(existingAppUser.getOrders());
        }
    }
}