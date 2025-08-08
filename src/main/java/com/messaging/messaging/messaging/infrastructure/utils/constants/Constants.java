package com.messaging.messaging.messaging.infrastructure.utils.constants;

public class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String TWILIO_PHONE_NUMBER = "${twilio.phone.number}";
}
