// INDEX NUMBER :- 200525R
// TODO: Debug and Comment
// TODO: variables declared as final
// TODO: Serializing stuff
// TODO: Wishing mechanism
//TODO: Tidy up the interface
import java.util.ArrayList;
import java.util.Scanner;

public class EmailClient {

    public static void main(String[] args) {
        RecipientManager manager = new RecipientManager();
        ArrayList<String> records = FileHandler.readLines("clientList.txt");
        for (String record: records) {
            manager.makeNew(record, false);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option type: \n"
                + "1 - Adding a new recipient\n"
                + "2 - Sending an email\n"
                + "3 - Printing out all the recipients who have birthdays\n"
                + "4 - Printing out details of all the emails sent\n"
                + "5 - Printing out the number of recipient objects in the application");

        int option = Integer.parseInt(scanner.nextLine());

        switch(option){
            case 1: // DONE, BUT HAVE TO DEBUG
                // input format - Official: nimal,nimal@gmail.com,ceo
                // Use a single input to get all the details of a recipient
                // code to add a new recipient
                // store details in clientList.txt file
                // Hint: use methods for reading and writing files
                String input1 = scanner.nextLine();
                manager.makeNew(input1, true);
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
                break;
            case 5:
                // code to print the number of recipient objects in the application
                break;

        }

        // start email client
        // code to create objects for each recipient in clientList.txt
        // use necessary variables, methods and classes
    }
}