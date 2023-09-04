package com.course.courseDemo.exception;

import org.springframework.validation.ObjectError;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
public class RestServiceParameterValidationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -1445436780043888426L;
    /**
     * BindingResult.
     */
    private final List<ObjectError> errors;

    /**
     * Throwable.
     */
    private Throwable rootCause;

    /**
     * Rest service parameter validation errors.
     *
     * @param errors BindingResult
     */
    public RestServiceParameterValidationException(List<ObjectError> errors) {
        this.errors = errors;
    }

    /**
     * Rest service parameter validation errors.
     *
     * @param errors    BindingResult
     * @param rootCause Throwable
     */
    public RestServiceParameterValidationException(List<ObjectError> errors, Throwable rootCause) {
        this.errors = errors;
        this.rootCause = rootCause;
    }

    /**
     * @param error Desc
     */

    public RestServiceParameterValidationException(ObjectError error) {
        List<ObjectError> errors = new ArrayList<>();
        errors.add(error);
        this.errors = errors;
    }

    /**
     * Get Errors.
     *
     * @return BindingResult.
     */
    public List<ObjectError> getBindingResult() {
        return errors;
    }

    /**
     * @return the rootCause.
     */
    public final Throwable getRootCause() {
        return rootCause;
    }

}
