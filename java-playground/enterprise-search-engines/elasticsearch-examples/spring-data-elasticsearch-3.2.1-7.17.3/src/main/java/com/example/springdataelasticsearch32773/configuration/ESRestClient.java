package com.example.springdataelasticsearch32773.configuration;

import co.elastic.clients.transport.TransportUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

import javax.net.ssl.SSLContext;
import java.net.URI;

@Configuration
@Slf4j
public class ESRestClient extends ElasticsearchConfiguration {

    @Value("${elasticsearch.url}")
    private String elasticsearchUrl;
    @Value("${elasticsearch.hostname}")
    private String hostname;
    @Value("${elasticsearch.port}")
    private Integer port;
    @Value("${elasticsearch.username}")
    private String username;
    @Value("${elasticsearch.password}")
    private String password;

    @Override
    public ClientConfiguration clientConfiguration() {
        String fingerprint = "55f8d706125b0a54896e7e457842e1d4a036a8cb413199de3489a38d701016b0";
        SSLContext sslContext = TransportUtils
                .sslContextFromCaFingerprint(fingerprint);

        // final String stringUrl = System.getenv("ELASTICSEARCH_URL");
        final URI uri = URI.create(elasticsearchUrl);

        String host = uri.getHost();
        int port = uri.getPort() == -1 ? 9200 : uri.getPort();
        final ClientConfiguration.MaybeSecureClientConfigurationBuilder builder =
                ClientConfiguration.builder().connectedTo(host + ":" + port);

        // enable SSL if https is being used in the URL
        boolean isSsl = "https".equals(uri.getScheme());
        if (isSsl) {
            builder.usingSsl(sslContext);
            builder.withBasicAuth(username, password);
        }

        return builder.build();
    }
}
