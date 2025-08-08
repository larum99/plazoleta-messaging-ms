package com.messaging.messaging.messaging.infrastructure.adapters.twilio;

import com.messaging.messaging.messaging.domain.ports.out.CodeSenderPort;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;

import static com.messaging.messaging.messaging.infrastructure.utils.constants.Constants.TWILIO_PHONE_NUMBER;

public class CodeSenderAdapter implements CodeSenderPort {
    @Value(TWILIO_PHONE_NUMBER)
    private String fromNumber;

    @Override
    public void sendMessage(String phoneNumber, String message) {
        Message.creator(
                new PhoneNumber(phoneNumber),
                new PhoneNumber(fromNumber),
                message
        ).create();
    }
}

