package com.messaging.messaging.messaging.infrastructure.utils.constants;

import jakarta.servlet.http.PushBuilder;

public class ControllerConstants {
    private ControllerConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String BASE_URL = "api/v1/messaging";
    public static final String SEND_CODE_PATH = "/send-code";
}
