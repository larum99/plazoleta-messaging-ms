package com.messaging.messaging.messaging.domain.ports.out;

public interface CodeSenderPort {
    void sendMessage(String phoneNumber, String message);
}

