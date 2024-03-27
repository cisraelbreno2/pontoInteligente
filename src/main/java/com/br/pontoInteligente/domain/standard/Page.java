package com.br.pontoInteligente.domain.standard;

import java.util.List;

public class Page<T> {
    private final List<T> content;
    private final int pageSize;
    private final int pageNumber;

    public Page(List<T> content, int pageSize, int pageNumber) {
        this.content = content;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public List<T> getContent() {
        return content;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

}
