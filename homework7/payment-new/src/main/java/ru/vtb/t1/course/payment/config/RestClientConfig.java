package ru.vtb.t1.course.payment.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import ru.vtb.t1.course.payment.config.properties.ClientProperties;

@Configuration
@EnableConfigurationProperties(value = ClientProperties.class)
public class RestClientConfig {

    private final ClientProperties clientProperties;

    public RestClientConfig(ClientProperties clientProperties) {
        this.clientProperties = clientProperties;
    }

    @Bean
    @ConditionalOnProperty(prefix = "integration.product-client", name = "enabled", havingValue = "true")
    public RestClient getProductRestClient() {
        var productClient = clientProperties.getProductClient();
        return RestClient.builder()
                .baseUrl(productClient.getUrl())
                .build();
    }
}
