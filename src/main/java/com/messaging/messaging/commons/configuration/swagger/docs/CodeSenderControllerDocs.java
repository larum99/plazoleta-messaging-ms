package com.messaging.messaging.commons.configuration.swagger.docs;

import com.messaging.messaging.messaging.application.dto.request.PhoneNumberRequest;
import com.messaging.messaging.messaging.application.dto.response.CodeVerificationResponse;
import com.messaging.messaging.commons.configuration.swagger.examples.CodeSenderSwaggerExamples;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public class CodeSenderControllerDocs {

    @Target({METHOD})
    @Retention(RUNTIME)
    @Operation(
            summary = "Enviar código de verificación por SMS",
            description = "Envía un código de verificación al número de teléfono proporcionado para notificar que el pedido está listo.",
            requestBody = @RequestBody(
                    description = "Número de teléfono del cliente",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = PhoneNumberRequest.class),
                            examples = @ExampleObject(
                                    name = "Ejemplo de envío de código",
                                    summary = "Ejemplo para enviar código por SMS",
                                    value = CodeSenderSwaggerExamples.SEND_CODE_REQUEST
                            )
                    )
            )
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Código enviado correctamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CodeVerificationResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Solicitud inválida"
            )
    })
    public @interface SendCodeSmsDocs {}
}

