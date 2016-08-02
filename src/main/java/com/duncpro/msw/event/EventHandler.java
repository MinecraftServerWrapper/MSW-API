package com.duncpro.msw.event;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Declares a method that can handle an event. All event handler methods should have this annotation.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface EventHandler {
    boolean ignoreCancelled() default true;

    HandlerPriority priority() default HandlerPriority.NORMAL;
}
