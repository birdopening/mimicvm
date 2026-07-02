package com.mimicvm.shared.type;

public record Value(Type type, long bits) {

    public Value {
        if (type == null) {
            throw new IllegalArgumentException("type must not be null");
        }
    }

    public static Value i32(int data) {
        return new Value(Type.I32, data);
    }

    public int data() {
        return (int) bits;
    }
}
