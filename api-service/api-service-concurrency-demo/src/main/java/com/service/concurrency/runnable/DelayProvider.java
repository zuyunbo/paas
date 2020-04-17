package com.service.concurrency.runnable;

import java.util.concurrent.TimeUnit;

public interface DelayProvider {
    void executeAfterDelay(long interval, TimeUnit timeUnit, Runnable task);
}