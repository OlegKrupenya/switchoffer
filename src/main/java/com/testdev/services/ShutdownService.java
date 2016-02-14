package com.testdev.services;

/**
 * Service that shuts down the computer by the timer
 * @author oleh.krupenia.
 */
public interface ShutdownService {
    /**
     * Cancels the timer that was set by the {@link #shutdown(int, int, int)} method.
     * If the timer wasn't set, nothing happens.
     */
    void cancel();

    /**
     * Sets the timer to shut down the computer.
     * @param hours Hours before shut down.
     * @param minutes Minutes before shut down.
     * @param seconds Seconds before shut down.
     */
    void shutdown(int hours, int minutes, int seconds);
}
