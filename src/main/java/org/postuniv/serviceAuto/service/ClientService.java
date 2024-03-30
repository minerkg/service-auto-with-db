package org.postuniv.serviceAuto.service;

import org.postuniv.serviceAuto.repository.ClientCardRepository;

import java.time.LocalDate;
import java.util.Date;

public class ClientService {
    private final ClientCardRepository clientCardRepository;

    public ClientService(ClientCardRepository clientCardRepository) {
        this.clientCardRepository = clientCardRepository;
    }

    // ----------Client Card services --------------------------------------------------

    // ---add
    // TODO: CNP must be unique, we have to check it here
    public boolean addNewClientCard(int id, String firstName, String lastName, String CNP, Date birthDate, LocalDate registrationDate) {
        // - implementation
        return true;
    }

    // ---delete
    // ---update
    // ---read one
    // full text search
    // ---read all


}
