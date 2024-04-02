package com.example.mylittleproject.service;

import com.example.mylittleproject.jpa.entity.ClothesEntity;
import com.example.mylittleproject.jpa.repository.ClothesRepository;
import com.example.mylittleproject.mapper.ClothesMapper;
import com.example.mylittleproject.model.Clothes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

}
