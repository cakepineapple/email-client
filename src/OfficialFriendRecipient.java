import java.time.LocalDate;
import java.util.ArrayList;

public class OfficialFriendRecipient implements Recipient, Wishable {
    private final String name;
    private final String email;
    private final String designation;
    private final LocalDate birthday;

    public OfficialFriendRecipient(String name, String email, String designation, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.designation = designation;
        this.birthday = birthday;
    }

    @Override
    public void wish() {
        SendEmail.send(new Email(this.email, "Happy Birthday!", "Wish you a Happy Birthday.\nRashad"));
    }

    public String getEmail() {
        return email;
    }

    @Override
    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        String birthdayAsString = String.format("%s/%s/%s", this.birthday.getYear(), this.birthday.getMonthValue(), this.birthday.getDayOfMonth());
        //Office_friend: kamal,kamal@gmail.com,clerk,2000/12/12
        return String.format("Office_friend: %s,%s,%s,%s", this.name, this.email, this.designation, birthdayAsString);
    }
}
