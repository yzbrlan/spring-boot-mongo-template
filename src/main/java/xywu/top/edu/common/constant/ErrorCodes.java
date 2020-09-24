package xywu.top.edu.common.constant;

/**
 * @author xiya.wu
 * @date 2019/11/4
 */
public enum ErrorCodes {
    /**
     * 错误码由6位数字组成，不同的位数代表不同含义
     * idx0 错误来源，1代表internal，内部模块抛出的错误；2代表external，依赖方抛出的错误
     * idx[1-2] 模块，定义在 SystemModule
     * idx[3-5] 具体错误，开发人员定义，在 ErrorCodes 中，可以复用已有的 errorCodes
     * externalErrorCode: 允许传递外部传送过来的 errorCode
     * 示例: 101001[-10031]
     * 1(外部依赖错误)00(SYSTEM)001(CONNECTION_TIMEOUT)[externalErrorCode]
     */

    /**
     * 未知错误
     */
    UNEXPECTED_ERROR("000", "unexpected error"),
    CONNECTION_TIMEOUT("001", "connection timeout"),
    RESOURCE_NOT_FOUND("002", "resource not found"),
    BAD_REQUEST("003", "bad request"),
    BAD_RESPONSE("004", "bad response"),
    PERMISSION_DENIED("005", "permission denied"),
    INTERNAL_ERROR("006", "internal error"),
    CONNECTION_FAIL("007", "connection fail"),
    PAYMENT_REQUIRED("009","payment required"),
    UNAUTHORIZED("100","no authorized"),
    FORBIDDEN("101","for forbidden")
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
