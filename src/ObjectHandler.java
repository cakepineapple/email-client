import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;

public class ObjectHandler {
    public static String filename = "mails.ser";
    public static void serializeEmail(Email email) {
        boolean exists = Files.exists(Path.of(filename));
        try {
            FileOutputStream fos = new FileOutputStream(filename, true);
            ObjectOutputStream oos;
            if (exists) {
                oos = new ObjectOutputStream(fos) {
                    @Override
                    protected void writeStreamHeader() {
                    }
                };
            } else {
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(email);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This reads the .ser file and returns an arraylist with all emails read.
    public static ArrayList<Email> deserializeEmails(){
        ArrayList<Email> result = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Email mail = (Email) ois.readObject();
            while (mail != null) {
                result.add(mail);
                try {
                    mail = (Email) ois.readObject();
                } catch (EOFException e) {
                    break;
                }
            }
            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<Email> emailsOnDate(LocalDate date) {
        ArrayList<Email> emails = deserializeEmails();
        emails.removeIf(email -> !(email.getDate().equals(date)));
        return emails;
    }
}


