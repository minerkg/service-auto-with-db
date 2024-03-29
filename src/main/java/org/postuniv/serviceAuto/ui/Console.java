package org.postuniv.serviceAuto.ui;

import org.postuniv.serviceAuto.service.CarServiceService;

import java.util.Scanner;

public class Console {

    private final CarServiceService carServiceService;
    private MenuOptions menuOptions;

    public Console(CarServiceService carServiceService) {
        this.carServiceService = carServiceService;
    }

    private void showMenuItems() {
        System.out.println("\n*** Please select the operation which you want to perform: ***");
        int optionNumber = 0;
        for (MenuOptions menuOption: MenuOptions.values()) {
            System.out.println(optionNumber + ". " + menuOption.getOptionName());
            optionNumber++;
        }
        System.out.println("***                                                        ***");
    }


    public void runMenu() {
        boolean menuIsRunning = true;
        MenuOptions selectedOption;
        while (menuIsRunning) {
            showMenuItems();
            selectedOption = MenuOptions.values()[new Scanner(System.in).nextInt()];
            System.out.println("You selected: " + selectedOption.getOptionName());
            switch (selectedOption) {
                case EXIT:
                    break;
                case SEARCH_CAR_AND_CLIENT_BY_NAME:
                    break;
                case SHOW_TRANSACTIONS_BETWEEN_TWO_DATES:
                    break;
                case SHOW_CARS_BY_REPARATION_COSTS:
                    break;
                case CLIENT_CARDS_BY_DISCOUNTS:
                    break;
                case DELETE_TRANSACTIONS_BETWEEN_TWO_DATES:
                    break;
                case UPDATE_CAR_WARRANTY_STATUSES:
                    break;
            }
        }
    }



//    3.4. Căutare mașini și clienți. Căutare full text.
//3.5. Afișarea tuturor tranzacțiilor cu suma cuprinsă într-un interval dat.
//3.6. Afișarea mașinilor ordonate descrescător după suma obținută pe manoperă.
//3.7. Afișarea cardurilor client ordonate descrescător după valoarea reducerilor obținute.
//3.8. Ștergerea tuturor tranzacțiilor dintr-un anumit interval de zile.
//3.9. Actualizarea garanției la fiecare mașină: o mașină este în garanție dacă și numai dacă are maxim 3 ani de la achiziție și maxim 60 000 de km.

}
