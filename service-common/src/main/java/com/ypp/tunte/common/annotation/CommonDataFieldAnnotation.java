package com.ypp.tunte.common.annotation;

import com.ypp.tunte.common.enums.DataFieldTypeEnum;

import java.lang.annotation.*;

/**
 * <p>功能描述在这</p>
 *
 * @author pingpingyan
 * @date 2018/9/5 0005
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface CommonDataFieldAnnotation {

    DataFieldTypeEnum type() default DataFieldTypeEnum.STRING;

}