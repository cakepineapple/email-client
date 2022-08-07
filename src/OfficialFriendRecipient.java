import java.time.LocalDate;

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
        FileHandler.write("clientList.txt", this.toString());
    }

    @Override
    public void wish() {
        SendEmail.send(new Email(this.email, "Happy Birthday", "Wish you a Happy Birthday.\nRashad"));
    }

    @Override
    public String toString() {
        //Office_friend: kamal,kamal@gmail.com,clerk,2000/12/12
        return String.format("Office_friend: %s,%s,%s,%s", this.name, this.email, this.designation, this.birthday);
    }
}
