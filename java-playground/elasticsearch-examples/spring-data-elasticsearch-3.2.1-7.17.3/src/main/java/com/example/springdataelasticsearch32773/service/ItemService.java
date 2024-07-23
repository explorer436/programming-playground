package com.example.springdataelasticsearch32773.service;

import com.example.springdataelasticsearch32773.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> findByName(String itemName);

    List<Item> findByCategory(String category);

    List<Item> findByPriceBetween(double low, double high);
}
