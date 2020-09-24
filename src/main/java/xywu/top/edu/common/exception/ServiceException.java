package xywu.top.edu.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import xywu.top.edu.common.constant.ErrorCodes;
import xywu.top.edu.common.constant.SystemModules;
import xywu.top.edu.common.model.ErrorResponse;

/**
 * @author xiya.wu
 * @date 2019/11/4
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class ServiceException extends RuntimeException implements HttpStatusAware {
    private SystemModules systemModules;

    private ErrorCodes errorCodes;

    private String externalErrorCode;

    public ServiceException(SystemModules systemModules, ErrorCodes errorCodes, String message) {
        super(message);
        this.systemModules = systemModules;
        this.errorCodes = errorCodes;
    }

    public ServiceException(SystemModules systemModules, ErrorCodes errorCodes, ErrorResponse errorResponse) {
        super(errorResponse.getError().getMessage());
        this.systemModules = systemModules;
        this.errorCodes = errorCodes;
    }

    public ServiceException(SystemModules systemModules, ErrorCodes errorCodes, String message, Throwable e) {
        super(message, e);
        this.systemModules = systemModules;
        this.errorCodes = errorCodes;
    }

    public static String generateCode(SystemModules systemModules, ErrorCodes errorCodes, String externalErrorCode) {
        StringBuilder sb = new StringBuilder();
        sb.append(systemModules.toString());
        sb.append(errorCodes.getCode());
        if (StringUtils.isNotEmpty(externalErrorCode)) {
            sb.append("[");
            sb.append(externalErrorCode);
            sb.append("]");
        }
        return sb.toString();
    }

    public static String generateCode(SystemModules systemModules, ErrorCodes errorCodes) {
        return generateCode(systemModules, errorCodes, null);
    }

    public String toCode() {
        return generateCode(this.systemModules, this.errorCodes, this.externalErrorCode);
    }
}
