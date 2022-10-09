package ua.com.javarush.quest.uspenskaya.questdelta.util;

public class QuestException extends RuntimeException {
    public QuestException() {
    }

    public QuestException(String message) {
        super(message);
    }

    public QuestException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestException(Throwable cause) {
        super(cause);
    }
}
