package com.netcracker.scheduler;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Yuksi on 07.02.2017.
 */

@Configuration
@EnableScheduling
@ImportResource("classpath:app-context.xml")
public class SchedulerConfig {
}
