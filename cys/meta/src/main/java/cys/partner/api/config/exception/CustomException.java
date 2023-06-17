package cys.partner.api.config.exception;

import cys.partner.api.config.errorcodes.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{
    private final ErrorCode errorCode;
    private final String msg;
}
