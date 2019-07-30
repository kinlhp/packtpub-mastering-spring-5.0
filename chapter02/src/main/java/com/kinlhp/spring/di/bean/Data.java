package com.kinlhp.spring.di.bean;

import java.util.OptionalInt;

public class Data {
    private final int value;

    public Data(final int value) {
        this.value = value;
    }

    public OptionalInt getValue() {
        return OptionalInt.of(value);
    }
}
