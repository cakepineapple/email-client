import java.io.Serializable;
import java.time.LocalDate;

public class Email implements Serializable {
    private final String to;
    private final String subject;
    private final String content;
    private LocalDate date;

    public Email(String to, String subject, String content) {
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.date = LocalDate.now();
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public String toString() {
        return
        "Date: " + this.date + "\n" +
        "Recipient: " + this.to + "\n" +
        "Subject: " + this.subject + "\n" +
        "Body: " + this.content + "\n";
    }


    public static Email parse(String input) {
        // Input format: email, subject, content
        String[] data = input.split(",");
        return new Email(data[0].strip(), data[1].strip(), data[2].strip());
    }
}
