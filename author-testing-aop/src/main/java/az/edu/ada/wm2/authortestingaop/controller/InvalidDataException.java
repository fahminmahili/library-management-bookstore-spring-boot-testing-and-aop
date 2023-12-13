package az.edu.ada.wm2.authortestingaop.controller;

import org.springframework.validation.BindingResult;


public class InvalidDataException extends RuntimeException {

    private BindingResult bindingResult;

    public InvalidDataException(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

}
