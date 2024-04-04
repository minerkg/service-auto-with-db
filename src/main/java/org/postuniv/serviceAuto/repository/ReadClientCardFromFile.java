package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.Car;
import org.postuniv.serviceAuto.domain.ClientCard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class ReadClientCardFromFile {

    public static void readFromTextFile(ClientCardRepository clientCardRepository){

        try {
            String filePath = "src/main/java/org/postuniv/serviceAuto/mock_data/mock_clientcard.txt";
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine;

            while ((currentLine = bufferedReader.readLine()) !=null){

                String [] stringSplitted = currentLine.split(",");
                int id = Integer.parseInt(stringSplitted[0]);
                String firstName = stringSplitted[1];
                String lastName = stringSplitted[2];
                String CNP = stringSplitted[3];
                String birthDate = stringSplitted[4];
                LocalDate birthDateFormatted = LocalDate.parse(birthDate);
                String registrationDate = stringSplitted[5];
                LocalDate registrationDateFormatted = LocalDate.parse(registrationDate);

                ClientCard clientCard = new ClientCard(id,firstName,lastName,CNP,birthDateFormatted,registrationDateFormatted);
                clientCardRepository.addNewClientCard(clientCard);

            }
            bufferedReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
