package woo.doneit.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ControllerAdvice
public class CommonExceptionAdvice {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> illegalStateException(Exception e) {
        commonException(e);

        return ResponseEntity
                .badRequest()
                .body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(Exception e) {
        commonException(e);

        return ResponseEntity
                .badRequest()
                .body(e.getMessage());
    }

    private static void commonException(Exception e) {
        log.error(e.getMessage());
    }
}
