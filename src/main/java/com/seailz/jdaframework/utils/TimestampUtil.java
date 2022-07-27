package com.seailz.jdaframework.utils;

import java.util.Date;

/**
 * A util for creating timestamps, with ease.
 * @author Seailz
 */
public class TimestampUtil {

    /**
     * Generates a Discord timestamp
     * @param type The type of timestamp you want to create
     * @param time The time it will represent
     * @return The generated timestamp
     */
    public static String createTimestamp(Type type, Date time) {
        if (type == Type.BASE)
            return String.valueOf(time.getTime());
        String base = "<t:" + time.getTime() + ":";

        switch (type) {
            case SHORT_DATE:
                base += "d";
            case LONG_DATE:
                base += "D";
            case SHORT_TIME:
                base += "t";
            case LONG_TIME:
                base += "T";
            case DATE_AND_TIME:
                base += "f";
            case LONG_DATE_AND_TIME:
                base += "F";
            case AGO:
                base += "R";
        }

        base += ">";
        return base;
    }

    /**
     * Timestamp types
     */
    public enum Type {
        SHORT_DATE,
        // For example: 26/07/2022
        LONG_DATE,
        // For example: 26 July 2022
        SHORT_TIME,
        // For example 19:50
        LONG_TIME,
        // For example: 19:50:43
        DATE_AND_TIME,
        // For example: 26 July 2022 19:50
        LONG_DATE_AND_TIME,
        // For example: Tuesday, 26 July 2022 19:50
        AGO,
        // For example: 10 minutes ago
        BASE
        // For example: 1658861400
    }

}
