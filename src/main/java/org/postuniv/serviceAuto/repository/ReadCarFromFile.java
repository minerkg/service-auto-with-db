package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;


public class ReadCarFromFile {
    public ReadCarFromFile() {
    }

    public static void readFromTextFile(CarServiceRepository carServiceRepository){

        try {
            String filePath = "src/main/java/org/postuniv/serviceAuto/mock_data/mock_cars.txt";
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine;

            while ((currentLine = bufferedReader.readLine()) !=null){

                String [] stringSplitted = currentLine.split(",");
                int id = Integer.parseInt(stringSplitted[0]);
                String model = stringSplitted[1];
                String date = stringSplitted[2];
                LocalDate localDate = LocalDate.parse(date);
                int km = Integer.parseInt(stringSplitted[3]);
                boolean warranty = Boolean.parseBoolean(stringSplitted[4]);
                Car car = new Car(id,model,localDate,km,warranty);
                carServiceRepository.save(car);

            }
            bufferedReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
