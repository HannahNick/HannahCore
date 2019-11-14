package com.app.androidutildemo.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Nick on 2019-09-20.
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR,ElementType.METHOD})
public @interface Bury {

}
