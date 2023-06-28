package com.musicworld.musicworld.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class BaseModel {
    @Id
    @GeneratedValue
    private Long id;
}