package com.jad.utils;

public interface ILogger {
    void logInfo(String message);

    void log(LogType logType, String message);

    void logWarning(String message);

    void logError(String message);
}
