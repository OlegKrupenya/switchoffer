package com.testdev.services;

import org.springframework.stereotype.Component;

/**
 * @author oleh.krupenia.
 */
@Component("shutdownService")
public class ShutdownServiceImpl implements ShutdownService {
    @Override
    public void shutdown(int hours, int minutes) {
        System.out.println("shutdown");
    }
}
