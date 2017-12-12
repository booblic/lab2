package lab2.bakery.annotation;

import java.lang.annotation.*;

/**
 * Одноэлементная аннотация, задающая баланс счета, если изначально стартовый капитал составляет менее 1000 рублей
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MinFund {
    int value() default 1000;
}
