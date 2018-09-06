package com.ypp.tunte.aop;

import com.google.common.collect.Maps;
import com.ypp.tunte.annotation.CommonDataFieldAnnotation;
import com.ypp.tunte.domain.BaseEntity;
import com.ypp.tunte.enums.DataFieldTypeEnum;
import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

/**
 * <p>通用数据AOP</p>
 *
 * @author pingpingyan
 * @date 2018/9/5 0005
 */
@Aspect
@Configuration
public class DataEntityAop {



    @Pointcut("@annotation(com.ypp.tunte.annotation.CommonDataGenMethodAnnotation)")
    public void before(){}

    /**
     * 前置通知：
     * 为通用字段添加默认值；
     * @param joinPoint
     */
    @Before("before()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        System.out.println("我是通用数据前置通知!!!");

        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();

        if (ArrayUtils.isNotEmpty(obj)) {
            for (Object o : obj) {
                if (o instanceof BaseEntity) {
                    Class<?> targetClass = o.getClass();
                    Method[] methods = targetClass.getMethods();
                    Map<String, Method> methodMap = Maps.newHashMap();

                    for (Method method : methods) {
                        methodMap.put(method.getName(), method);
                    }


                    for (Method method : methods) {
                        if (method.getName().startsWith("set")) {
                            Annotation[] annotations = method.getDeclaredAnnotations();
                            for (Annotation annotation : annotations) {
                                if (annotation instanceof CommonDataFieldAnnotation) {


                                    String getMethodName = method.getName().substring("set".length());
                                    getMethodName = "get" + getMethodName;
                                    if (methodMap.containsKey(getMethodName)) {
                                        try {
                                            Object val = methodMap.get(getMethodName).invoke(o);
                                            if (val != null) {
                                                continue;
                                            }

                                        } catch (IllegalAccessException e) {
                                            e.printStackTrace();
                                            continue;
                                        } catch (InvocationTargetException e) {
                                            e.printStackTrace();
                                            continue;
                                        }
                                    }


                                    CommonDataFieldAnnotation fieldAnnotation = (CommonDataFieldAnnotation) annotation;
                                    DataFieldTypeEnum type = fieldAnnotation.type();
                                    Object defaultValue = null;
                                    switch (type) {
                                        case SHORT:
                                        case INT:
                                        case BYTE:
                                            defaultValue = 0;
                                            break;
                                        case CHAR:
                                            defaultValue = new Character(' ');
                                            break;
                                        case DATE:
                                            defaultValue = new Date();
                                            break;
                                        case LONG:
                                            defaultValue = 0L;
                                            break;
                                        case FLOAT:
                                        case DOUBLE:
                                            defaultValue = 0.0;
                                            break;
                                        case BOOLEAN:
                                            defaultValue = false;
                                            break;
                                        default:
                                            defaultValue = "";
                                            break;
                                    }

                                    try {
                                        method.invoke(o, defaultValue);
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();
                                    } catch (InvocationTargetException e) {
                                        e.printStackTrace();
                                    }


                                }
                            }
                        }
                    }
                }
            }
        }


    }




}
