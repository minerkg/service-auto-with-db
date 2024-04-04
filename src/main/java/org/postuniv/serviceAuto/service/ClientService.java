package org.postuniv.serviceAuto.service;

import org.postuniv.serviceAuto.domain.ClientCard;
import org.postuniv.serviceAuto.repository.ClientCardRepository;
import org.postuniv.serviceAuto.repository.ReadClientCardFromFile;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ClientService {
    private final ClientCardRepository clientCardRepository;

    public ClientService(ClientCardRepository clientCardRepository) {
        this.clientCardRepository = clientCardRepository;
        ReadClientCardFromFile.readFromTextFile(clientCardRepository);
    }

    // ---add
    // TODO: CNP must be unique, we have to check it here
    public boolean addNewClientCard(ClientCard newClinetCard) {
        return this.clientCardRepository.addNewClientCard(newClinetCard);
    }

    // ---delete
    public boolean removeClientCard(int idClientCard) {
        return this.clientCardRepository.removeClientCard(idClientCard);
    }


    // ---update

    public boolean updateClientCard(ClientCard updatedClientCard) {
        return this.clientCardRepository.updateClientCard(updatedClientCard);
    }


    // ---read one
    // full text search

    public ClientCard getClientCard(String firstName, String lastName) {
        return this.clientCardRepository.getAllClientCards().stream().
                filter(clientCard -> clientCard.getFirstName().contains(firstName) ||
                        clientCard.getLastName().contains(lastName)).
                findFirst().
                orElse(null);
    }
    public ClientCard getClientCardById(int id){
        return clientCardRepository.getClientCard(id);
    }


    // ---read all
    public List<ClientCard> getAllClientCards() {
        return this.clientCardRepository.getAllClientCards().stream().toList();
    }


}
