package com.example.store.mapper;

import com.example.store.controller.request.CreateClothesRequest;
import com.example.store.jpa.entity.ClothesEntity;
import com.example.store.model.Clothes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClothesMapper {

    ClothesMapper INSTANCE = Mappers.getMapper(ClothesMapper.class);

    ClothesEntity toEntity(Clothes clothes);

    Clothes toModel(ClothesEntity clothesEntity);

    Clothes requestToModel(CreateClothesRequest createClothesRequest);

}
