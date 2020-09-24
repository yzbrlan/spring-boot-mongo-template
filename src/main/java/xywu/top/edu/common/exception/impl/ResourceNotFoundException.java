package xywu.top.edu.common.exception.impl;

import org.springframework.http.HttpStatus;
import xywu.top.edu.common.constant.ErrorCodes;
import xywu.top.edu.common.constant.SystemModules;
import xywu.top.edu.common.exception.ServiceException;
import xywu.top.edu.common.model.ErrorResponse;

/**
 * @author xiya.wu
 * @date 2019/11/8
 *
 * 404
 */
public class ResourceNotFoundException extends ServiceException {

    public ResourceNotFoundException(SystemModules systemModules, ErrorCodes errorCodes, String message) {
        super(systemModules, errorCodes, message);
    }

    public ResourceNotFoundException(SystemModules systemModules, ErrorCodes errorCodes, ErrorResponse errorResponse) {
        super(systemModules, errorCodes, errorResponse);
    }

    public ResourceNotFoundException(SystemModules systemModules, ErrorCodes errorCodes, String message, Throwable e) {
        super(systemModules, errorCodes, message, e);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
