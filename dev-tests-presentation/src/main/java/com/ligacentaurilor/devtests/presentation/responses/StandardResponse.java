package com.ligacentaurilor.devtests.presentation.responses;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class StandardResponse<T extends Serializable> {

    private List<T> data = new LinkedList<>();

    public void addItem(T object) {
        data.add(object);
    }

    public List<T> getData() {
        return data;
    }
}
