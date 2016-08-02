package com.duncpro.msw.util;

public class Preconditions {
    public static void notNull(Object o, String message) {
        if (o == null) throw new IllegalArgumentException(message);
    }
}
