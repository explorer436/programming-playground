package com.example.springcloudawsdynamodb.config;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverterFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableDynamoDBRepositories
        (dynamoDBMapperConfigRef = "dynamoDBMapperConfig",
                basePackages = "com.example.springcloudawsdynamodb.repositories")
public class Config {

    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${aws.dynamodb.region}")
    private String amazonDynamoDBRegion;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {

        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder
                .standard()
                .withCredentials(new ProfileCredentialsProvider("default"))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(amazonDynamoDBEndpoint, amazonDynamoDBRegion))
                .build();

        return amazonDynamoDB;
    }

    @Bean
    public DynamoDBMapperConfig dynamoDBMapperConfig() {
        DynamoDBMapperConfig.Builder builder = new DynamoDBMapperConfig.Builder();
        builder.withTypeConverterFactory(DynamoDBTypeConverterFactory.standard());
        builder.withTableNameResolver(new DynamoDBMapperConfig.DefaultTableNameResolver() {
            @Override
            public String getTableName(Class<?> clazz, DynamoDBMapperConfig config) {
                String tableNameIdentifier = super.getTableName(clazz, config);

                // Identifier defined in the Entity definition.
                // See ProductInfoEntity - @DynamoDBTable(tableName = "ProductInfo")
                if (StringUtils.equalsIgnoreCase(tableNameIdentifier, "ProductInfo")) {

                    // log.info("Mapping dynamo db table {} -> {}", "ProductInfo", "product_table_name_from_aws_account");
                    log.info("Mapping identifier {} to dynamo db table {}", "ProductInfo", "ProductInfo");

                    // return "product_table_name_from_aws_account";
                    return "ProductInfo";
                } else {
                    throw new IllegalStateException("Unable to determine dynamo db table name");
                }

            }
        });
        return builder.build();
    }
}
