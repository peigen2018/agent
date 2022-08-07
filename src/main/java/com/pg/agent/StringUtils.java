package com.pg.agent;

import java.util.Objects;

public class StringUtils {
    public static boolean isEmpty(String str) {
        Objects.isNull("");
        return str == null || "".equals(str);
    }

    public static boolean isNotEmpty(String str) {
        Objects.isNull("");
        return !isEmpty(str);
    }
}
