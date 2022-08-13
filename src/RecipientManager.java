import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class RecipientManager {
    private final ArrayList<Recipient> recipients;

    public RecipientManager() {
        this.recipients = new ArrayList<>();
    }


    public Recipient makeNew(String input) {
        String[] data = input.split(": ")[1].split(",");
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].strip();
        }
        Recipient recipient = null;
        switch (input.split(": ")[0]) {
            case "Personal" -> recipient = new PersonalRecipient(data[0], data[1], data[2], parseDay(data[3]));
            case "Office_friend" -> recipient = new OfficialFriendRecipient(data[0], data[1], data[2], parseDay(data[3]));
            case "Official" -> recipient = new OfficialRecipient(data[0], data[1], data[2]);
            default -> System.out.println("Invalid input format");
        }
        if (recipient != null) {
            this.add(recipient);
        }
        return recipient;
    }


    public int getCount() {
        return this.recipients.size();
    }

    public void add(Recipient recipient) {
        this.recipients.add(recipient);
    }

    public void sendWishesForToday() {
        ArrayList<Email> emails = ObjectHandler.emailsOnDate(LocalDate.now());
        ArrayList<String> wished = new ArrayList<>();
        for (Email email: emails) {
            if (email.getSubject().equals("Happy Birthday!")) {
                wished.add(email.getTo());
            }
        }
        for (Recipient recipient : this.recipients) {
            if ((recipient instanceof Wishable wishableRecipient)) {
                LocalDate today = LocalDate.now();
                if (Objects.equals(wishableRecipient.getBirthday(), today) || !(wished.contains(wishableRecipient.getEmail()))) {
                    wishableRecipient.wish();
                }
            }
        }
    }

    public LocalDate parseDay(String input){
        String[] data = input.split("/");
        return LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
    }
}
