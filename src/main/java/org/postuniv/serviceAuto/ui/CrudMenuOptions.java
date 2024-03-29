package org.postuniv.serviceAuto.ui;

public enum CrudMenuOptions {

    BACK ("Back"),
    CREATE ("Creat new item"),
    READ ("Find all items"),
    UPDATE ("Update selected item"),
    DELETE("Delete selected item");


    private final String optionName;

    private CrudMenuOptions(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionName() {
        return this.optionName;
    }

}
