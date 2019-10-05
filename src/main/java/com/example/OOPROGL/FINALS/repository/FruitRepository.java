package com.example.OOPROGL.FINALS.repository;

import com.example.OOPROGL.FINALS.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<Fruit,Long> {
}
