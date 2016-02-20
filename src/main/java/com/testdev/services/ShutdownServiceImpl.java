package com.testdev.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Implementation of the {@link ShutdownService}
 * @author oleh.krupenia.
 */
@Component("shutdownService")
public class ShutdownServiceImpl implements ShutdownService {
    /**
     * Number of seconds in one minute to calculate the total delay.
     */
    public static final int SECONDS_IN_MINUTE = 60;
    /**
     * Number of seconds in one hour to calculate the total delay.
     */
    public static final int SECONDS_IN_HOUR = 3600;
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ShutdownServiceImpl.class);
    /**
     * Stored {@link ScheduledFuture} object to cancel the task.
     */
    private ScheduledFuture<?> future;
    /**
     * Stored {@link ScheduledExecutorService} to shut down the executor after cancelling the task.
     */
    private ScheduledExecutorService scheduler;

    @Override
    public void cancel() {
        if (future != null && scheduler != null) {
            future.cancel(true);
            scheduler.shutdownNow();
        }
    }

    @Override
    public void shutdown(int hours, int minutes, int seconds) {
        long delay = seconds + minutes * SECONDS_IN_MINUTE + hours * SECONDS_IN_HOUR;
        scheduler = Executors.newScheduledThreadPool(1);
        future = scheduler.scheduleAtFixedRate(() -> {
            try {
                Runtime.getRuntime().exec("shutdown -s -t 0");
            } catch (IOException e) {
                LOGGER.error("Unable to shut down the computer", e);
            }
        }, delay, 1, TimeUnit.SECONDS);
    }
}
