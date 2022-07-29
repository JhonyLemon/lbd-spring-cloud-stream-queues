package pl.fissst.lbd.queues.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import pl.fissst.lbd.queues.util.BindingName;
import pl.fissst.lbd.queues.util.EventType;

import java.util.function.Consumer;

@Service
public class EmailService {

    private final Logger LOG = LoggerFactory.getLogger(EmailService.class);
    private final StreamBridge streamBridge;


    public EmailService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }


    public void SendEmailToUser(){
        String s="Email Sent!!!";
        LOG.info(s);
        Message<String> message = MessageBuilder.withPayload(s)
                .setHeader(EventType.getHeader(),"email")
                .setHeader("x-delay",5000)
                .build();
        streamBridge.send(BindingName.EMAIL.getName(), message);
    }

    @Bean
    public Consumer<Message<String>> email() {
        return value -> {
            LOG.info("Email: "+value.getPayload().toString());
        };
    }

}
