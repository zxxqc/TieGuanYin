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
public @interface FragmentBuilder {
    GenerateMode mode() default GenerateMode.Both;
    SharedElement[] sharedElements() default {};
    SharedElementByNames[] sharedElementsByNames() default {};
    SharedElementWithName[] sharedElementsWithName() default {};
}
