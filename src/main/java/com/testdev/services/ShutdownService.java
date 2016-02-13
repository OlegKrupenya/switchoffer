package com.testdev.services;

/**
 * @author oleh.krupenia.
 */
public interface ShutdownService {
    void cancel();
    void shutdown(int hours, int minutes, int seconds);
}
