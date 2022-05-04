package hunter.destruct.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.List;

@Slf4j
public class CSVSaver extends Component {


    public void saveCSV(List<String> listOfStrings) {

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("csv files (*.csv)", "csv");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setFileFilter(filter);
        int retValue = fileChooser.showDialog(this, "Save File");

        if (retValue == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();
            if (FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("csv")) {
                // filename is OK as-is
            } else {
                file = new File(file.toString() + ".csv"); 
                fileChooser.setSelectedFile(file);
            }
            try (Writer fileWrite = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(fileChooser.getSelectedFile())))) {

                fileWrite.write("\ufeff");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < listOfStrings.size() - 1; i++) {
                    sb.append(listOfStrings.get(i));
                }

                // last string, no separator
                if (listOfStrings.size() > 0) {
                    sb.append(listOfStrings.get(listOfStrings.size() - 1));
                }

                fileWrite.write(sb.toString());
                fileWrite.close();
                log.info("rabotaet!!!");


            } catch (IOException e) {
                log.error(" vse xuina, peredelivai!!!!!1", e);
            }


        }
    }


}
