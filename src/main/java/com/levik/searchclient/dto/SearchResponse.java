package com.levik.searchclient.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SearchResponse<T> {

    private Set<T> keys;

    public SearchResponse() {
        keys = new HashSet<>();
    }

    public SearchResponse(Set<T> keys) {
        this.keys = keys;
    }

    public Set<T> getKeys() {
        return keys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResponse<?> that = (SearchResponse<?>) o;
        return Objects.equals(keys, that.keys);
    }

    @Override
    public int hashCode() {

        return Objects.hash(keys);
    }
}
