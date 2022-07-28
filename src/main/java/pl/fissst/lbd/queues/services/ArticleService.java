package pl.fissst.lbd.queues.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import pl.fissst.lbd.queues.dto.ArticleDto;
import pl.fissst.lbd.queues.util.BindingName;
import pl.fissst.lbd.queues.util.EventType;

import java.util.function.Consumer;

@Service
public class ArticleService {

    private final Logger LOG = LoggerFactory.getLogger(ArticleService.class);
    private final StreamBridge streamBridge;



    public ArticleService(StreamBridge streamBridge ) {
        this.streamBridge = streamBridge;
    }

    public void CreateArticle(ArticleDto articleDto){
        String s="Article created !!!";
        LOG.info(s);
        Message<String> message = MessageBuilder.withPayload(s).setHeader(EventType.getHeader(),EventType.ARTICLE_CREATED.getEvent()).build();
        streamBridge.send(BindingName.ARTICLE.getName(), message);
    }

    public void UpdateArticle(ArticleDto articleDto,Long id){
        String s="Article updated !!!";
        LOG.info(s);
        Message<String> message = MessageBuilder.withPayload(s).setHeader(EventType.getHeader(),EventType.ARTICLE_UPDATED.getEvent()).build();
        streamBridge.send(BindingName.ARTICLE.getName(), message);
    }

    @Bean
    public Consumer<Message<String>> article() {
        return value -> {
            LOG.info("Article: "+value.getPayload().toString());
        };
    }


}
