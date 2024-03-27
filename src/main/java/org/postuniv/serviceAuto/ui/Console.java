package org.postuniv.serviceAuto.ui;

import org.postuniv.serviceAuto.service.CarServiceService;

public class Console {

    private final CarServiceService carServiceService;

    public Console(CarServiceService carServiceService) {
        this.carServiceService = carServiceService;
    }

    public void runMenu() {
        System.out.println("Main menu implementation");
    }

}
