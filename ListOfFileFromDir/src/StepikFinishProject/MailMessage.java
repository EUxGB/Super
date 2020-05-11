package StepikFinishProject;

public class MailMessage extends SuperClassMail<String> {
    String from, to, content;

    MailMessage(String from, String to, String content) {
        super(from, to, content);
    }

}
