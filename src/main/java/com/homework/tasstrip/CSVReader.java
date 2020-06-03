package com.homework.tasstrip;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class CSVReader {

    public ArrayList<List<String>> readCSV(String filePath) throws IOException {
        ArrayList<List<String>> records = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null){
            String[] values = line.split(";");
            records.add(Arrays.asList(values));
        }
        return records;
    }
}
