package com.github.leonardomarziali.poipower.exceptions.reflection;

import java.lang.reflect.Constructor;

public class NewObjectInstanceException extends RuntimeException {

    public NewObjectInstanceException(Constructor<?> constructor) {
        super(String.format("Constructor %s of %s class throw an error during instantiation",
                            constructor.getName(),
                            constructor.getDeclaringClass().getName()));
    }
}
