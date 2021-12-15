package com.cmcglobal.kafkastreamprocessor;

import com.cmcglobal.kafkastreamprocessor.producers.ProducerExampleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Test {

    @Autowired protected ProducerExampleImpl example;

    @Scheduled(cron = "0/1 * * * * *")
    public void test() {
        example.producer();
    }
}
