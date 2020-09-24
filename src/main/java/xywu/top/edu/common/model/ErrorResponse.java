package xywu.top.edu.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import xywu.top.edu.common.exception.ServiceException;

import java.io.Serializable;

/**
 * 标准 http 的错误返回格式，遵循 microsoft-api-guideline
 * https://github.com/microsoft/api-guidelines/blob/vNext/Guidelines.md#7102-error-condition-responses
 *
 * @author xiya.wu
 * @date 2019/11/8
 */
@Data
@Accessors(chain = true)
public class ErrorResponse implements Serializable {

    @Data
    public static class Error {
        @JsonProperty("code")
        private String code;

        @JsonProperty("message")
        private String message;
    }

    private Error error;

    public ErrorResponse() {}

    public ErrorResponse(ServiceException e) {
        Error error = new Error();
        error.setCode(e.toCode());
        error.setMessage(e.getMessage());
        this.error = error;
    }
}
