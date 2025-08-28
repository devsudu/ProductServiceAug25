package dev.sudu.productserviceaug25.controlleradvices;

import dev.sudu.productserviceaug25.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Void> handleRuntimeException() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException() {
        return new ResponseEntity<>(
                "Please try again with a valid product id",
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        return new ResponseEntity<>(
                productNotFoundException.getProductId() + " is an invalid id, Please pass a valid product id",
                HttpStatus.NOT_FOUND
        );
    }
}
