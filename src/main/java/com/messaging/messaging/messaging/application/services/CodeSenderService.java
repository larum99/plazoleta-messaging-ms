package com.messaging.messaging.messaging.application.services;

import com.messaging.messaging.messaging.application.dto.request.PhoneNumberRequest;
import com.messaging.messaging.messaging.application.dto.response.CodeVerificationResponse;

public interface CodeSenderService {
    CodeVerificationResponse codeSenderSms(PhoneNumberRequest phoneNumberRequest);
}

