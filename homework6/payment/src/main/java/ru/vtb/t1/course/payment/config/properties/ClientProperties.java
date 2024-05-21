package ru.vtb.t1.course.payment.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "integration")
public class ClientProperties {

    private Client productClient;

    public Client getProductClient() {
        return productClient;
    }

    public void setProductClient(Client productClient) {
        this.productClient = productClient;
    }

    public static class Client {

        private String enabled;

        private String url;

        public String getEnabled() {
            return enabled;
        }

        public String getUrl() {
            return url;
        }

        public void setEnabled(String enabled) {
            this.enabled = enabled;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
