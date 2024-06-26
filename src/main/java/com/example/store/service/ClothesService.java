package com.example.store.service;

import com.example.store.jpa.entity.ClothesEntity;
import com.example.store.jpa.repository.ClothesRepository;
import com.example.store.mapper.ClothesMapper;
import com.example.store.model.Clothes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClothesService {

    private final ClothesRepository clothesRepository;

    public ClothesEntity createClothes(Clothes clothes) {
        ClothesEntity entity = ClothesMapper.INSTANCE.toEntity(clothes);
        clothesRepository.save(entity);
        Optional<ClothesEntity> savedEntity = clothesRepository.findById(entity.getId());
        return savedEntity.orElseThrow(NoSuchElementException::new);
    }

    public List<ClothesEntity> createClothesList(List<Clothes> clothesList) {
        List<ClothesEntity> savedEntityList = new ArrayList<>();

        for (Clothes clothes : clothesList) {
            ClothesEntity entity = ClothesMapper.INSTANCE.toEntity(clothes);
            clothesRepository.save(entity);
            Optional<ClothesEntity> savedEntity = clothesRepository.findById(entity.getId());
            savedEntityList.add(savedEntity.orElseThrow(NoSuchElementException::new));
        }

        return savedEntityList;
    }

}
