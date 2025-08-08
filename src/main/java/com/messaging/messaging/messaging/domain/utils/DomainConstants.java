package com.messaging.messaging.messaging.domain.utils;

public class DomainConstants {
    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final int CODE_BASE = 100_000;
    public static final int CODE_RANGE = 900_000;
    public static final String ORDER_READY_CODE_MESSAGE = "Tu código de verificación para reclamar el pedido es: ";

}
