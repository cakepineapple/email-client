import java.time.LocalDate;
import java.util.ArrayList;

public class RecipientManager {
    private ArrayList<Recipient> recipients;

    public RecipientManager() {
        this.recipients = new ArrayList<>();
    }


    public Recipient makeNew(String input, boolean save) {
        String[] data = input.split(": ")[1].split(",");
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].strip();
        }
        Recipient recipient = null;
        switch (input.split(": ")[0]) {
            case "Personal" -> recipient = new PersonalRecipient(data[0], data[1], data[2], parseBirthday(data[3]));
            case "Office_friend" -> recipient = new OfficialFriendRecipient(data[0], data[1], data[2], parseBirthday(data[3]));
            case "Official" -> recipient = new OfficialRecipient(data[0], data[1], data[2]);
            default -> System.out.println("Invalid input format");
        }
        if (recipient != null) {
            this.add(recipient);
            if (save) FileHandler.appendLine("clientList.txt", recipient + "\n");
        }
        return recipient;
    }


    public int getCount() {
        return this.recipients.size();
    }

    public void add(Recipient recipient) {
        this.recipients.add(recipient);
    }

    public static LocalDate parseBirthday (String input){
        String[] data = input.split("/");
        return LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
    }
}
