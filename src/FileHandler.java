import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    public static void appendLine(String filename, String content) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(content);
            bw.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("ERROR: IOException. Writing to disk failed");
        }
    }

    public static ArrayList<String> readLines(String filename) {
        ArrayList<String> out = new ArrayList<>();
        try {
            FileReader reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                out.add(line);
            }
        } catch (IOException e) {
            System.out.println("ERROR: IOException. Reading from disk failed");
        }
        return out;
    }

}
