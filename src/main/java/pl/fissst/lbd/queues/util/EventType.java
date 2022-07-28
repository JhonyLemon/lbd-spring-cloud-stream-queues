package pl.fissst.lbd.queues.util;

public enum EventType {
    USER_CREATED("user.created.0"),
    ARTICLE_CREATED("article.created.0"),
    ARTICLE_UPDATED("article.updated.0"),
    COMMENT_CREATED("comment.created.0"),
    COMMENT_UPDATED("comment.updated.0"),
    COMMENT_DELETED("comment.deleted.0");

    EventType(String s) {
        this.event=s;
    }
    private final String event;
    private static final String header="routing_key";

    public String getEvent() {
        return event;
    }

    public static String getHeader() {
        return header;
    }
}
