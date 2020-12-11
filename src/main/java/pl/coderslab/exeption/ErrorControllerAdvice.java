package pl.coderslab.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleExeption(HttpServletRequest request, Exception exception, Model model){
        model.addAttribute("exception", exception);
        model.addAttribute("url", request.getRequestURL());
        model.addAttribute("errorMessage", exception.getMessage());
        return "exception-page";
    }
}
