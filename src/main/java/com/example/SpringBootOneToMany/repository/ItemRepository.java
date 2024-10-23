package com.example.SpringBootOneToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootOneToMany.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
