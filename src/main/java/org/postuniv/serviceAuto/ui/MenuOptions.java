package org.postuniv.serviceAuto.ui;

public enum MenuOptions {

    EXIT ("Exit"),
    SEARCH_CAR_AND_CLIENT_BY_NAME ("Search of cars and clients - full text"),
    //    3.4. Căutare mașini și clienți. Căutare full text.
    SHOW_TRANSACTIONS_BETWEEN_TWO_DATES ("Show all transactions between tow dates"),
    //    3.5. Afișarea tuturor tranzacțiilor cu suma cuprinsă într-un interval dat.
    SHOW_CARS_BY_REPARATION_COSTS ("Show all cars ordered by repaid labor costs in descending order"),
    //    3.6. Afișarea mașinilor ordonate descrescător după suma obținută pe manoperă.
    CLIENT_CARDS_BY_DISCOUNTS ("Show all client card ordered by total discount in descending order"),
    //    3.7. Afișarea cardurilor client ordonate descrescător după valoarea reducerilor obținute.
    DELETE_TRANSACTIONS_BETWEEN_TWO_DATES ("Delete all transactions between an two dates"),
    //    3.8. Ștergerea tuturor tranzacțiilor dintr-un anumit interval de zile.
    UPDATE_CAR_WARRANTY_STATUSES ("Update cars' warranty statuses");
    //    3.9. Actualizarea garanției la fiecare mașină: o mașină este în garanție
    //    dacă și numai dacă are maxim 3 ani de la achiziție și maxim 60 000 de km.

    private final String optionName;

    private MenuOptions(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionName() {
        return this.optionName;
    }











}
