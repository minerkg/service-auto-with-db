package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.Car;
import org.postuniv.serviceAuto.domain.Transaction;
import org.postuniv.serviceAuto.service.TransactionService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class ReadTransactionFromFile {

    public static void readTransaction(TransactionService transactionService){
        try {
            String src = "src/main/java/org/postuniv/serviceAuto/mock_data/mock_transactions200.txt";
            FileReader fileReader = new FileReader(src);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine;

            while ((currentLine = bufferedReader.readLine()) !=null){

                String [] stringSplitted = currentLine.split(",");
                int id = Integer.parseInt(stringSplitted[0]);
                int carId = Integer.parseInt(stringSplitted[1]);
                int clientCardId;
                try {
                    clientCardId = Integer.parseInt(stringSplitted[2]);
                }catch (NumberFormatException nrfe){
                    clientCardId =0;
                }
                double partPrice = Double.parseDouble(stringSplitted[3]);
                double laborPrice = Double.parseDouble(stringSplitted[4]);
                long transStamp = Long.parseLong(stringSplitted[5]);
                LocalDateTime transactionDate = LocalDateTime.ofEpochSecond(transStamp,0, ZoneOffset.UTC);

                Transaction transaction = new Transaction(id,carId,clientCardId,partPrice,laborPrice,transactionDate);
                transactionService.addNewTransaction(transaction);
            }
            bufferedReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
