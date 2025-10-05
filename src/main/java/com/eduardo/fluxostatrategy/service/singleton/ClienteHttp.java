package com.eduardo.fluxostatrategy.service.singleton;

import com.eduardo.fluxostatrategy.exception.customizadas.WebClientResponseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Component
public class ClienteHttp {
    private final WebClient webClient;

    @Autowired
    public ClienteHttp(WebClient webClient) {
        this.webClient = webClient;
    }

    private WebClient.ResponseSpec buildRequestSpec(String url, HttpMethod metodo, @Nullable Object body, @Nullable HttpHeaders headers) {
        WebClient.RequestBodyUriSpec uriSpec = (WebClient.RequestBodyUriSpec) webClient.method(metodo).uri(url);

        log.info("Realizando [{}] para: [{}]", metodo, url);

        if (headers != null && !headers.isEmpty()) {
            uriSpec.headers(h -> h.addAll(headers));
        }

        WebClient.ResponseSpec responseSpec;

        if (body != null && (metodo == HttpMethod.POST || metodo == HttpMethod.PUT)) {
            responseSpec = uriSpec.bodyValue(body).retrieve();
        } else {
            responseSpec = uriSpec.retrieve();
        }

        return responseSpec
                .onStatus(status -> status.isError(),
                        response -> response.bodyToMono(String.class)
                                .flatMap(errorBody -> {
                                    String msgErro = "Erro HTTP: [" + response.statusCode() + "] Body Error:" + errorBody;
                                    return Mono.error(new WebClientResponseException(msgErro));
                                })
                );
    }

    public <T> T fazerRequisicao(String url, HttpMethod metodo, @Nullable Object body, @Nullable HttpHeaders headers) {
        try {
            return buildRequestSpec(url, metodo, body, headers)
                    .bodyToMono(new ParameterizedTypeReference<T>() {
                    })
                    .block();
        } catch (Exception e) {
            String msgErro = "Erro inesperado na requisição: " + e.getMessage();
            throw new WebClientResponseException(msgErro);
        }
    }

    public <T> List<T> fazerRequisicaoLista(String url, HttpMethod metodo, @Nullable Object body, @Nullable HttpHeaders headers) {
        try {
            return buildRequestSpec(url, metodo, body, headers)
                    .bodyToMono(new ParameterizedTypeReference<List<T>>() {
                    })
                    .block();
        } catch (Exception e) {
            String msgErro = "Erro inesperado na requisição: " + e.getMessage();
            throw new WebClientResponseException(msgErro);
        }
    }
}