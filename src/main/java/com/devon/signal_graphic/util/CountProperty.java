package main.java.com.devon.signal_graphic.util;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class CountProperty {
    public static int getPropertyCount(Class<?> beanClass) {
        Method[] methods = beanClass.getMethods();
        Set<String> propertyNames = new HashSet<>();

        for (Method method : methods) {
            String name = method.getName();
            if (name.startsWith("get") && name.length() > 3 && method.getParameterCount() == 0) {
                propertyNames.add(name.substring(3).toLowerCase());
            } else if (name.startsWith("is") && name.length() > 2 && method.getParameterCount() == 0) {
                propertyNames.add(name.substring(2).toLowerCase());
            }
        }

        return propertyNames.size();
    }
}

