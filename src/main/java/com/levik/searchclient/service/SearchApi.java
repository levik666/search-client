package com.levik.searchclient.service;

import com.levik.searchclient.dto.SearchResponse;

public interface SearchApi {

    SearchResponse search(String tokens);
}
