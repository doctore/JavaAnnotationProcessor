package com.processor.log_todo;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

@Target({FIELD, METHOD, TYPE})
public @interface LogTODO {

    // Source task of the current LogTODO
    String relatedTask();

    // Extra information to explain why this annotation has been used
    String description() default "";

    /**
     * If {@code false} the information will be displayed using a {@code warning} message
     * If {@code true} the information will be displayed using an {@code error} message
     */
    boolean displayAsError() default false;

}
