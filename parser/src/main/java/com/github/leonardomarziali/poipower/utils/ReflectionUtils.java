package com.github.leonardomarziali.poipower.utils;

import com.github.leonardomarziali.poipower.exceptions.reflection.ConstructorNotFoundException;
import com.github.leonardomarziali.poipower.exceptions.reflection.FieldNotFoundException;
import com.github.leonardomarziali.poipower.exceptions.reflection.MethodNotFoundException;
import com.github.leonardomarziali.poipower.exceptions.reflection.NewObjectInstanceException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtils {

    private ReflectionUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Method getSetMethodByFieldName(Class<?> classContainingTheField, String fieldName,
                                                 Class<?> typeOfTheSetArgument) {
        String setNestedClassMethodName = String.format("set%s", StringUtils.capitalize(fieldName));
        try {
            return classContainingTheField.getDeclaredMethod(setNestedClassMethodName, typeOfTheSetArgument);
        } catch (NoSuchMethodException e) {
            throw new MethodNotFoundException(setNestedClassMethodName, classContainingTheField);
        }
    }

    public static Object getNewChildObjByFatherFieldName(Object fatherObject, String fatherFieldName) {
        Field field;
        try {
            field = fatherObject.getClass().getDeclaredField(fatherFieldName);
        } catch (NoSuchFieldException e) {
            throw new FieldNotFoundException(fatherFieldName, fatherObject.getClass());
        }
        Constructor<?> childObjConstructor;
        try {
            childObjConstructor = field.getType().getConstructor();
        } catch (NoSuchMethodException e) {
            throw new ConstructorNotFoundException(field.getType());
        }
        try {
            return childObjConstructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new NewObjectInstanceException(childObjConstructor);
        }
    }
}
