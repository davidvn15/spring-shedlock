package com.davidnguyen.shedlock.config;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyScheduledTask {
    @Scheduled(cron = "0 */1 * * * *")
    @SchedulerLock(name = "MyScheduledTaskLock1", lockAtMostFor = "1m", lockAtLeastFor = "1m")
    public void performTask1() {
        System.out.println("Executing scheduled task 1 at: " + LocalDateTime.now());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task completed at: " + LocalDateTime.now());
    }

    @Scheduled(cron = "0 */1 * * * *")
    @SchedulerLock(name = "MyScheduledTaskLock2", lockAtMostFor = "20s", lockAtLeastFor = "20s")
    public void performTask2() {
        System.out.println("Executing scheduled task 2 at: " + LocalDateTime.now());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task completed at: " + LocalDateTime.now());
    }
}
