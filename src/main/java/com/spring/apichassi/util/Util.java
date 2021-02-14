package com.spring.apichassi.util;

import java.util.Locale;
import java.util.UUID;

public class Util {
    public static String uuidGenerator(){
        return UUID.randomUUID().toString().toUpperCase(Locale.ROOT);
    }
}
