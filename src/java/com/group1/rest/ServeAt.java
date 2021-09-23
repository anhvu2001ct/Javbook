package com.group1.rest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Anh Vu Nguyen {@literal <nganhvu>}
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ServeAt {
    public String value();
    public ServeMethod[] method() default ServeMethod.GET;
}
