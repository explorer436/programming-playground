package com.example.springcloudawsdynamodb.repositories;

import com.example.springcloudawsdynamodb.entities.ProductInfoEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface ProductInfoRepository extends CrudRepository<ProductInfoEntity, String> {
}
