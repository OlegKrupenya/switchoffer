package com.testdev.services;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author oleh.krupenia.
 */
@Component("shutdownService")
public class ShutdownServiceImpl implements ShutdownService {
    @Override
    public void shutdown(int hours, int minutes) {
        int delay = minutes + hours * 60;
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new Shutdown(), delay, 8, TimeUnit.MINUTES);
    }

    private class Shutdown implements Runnable {
        @Override
        public void run() {
            try {
                Runtime.getRuntime().exec("shutdown -s");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
