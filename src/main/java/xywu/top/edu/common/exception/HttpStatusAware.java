package xywu.top.edu.common.exception;

import org.springframework.http.HttpStatus;

/**
 * @author xiya.wu
 * @date 2019/11/4
 */
public interface HttpStatusAware {
    HttpStatus getHttpStatus();
}
