package main.java;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class realEstateCSV{
private static final String Real_Estate = "./real-estate-data.csv";

public static void main(String [] args ) throws IOException {

    try(
    Reader reader = Files.newBufferedReader(Paths.get(Real_Estate));
    CSVParser csvParser = new CSVParser (reader, CSVFormat.DEFAULT
    .withHeader("Street", "City", "Zip", "State", "Beds", "Baths", "sq_ft", "type", "sale_date", "price" )
    .withIgnoreHeaderCase()
    .withTrim());
    
    )
    {
        for (CSVRecord  csvRecord:csvParser) 
        {
            String Street = csvRecord.get("Street");
            String City = csvRecord.get("City");
            String Zip = csvRecord.get("Zip");
            String State = csvRecord.get("State");
            String Beds = csvRecord.get("Beds");
            String Baths= csvRecord.get("Baths");
            String sq_ft= csvRecord.get("sq_ft");
            String type = csvRecord.get("type");
            String sale_date = csvRecord.get(" sale_date");
            String Price = csvRecord.get("price");
                
            }
        }

    }

}


