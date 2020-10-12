package xywu.top.edu.common.constant;

/**
 * @author xiya.wu
 * @date 2019/11/4
 */
public enum ErrorCodes {
    RESOURCE_NOT_FOUND("002", "resource not found"),
    BAD_REQUEST("003", "bad request"),
     ;
    private String code;
    private String defaultMessage;

    public String getCode() {
        return code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    ErrorCodes(String code, String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
    }
}
