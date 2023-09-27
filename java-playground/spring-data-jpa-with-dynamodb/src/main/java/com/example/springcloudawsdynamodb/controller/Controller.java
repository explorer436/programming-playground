package com.example.springcloudawsdynamodb.controller;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.example.springcloudawsdynamodb.entities.ProductInfoEntity;
import com.example.springcloudawsdynamodb.entities.SubObject;
import com.example.springcloudawsdynamodb.repositories.ProductInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class Controller {

    private final ProductInfoRepository productInfoRepository;

    private final AmazonDynamoDB amazonDynamoDB;

    @PostMapping("/productInfo")
    public ResponseEntity<ProductInfoEntity> createProductInfo(@RequestBody ProductInfoEntity productInfo) {

        log.info(">>> createProductInfo");

        ProductInfoEntity productInfo2 = new ProductInfoEntity();
        productInfo2.setMsrp("$100.00");
        productInfo2.setCost("$120.00");
        productInfo2.setCanBeSold(Boolean.TRUE);

        SubObject subObject = new SubObject();
        subObject.setTestAttribute1("test attribute 1");
        subObject.setTestAttribute2("test attribute 2");
        productInfo2.setSubObject(subObject);

        try {

            log.info("ProductInfoEntity to be inserted: " + productInfo2.toString());

            ProductInfoEntity _productInfo = productInfoRepository.save(productInfo2);

            log.info("inserted ProductInfoEntity: " + _productInfo.toString());

            return new ResponseEntity<>(_productInfo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/productInfo")
    public ResponseEntity<List<ProductInfoEntity>> getAllProductInfoEntities(@RequestParam(required = false) String title) {
        try {
            List<ProductInfoEntity> productInfos = new ArrayList<ProductInfoEntity>();

            productInfoRepository.findAll().forEach(productInfos::add);

            if (productInfos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(productInfos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createTable")
    public ResponseEntity<Void> createTable(@RequestBody ProductInfoEntity productInfo) {
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(ProductInfoEntity.class);
        tableRequest.setProvisionedThroughput(
                new ProvisionedThroughput(1L, 1L));
        amazonDynamoDB.createTable(tableRequest);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}