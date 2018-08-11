package com.levik.searchclient.service.impl;

import com.levik.searchclient.configuration.property.SearchProperties;
import com.levik.searchclient.dto.SearchResponse;
import com.levik.searchclient.service.SearchApi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SearchApiService implements SearchApi {

    private static final String API = "/api/v1";
    private static final String SEARCH = "/search";
    private static final String TOKENS_PARAM = "tokens";

    private final RestTemplate restTemplate;
    private final SearchProperties searchProperties;

    public SearchApiService(RestTemplate restTemplate, SearchProperties searchProperties) {
        this.restTemplate = restTemplate;
        this.searchProperties = searchProperties;
    }

    public SearchResponse search(String tokens) {
        UriComponents uriSearchComponents = UriComponentsBuilder.newInstance()
                .scheme(searchProperties.getSchema()).host(searchProperties.getHost())
                .port(searchProperties.getPort()).path(API)
                .path(SEARCH).queryParam(TOKENS_PARAM, tokens).build();
        ResponseEntity<SearchResponse> forEntity = restTemplate.getForEntity(uriSearchComponents.toUri(), SearchResponse.class);
        return forEntity.getBody();
    }


}
