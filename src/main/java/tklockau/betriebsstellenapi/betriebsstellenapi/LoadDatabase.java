/**
 * LoadDatabase wird bei der Initialisierung der API ausgeführt und lädt die Daten aus der 
 * CSV-Datei ein und speichert sie als betriebsstellen-Objekte ab. Dafür wird zuerst die zu 
 * verwendende CSV-Datei vom Benutzer abgefragt.
 * 
 * AUTOR: Tobias Klockau
 */

package tklockau.betriebsstellenapi.betriebsstellenapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
	
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Configuration
public class LoadDatabase {
    
    private String[] titles;
    private String csvPath;
    private Boolean isCsvValid;
    private BufferedReader csvReader;

    @Bean
    CommandLineRunner initDatabase(
        BetriebsstellenRepository repository
    ) throws FileNotFoundException, IOException{

        System.out.println("\n----------------------------------------------");

        do{
            isCsvValid = true;

            // Öffnet einen JFileChooser, mit welcher der Benutzer die CSV-Datei auswählen kann
            System.out.print("Datei wird abgefragt ...\r");
            int fileChooserResult;
            System.setProperty("java.awt.headless", "false");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("CSV-Datei", "csv"));
            fileChooser.setDialogTitle("Betriebsstellen CSV auswählen");
            fileChooserResult = fileChooser.showOpenDialog(null);

            if (fileChooserResult == JFileChooser.APPROVE_OPTION) {
                System.out.print("Datei wird abgefragt ... erledigt\n");

                try {

                    // Öffnet die CSV
                    System.out.print("Datei wird geöffnet ...\r");
                    csvPath = fileChooser.getSelectedFile().getAbsolutePath();
                    csvReader = new BufferedReader(new FileReader(csvPath));
                    System.out.print("Datei wird geöffnet  ... erledigt\n");

                } catch (FileNotFoundException e){
                    System.out.print("Datei wird abgefragt ... [Fehler] Die Datei konnte nicht geöffnet werden!\n");
                    isCsvValid = false;
                }

            } else {
                System.out.print("Datei wird abgefragt ... [Fehler] Bitte wählen Sie eine CSV-Datei aus!\n");
                isCsvValid = false;
            }

        }while (!isCsvValid);

        // Liest die Kopfzeile ein
        System.out.print("Daten werden geladen ...\r");
        titles = csvReader.readLine().split(";");

        String csvRow;
        String[] csvRowSplit;

        while ((csvRow = csvReader.readLine()) != null){
            csvRowSplit = csvRow.split(";");
            
            repository.save(new Betriebsstelle(
                csvRowSplit[0], 
                Arrays.copyOfRange(csvRowSplit, 1, csvRowSplit.length), 
                Arrays.copyOfRange(titles, 1, titles.length)
            ));
        }

        csvReader.close();
        System.out.print("Daten werden geladen ... erledigt\n");
        System.out.println("----------------------------------------------\n");

        return args -> {};
    }
}
