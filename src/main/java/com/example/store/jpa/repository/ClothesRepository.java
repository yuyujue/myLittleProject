package com.example.store.jpa.repository;

import com.example.store.jpa.entity.ClothesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClothesRepository extends JpaRepository<ClothesEntity, UUID> {

}
