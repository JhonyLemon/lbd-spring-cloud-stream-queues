package pl.fissst.lbd.queues.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class LoggerService {

    private final Logger LOG = LoggerFactory.getLogger(LoggerService.class);

    @Bean
    public Consumer<Message<String>> logger() {
        return value -> {
            LOG.info(value.toString());
        };
    }
}
