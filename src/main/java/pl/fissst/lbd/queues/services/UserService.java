package pl.fissst.lbd.queues.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import pl.fissst.lbd.queues.dto.UserDto;
import pl.fissst.lbd.queues.util.BindingName;
import pl.fissst.lbd.queues.util.EventType;

import java.util.function.Consumer;

@Service
public class UserService {

    private final Logger LOG = LoggerFactory.getLogger(UserService.class);
    private final StreamBridge streamBridge;


    public UserService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }


    public void CreateUser(UserDto userDto){
        String s="User created!!!";
        LOG.info(s);
        Message<String> message = MessageBuilder.withPayload(s).setHeader(EventType.getHeader(),EventType.USER_CREATED.getEvent()).build();
        streamBridge.send(BindingName.USER.getName(), message);
    }

    @Bean
    public Consumer<Message<String>> user() {
        return value -> {
            LOG.info("User: "+value.getPayload().toString());
        };
    }


}
