package com.codejackel.colors.domain;

import lombok.*;


@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppArgs {
    private String color = "red";
    private String message = "No Message";

    private final static AppArgs _instance = new AppArgs();

    public static String getColor() {
        return _instance.color;
    }

    public static void setColor(String color) {
        _instance.color = color;
    }

    public static String getMessage() {
        return _instance.message;
    }

    public static void setMessage(String message) {
        _instance.message = message;
    }

    public static String toLogString() {
        return "[color: "+_instance.color+", message:"+_instance.message+"]";
    }
}
