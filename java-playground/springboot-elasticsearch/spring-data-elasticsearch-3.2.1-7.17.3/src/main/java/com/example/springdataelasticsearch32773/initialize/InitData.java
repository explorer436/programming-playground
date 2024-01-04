package com.example.springdataelasticsearch32773.initialize;

import com.example.springdataelasticsearch32773.model.Item;
import com.example.springdataelasticsearch32773.repositories.ItemRepository;
import com.example.springdataelasticsearch32773.service.CSVParser;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class InitData {
    private final ItemRepository itemRepository;
    private final CSVParser csvParser;
    @PostConstruct
    public void setupData() {
        List<Item> itemList = csvParser.csvParser("items.csv");
        itemRepository.saveAll(itemList);
    }
}