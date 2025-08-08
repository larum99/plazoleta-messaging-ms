package com.messaging.messaging.messaging.infrastructure.endpoints.rest;

import com.messaging.messaging.commons.configuration.swagger.docs.CodeSenderControllerDocs.*;
import com.messaging.messaging.messaging.application.dto.request.PhoneNumberRequest;
import com.messaging.messaging.messaging.application.dto.response.CodeVerificationResponse;
import com.messaging.messaging.messaging.application.services.CodeSenderService;
import com.messaging.messaging.messaging.infrastructure.utils.constants.ControllerConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllerConstants.BASE_URL)
@RequiredArgsConstructor
public class CodeSenderController {

    private final CodeSenderService codeSenderService;

    @SendCodeSmsDocs
    @PostMapping(ControllerConstants.SEND_CODE_PATH)
    public ResponseEntity<CodeVerificationResponse> sendCodeVerification(
            @RequestBody PhoneNumberRequest phoneNumberRequest) {
        return ResponseEntity.ok(codeSenderService.codeSenderSms(phoneNumberRequest));
    }
}
