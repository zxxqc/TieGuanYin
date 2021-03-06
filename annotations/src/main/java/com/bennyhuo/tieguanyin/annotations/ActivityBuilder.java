package com.bennyhuo.tieguanyin.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by benny on 1/29/18.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface ActivityBuilder {
    GenerateMode mode() default GenerateMode.Auto;
    ResultEntity[] resultTypes() default {};
    PendingTransition pendingTransition() default @PendingTransition;
    PendingTransition pendingTransitionOnFinish() default @PendingTransition;
    SharedElement[] sharedElements() default {};
    SharedElementByNames[] sharedElementsByNames() default {};
    SharedElementWithName[] sharedElementsWithName() default {};

    String[] categories() default {};
    int[] flags() default {};
}
