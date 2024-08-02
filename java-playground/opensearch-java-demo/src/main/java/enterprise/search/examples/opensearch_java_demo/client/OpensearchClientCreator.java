package enterprise.search.examples.opensearch_java_demo.client;

import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.ClientTlsStrategyBuilder;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5Transport;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Component
@Slf4j
public class OpensearchClientCreator {

    @Value("${cloudsearch.url}")
    private String cloudsearchUrl;
    @Value("${cloudsearch.hostname}")
    private String hostname;
    @Value("${cloudsearch.port}")
    private Integer port;
    @Value("${cloudsearch.username}")
    private String username;
    @Value("${cloudsearch.password}")
    private String password;

    // Reference:
    // https://github.com/opensearch-project/opensearch-java/blob/main/samples/src/main/java/org/opensearch/client/samples/SampleClient.java

    public OpenSearchClient create() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        log.info(">>> create client()");

        var env = System.getenv();
        var https = Boolean.parseBoolean(env.getOrDefault("HTTPS", "false"));
        // var hostname = env.getOrDefault("HOST", "localhost");
        // var port = Integer.parseInt(env.getOrDefault("PORT", port));
        // var user = env.getOrDefault("USERNAME", "admin");
        // var pass = env.getOrDefault("PASSWORD", "admin");

        final HttpHost[] hosts = new HttpHost[]{new HttpHost(https ? "https" : "http", hostname, port)};

        final SSLContext sslContext = SSLContextBuilder.create().loadTrustMaterial(null, (chains, authType) -> true).build();

        final ApacheHttpClient5Transport transport = ApacheHttpClient5TransportBuilder.builder(hosts)
                .setMapper(new JacksonJsonpMapper())
                .setHttpClientConfigCallback(httpClientBuilder -> {

                    final var credentialsProvider = new BasicCredentialsProvider();
                    for (final var host : hosts) {
                        credentialsProvider.setCredentials(new AuthScope(host), new UsernamePasswordCredentials(username, password.toCharArray()));
                    }

                    // Disable SSL/TLS verification as our local testing clusters use self-signed certificates
                    final var tlsStrategy = ClientTlsStrategyBuilder.create()
                            .setSslContext(sslContext)
                            .setHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                            .build();

                    final var connectionManager = PoolingAsyncClientConnectionManagerBuilder.create().setTlsStrategy(tlsStrategy).build();

                    return httpClientBuilder
                            // .setDefaultCredentialsProvider(credentialsProvider)
                            .setConnectionManager(connectionManager);
                })
                .build();
        return new OpenSearchClient(transport);
    }
}
