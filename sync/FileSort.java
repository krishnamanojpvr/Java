import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileSort {
    
    static class WriteCSV implements Runnable {
        @Override
        public void run() {
            String[] headers = { "ID", "Name", "Salary" };
            String[][] data = {
                { "1", "John Doe", "60000" },
                { "2", "Jane Smith", "65000" },
                { "3", "Michael Johnson", "70000" },
                { "4", "Emily Davis", "55000" },
                { "5", "David Brown", "72000" },
                { "6", "Sarah Wilson", "48000" },
                { "7", "James Taylor", "58000" },
                { "8", "Jessica Lee", "53000" },
                { "9", "Chris Martin", "62000" },
                { "10", "Patricia Miller", "50000" }
            };

            try (FileWriter writer = new FileWriter("employees.csv")) {
                for (String header : headers) {
                    writer.append(header);
                    writer.append(",");
                }
                writer.append("\n");

                for (String[] row : data) {
                    for (String cell : row) {
                        writer.append(cell);
                        writer.append(",");
                    }
                    writer.append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class SortCSV implements Runnable {
        @Override
        public void run() {
            List<String[]> data = new ArrayList<>();
            String line;
            String splitBy = ",";

            try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
                String[] headers = br.readLine().split(splitBy);
                data.add(headers);

                while ((line = br.readLine()) != null) {
                    String[] employee = line.split(splitBy);
                    data.add(employee);
                }

                data.subList(1, data.size()).sort(Comparator.comparingInt(o -> Integer.parseInt(o[2])));

                try (FileWriter writer = new FileWriter("employees_sorted.csv")) {
                    for (String[] row : data) {
                        writer.append(String.join(",", row));
                        writer.append("\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new WriteCSV(), "WriteCsvThread");
        t1.start();
        t1.join();

        Thread t2 = new Thread(new SortCSV(), "SortCsvThread");
        t2.start();
        
    }
}
