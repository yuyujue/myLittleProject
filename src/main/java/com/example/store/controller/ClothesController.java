package com.example.store.controller;

import com.example.store.controller.request.CreateClothesCsvRequest;
import com.example.store.controller.request.CreateClothesRequest;
import com.example.store.jpa.entity.ClothesEntity;
import com.example.store.mapper.ClothesMapper;
import com.example.store.model.Clothes;
import com.example.store.service.ClothesService;
import com.example.store.util.CsvUtil;
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
