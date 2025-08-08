package com.messaging.messaging.messaging.application.services.impl;

import com.messaging.messaging.commons.configuration.utils.Constants;
import com.messaging.messaging.messaging.application.dto.request.PhoneNumberRequest;
import com.messaging.messaging.messaging.application.dto.response.CodeVerificationResponse;
import com.messaging.messaging.messaging.application.services.CodeSenderService;
import com.messaging.messaging.messaging.domain.ports.in.CodeSenderServicePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CodeSenderServiceImpl implements CodeSenderService {

    private final CodeSenderServicePort messageServicePort;

    @Override
    public CodeVerificationResponse codeSenderSms(PhoneNumberRequest phoneNumberRequest) {
        log.info(Constants.ORDER_READY_MESSAGE_LOG, phoneNumberRequest.phoneNumber());

        String code = messageServicePort.sendOrderReadyMessage(phoneNumberRequest.phoneNumber());
        return new CodeVerificationResponse(code);
    }
}
