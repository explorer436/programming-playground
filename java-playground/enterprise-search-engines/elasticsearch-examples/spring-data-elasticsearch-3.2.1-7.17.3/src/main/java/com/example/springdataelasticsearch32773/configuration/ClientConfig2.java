package com.example.springdataelasticsearch32773.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

/*@Configuration
@Slf4j
public class ClientConfig2 extends ElasticsearchConfiguration {

    //This will work if elasticsearch is started with security disabled (xpack.security.enabled=false)

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder().connectedTo("localhost:9200").build();
    }
}*/
