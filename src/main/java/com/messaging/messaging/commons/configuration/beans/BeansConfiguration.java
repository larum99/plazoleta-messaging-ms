package com.messaging.messaging.commons.configuration.beans;

import com.messaging.messaging.messaging.domain.ports.in.CodeSenderServicePort;
import com.messaging.messaging.messaging.domain.ports.out.CodeSenderPort;
import com.messaging.messaging.messaging.domain.usecase.CodeSenderUseCase;
import com.messaging.messaging.messaging.infrastructure.adapters.twilio.CodeSenderAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeansConfiguration {

    @Bean
    public CodeSenderPort codeSenderPort() {
        return new CodeSenderAdapter();
    }

    @Bean
    public CodeSenderServicePort codeSenderServicePort() {
        return new CodeSenderUseCase(codeSenderPort());
    }
}
