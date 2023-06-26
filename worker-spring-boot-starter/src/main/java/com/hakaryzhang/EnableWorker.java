package com.hakaryzhang;

import com.hakaryzhang.exported.Worker;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(WorkerImportSelector.class)
public @interface EnableWorker {
    boolean enabled() default true;
}
