// INDEX NUMBER :- 200525R
// TODO: Debug and Comment
// TODO: variables declared as final
// TODO: Serializing stuff
// TODO: Wishing mechanism
//TODO: Tidy up the interface
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class EmailClient {

    public static void main(String[] args) {
        RecipientManager manager = new RecipientManager();
        ArrayList<String> records = FileHandler.readLines("clientList.txt");
        for (String record: records) {
            manager.makeNew(record);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Enter option type:\s
                1 - Adding a new recipient
                2 - Sending an email
                3 - Printing out all the recipients who have birthdays
                4 - Printing out details of all the emails sent
                5 - Printing out the number of recipient objects in the application""");

        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1:
                String input1 = scanner.nextLine();
                Recipient recipient = manager.makeNew(input1);
                FileHandler.appendLine("clientList.txt", recipient + "\n");
                System.out.println("Recipient added successfully");
                break;
            case 2: //DONE
                // input format - email, subject, content
                String input2 = scanner.nextLine();
                SendEmail.send(Email.parse(input2));
                break;
            case 3:
                // input format - yyyy/MM/dd (ex: 2018/09/17)
                // code to print recipients who have birthdays on the given date
                break;
            case 4:
                // input format - yyyy/MM/dd (ex: 2018/09/17)
                // code to print the details of all the emails sent on the input date
                String input4 = scanner.nextLine();
                LocalDate date = manager.parseDay(input4);
                ArrayList<Email> emails = ObjectHandler.emailsOnDate(date);
                for (Email email: emails) {
                    System.out.println();
                    System.out.println(email);
                    System.out.println();
                }
                if (emails.isEmpty()) {
                    System.out.println("No emails were sent on the input date!");
                }
                break;
            case 5:
                // code to print the number of recipient objects in the application
                System.out.println("Total recipients: " + manager.getCount());
                break;

        }

        // start email client
        // code to create objects for each recipient in clientList.txt
        // use necessary variables, methods and classes
    }
}