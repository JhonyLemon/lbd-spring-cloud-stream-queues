package pl.fissst.lbd.queues.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import pl.fissst.lbd.queues.dto.CommentDto;
import pl.fissst.lbd.queues.util.BindingName;

import java.util.function.Consumer;


@Service
public class CommentService {

    private final Logger LOG = LoggerFactory.getLogger(CommentService.class);
    private final StreamBridge streamBridge;


    public CommentService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void CreateComment(CommentDto commentDto){
        String s="Comment Created!!!";
        LOG.info(s);
        Message<String> message = MessageBuilder.withPayload(s).build();
        streamBridge.send(BindingName.COMMENT.getName(), message);

    }
    public void UpdateComment(CommentDto commentDto,Long id){
        String s="Comment Updated!!!";
        LOG.info(s);
        Message<String> message = MessageBuilder.withPayload(s).build();
        streamBridge.send(BindingName.COMMENT.getName(), message);
    }
    public void DeleteComment(Long id){
        String s="Comment Deleted!!!";
        LOG.info(s);
        Message<String> message = MessageBuilder.withPayload(s).build();
        streamBridge.send(BindingName.COMMENT.getName(), message);
    }

    @Bean
    public Consumer<Message<String>> comment() {
        return value -> {
            LOG.info(value.toString());
        };
    }

}
