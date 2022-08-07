public class OfficialRecipient implements Recipient {
    private final String name;
    private final String email;
    private final String designation;
    public OfficialRecipient(String name, String email, String designation) {
        this.name = name;
        this.email = email;
        this.designation = designation;
    }

    @Override
    public String toString() {
        //Official: nimal,nimal@gmail.com,ceo
        return String.format("Official: %s,%s,%s", this.name, this.email, this.designation);
    }


}
