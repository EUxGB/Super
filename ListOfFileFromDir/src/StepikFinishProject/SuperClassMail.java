package StepikFinishProject;

import java.util.function.Consumer;

public class SuperClassMail<T>  {
    private String from, to;
    private T content;

    SuperClassMail(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }


//    @Override
//    public void accept(T t) {
//
//    }

    String getFrom() {
        return from;
    }

    String getTo() {
        return to;
    }

    T getContent() {
        return content;
    }
}
