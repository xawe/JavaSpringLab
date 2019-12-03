package xawe.com.springlab.springlab;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ProductExceptionController{
    @ExceptionHandler(value =xawe.com.springlab.springlab.ProductNotfoundException.class)
    public ResponseEntity<Object> exception(ProductNotfoundException exception){
        return new ResponseEntity<>("Product not Found", HttpStatus.NOT_FOUND);
    }
    
}