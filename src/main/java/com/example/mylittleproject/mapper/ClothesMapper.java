package com.example.mylittleproject.mapper;

import com.example.mylittleproject.controller.request.CreateClothesRequest;
import com.example.mylittleproject.jpa.entity.ClothesEntity;
import com.example.mylittleproject.model.Clothes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClothesMapper {

    ClothesMapper INSTANCE = Mappers.getMapper(ClothesMapper.class);

    ClothesEntity toEntity(Clothes clothes);

    Clothes toModel(ClothesEntity clothesEntity);

    Clothes requestToModel(CreateClothesRequest createClothesRequest);

}
