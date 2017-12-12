package lab2.bakery.annotation;

import java.lang.annotation.*;

/**
 * Одноэлементная аннотация, задающая значение стоимости товара по умолчанию, если она не была указана раньше
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DefaultPrice {
    double value() default 100;
}
