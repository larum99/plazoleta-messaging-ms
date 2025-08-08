package com.messaging.messaging.messaging.domain.usecases;

import com.messaging.messaging.messaging.domain.ports.out.CodeSenderPort;
import com.messaging.messaging.messaging.domain.usecase.CodeSenderUseCase;
import com.messaging.messaging.messaging.domain.utils.DomainConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CodeSenderUseCaseTest {

    @Mock
    private CodeSenderPort codeSenderPort;
    @Mock
    private SecureRandom secureRandom;

    @InjectMocks
    private CodeSenderUseCase codeSenderUseCase;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(codeSenderUseCase, "random", secureRandom);
    }

    @Test
    void sendOrderReadyMessage_shouldGenerateCodeAndSendMessage() {
        String phoneNumber = "123456789";
        int mockRandomNumber = 1234;
        String expectedCode = String.valueOf(DomainConstants.CODE_BASE + mockRandomNumber);
        String expectedMessage = DomainConstants.ORDER_READY_CODE_MESSAGE + expectedCode;

        when(secureRandom.nextInt(DomainConstants.CODE_RANGE)).thenReturn(mockRandomNumber);

        String result = codeSenderUseCase.sendOrderReadyMessage(phoneNumber);

        ArgumentCaptor<String> phoneNumberCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> messageCaptor = ArgumentCaptor.forClass(String.class);
        verify(codeSenderPort, times(1)).sendMessage(phoneNumberCaptor.capture(), messageCaptor.capture());

        assertEquals(phoneNumber, phoneNumberCaptor.getValue());
        assertEquals(expectedMessage, messageCaptor.getValue());
        assertEquals(expectedCode, result);
    }
}