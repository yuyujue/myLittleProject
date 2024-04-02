package com.example.mylittleproject.controller;

import com.example.mylittleproject.controller.request.CreateClothesCsvRequest;
import com.example.mylittleproject.controller.request.CreateClothesRequest;
import com.example.mylittleproject.jpa.entity.ClothesEntity;
import com.example.mylittleproject.mapper.ClothesMapper;
import com.example.mylittleproject.model.Clothes;
import com.example.mylittleproject.service.ClothesService;
import com.example.mylittleproject.util.CsvUtil;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClothesController {

    private final ClothesService clothesService;
    private final CsvUtil csvUtil;

    @PostMapping("/create-clothes")
    public ClothesEntity createClothes(@RequestBody CreateClothesRequest createClothesRequest) {
        Clothes clothes = ClothesMapper.INSTANCE.requestToModel(createClothesRequest);
        return clothesService.createClothes(clothes);
    }

    @SneakyThrows
    @PostMapping("/create-clothes-csv")
    public List<ClothesEntity> createClothesCsv(@RequestBody CreateClothesCsvRequest createClothesRequest) {
        List<Clothes> clothesList = csvUtil.readClothesFromCsv(createClothesRequest.csvFilePath());
        return clothesService.createClothesList(clothesList);
    }
}
