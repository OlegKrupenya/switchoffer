package com.testdev.services;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author oleh.krupenia.
 */
@Component("shutdownService")
public class ShutdownServiceImpl implements ShutdownService {

    public static final int SECONDS_IN_MINUTE = 60;
    public static final int SECONDS_IN_HOUR = 3600;

    private ScheduledFuture<?> future;
    private ScheduledExecutorService scheduler;

    @Override
    public void cancel() {
        if (future != null && scheduler != null) {
            scheduler.shutdownNow();
            future.cancel(true);
        }
    }

    @Override
    public void shutdown(int hours, int minutes, int seconds) {
        long delay = seconds + minutes * SECONDS_IN_MINUTE + hours * SECONDS_IN_HOUR;
        scheduler = Executors.newScheduledThreadPool(1);
        future = scheduler.scheduleAtFixedRate(() -> {
            try {
                Runtime.getRuntime().exec("shutdown -s");
            } catch (IOException e) {
                // TODO: logger + message on the form
                e.printStackTrace();
            }
        }, delay, 1, TimeUnit.SECONDS);
    }
}
