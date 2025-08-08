package com.messaging.messaging.messaging.domain.usecase;

import com.messaging.messaging.messaging.domain.utils.DomainConstants;
import com.messaging.messaging.messaging.domain.ports.in.CodeSenderServicePort;
import com.messaging.messaging.messaging.domain.ports.out.CodeSenderPort;

import java.security.SecureRandom;

public class CodeSenderUseCase implements CodeSenderServicePort {

    private final CodeSenderPort messageSenderPort;
    private final SecureRandom random = new SecureRandom();

    public CodeSenderUseCase(CodeSenderPort messageSenderPort) {
        this.messageSenderPort = messageSenderPort;
    }

    @Override
    public String sendOrderReadyMessage(String phoneNumber) {
        String code = String.valueOf(DomainConstants.CODE_BASE + random.nextInt(DomainConstants.CODE_RANGE));
        String message = DomainConstants.ORDER_READY_CODE_MESSAGE + code;
        messageSenderPort.sendMessage(phoneNumber, message);
        return code;
    }
}

