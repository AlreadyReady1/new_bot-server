package hunter.destruct.client.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//todo: пойдет, только избавляйся от привычки выводить в System.out. Ставь перед классом аннотацию ломбока @Slf4j и используй log.info()/
//log.info("IN getByEmail -> user with email {} not found", email) - вот так можно его использовать. Аргументы по очереди подставляются вместо {}
public class CSVconverter {

    public static void saveCSV(List<String> listOfStrings){
        try (PrintWriter writer = new PrintWriter(new File("D://Bot//textSaveMetod.csv"))) {
          writer.write("\ufeff");


            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < listOfStrings.size() - 1 ; i++) {
            sb.append(listOfStrings.get(i));
//            sb.append(separator);
        }

        // last string, no separator
        if(listOfStrings.size() > 0){
            sb.append(listOfStrings.get(listOfStrings.size()-1));
        }

            writer.write(sb.toString());
            writer.close();
            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        CSVconverter testCSV =  new CSVconverter();
        testCSV.readCSVFile();
    }

    public void readCSVFile(){
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("D://Bot//textSaveMetod.csv"));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

}
