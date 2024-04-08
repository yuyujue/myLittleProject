package com.example.store.util;

import com.example.store.model.Clothes;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvUtil {

    public List<Clothes> readClothesFromCsv(String filePath) throws IOException {
        try (Reader reader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(reader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {

            ArrayList<Clothes> clothesList = new ArrayList<>();

            for (CSVRecord csvRecord : csvParser) {
                String name = csvRecord.get("name");
                String season = csvRecord.get("season");
                String color = csvRecord.get("color");
                Integer thickness = Integer.parseInt(csvRecord.get("thickness"));
                Clothes clothes = Clothes.builder()
                        .name(name)
                        .season(season)
                        .color(color)
                        .thickness(thickness)
                        .build();

                clothesList.add(clothes);
            }
            return clothesList;
        }
    }
}
