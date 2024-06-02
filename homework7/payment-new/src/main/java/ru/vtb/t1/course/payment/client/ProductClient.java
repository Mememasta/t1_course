package ru.vtb.t1.course.payment.client;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import ru.vtb.t1.course.payment.exception.ClientException;
import ru.vtb.t1.course.payment.model.ProductDTO;

import java.util.List;

@Component
public class ProductClient {

    private final RestClient productRestClient;

    public ProductClient(RestClient productRestClient) {
        this.productRestClient = productRestClient;
    }

    public List<ProductDTO> findProductsByUserId(Long userId) {
        try {
            return productRestClient.get()
                    .uri(uriBuilder ->
                            uriBuilder
                                    .path("api/v1/product")
                                    .queryParam("userId", userId)
                                    .build())
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, resp) -> {
                        throw new ClientException("Ошибка при обращении к сервису product", resp.getStatusCode(), resp.getStatusText());
                    })
                    .onStatus(HttpStatusCode::is5xxServerError, (req, resp) -> {
                        throw new ClientException("Ошибка на стороне сервиса product", resp.getStatusCode(), resp.getStatusText());
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
        } catch (Exception e) {
            throw new ClientException("Сервис недоступен", HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error");
        }
    }
}
