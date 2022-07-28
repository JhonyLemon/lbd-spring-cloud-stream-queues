package pl.fissst.lbd.queues.util;

public enum BindingName {

    USER("user-out-0"),
    ARTICLE("article-out-0"),
    COMMENT("comment-out-0"),
    EMAIL("email-out-0");
    BindingName(String name) {
        this.name=name;
    }
    private final String name;

    public String getName() {
        return name;
    }
}
