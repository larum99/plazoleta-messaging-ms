package com.messaging.messaging.messaging.domain.ports.in;

public interface CodeSenderServicePort {
    String sendOrderReadyMessage(String phoneNumber);
}


