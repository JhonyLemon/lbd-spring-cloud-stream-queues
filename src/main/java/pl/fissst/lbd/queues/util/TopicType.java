package pl.fissst.lbd.queues.util;

public enum TopicType {
    USER_CREATED("user-created"),
    ARTICLE_CREATED("article-created"),
    ARTICLE_UPDATED("article-updated"),
    COMMENT_CREATED("comment-created"),
    COMMENT_UPDATED("comment-updated"),
    COMMENT_DELETED("comment-deleted"),

    EMAIL_SENT("email-sent");

    TopicType(String s) {
        this.topic=s;
    }
    private final String topic;

    public String getTopic() {
        return topic;
    }

}
