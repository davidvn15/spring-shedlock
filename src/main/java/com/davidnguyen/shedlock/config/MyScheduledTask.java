package com.davidnguyen.shedlock.config;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyScheduledTask {
    @Scheduled(cron = "0 */1 * * * *")
    @SchedulerLock(name = "MyScheduledTaskLock", lockAtMostFor = "1m", lockAtLeastFor = "1m")
    public void performTask() {
        System.out.println("Executing scheduled task at: " + LocalDateTime.now());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task completed at: " + LocalDateTime.now());
    }
}
