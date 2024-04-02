package com.example.mylittleproject.controller;

import com.example.mylittleproject.controller.request.CreateClothesRequest;
import com.example.mylittleproject.jpa.entity.ClothesEntity;
import com.example.mylittleproject.mapper.ClothesMapper;
import com.example.mylittleproject.model.Clothes;
import com.example.mylittleproject.service.ClothesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ClothesController {

    private final ClothesService clothesService;

    @PostMapping("/create-clothes")
    public ClothesEntity createClothes(@RequestBody CreateClothesRequest createClothesRequest) {
        Clothes clothes = ClothesMapper.INSTANCE.requestToModel(createClothesRequest);
        return clothesService.createClothes(clothes);
    }
}
