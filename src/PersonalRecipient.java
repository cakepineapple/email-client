import java.time.LocalDate;
import java.util.ArrayList;

public class PersonalRecipient implements Recipient, Wishable {
    private final String name;
    private final String email;
    private final String nickname;
    private final LocalDate birthday;

    public PersonalRecipient(String name, String nickname, String email, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.nickname = nickname;
        this.birthday = birthday;
    }

    @Override
    public void wish() {
        SendEmail.send(new Email(this.email, "Happy Birthday!", "hugs and love on your birthday.\nRashad"));
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
        //Personal: sunil,<nick-name>,sunil@gmail.com,2000/10/10
        return String.format("Personal: %s,%s,%s,%s", this.name, this.nickname, this.email, birthdayAsString);
    }
}
