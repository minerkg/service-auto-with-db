package org.postuniv.serviceAuto.service;

import org.postuniv.serviceAuto.domain.ClientCard;
import org.postuniv.serviceAuto.repository.CarServiceRepo;

import java.util.List;

public class ClientService {
    private final CarServiceRepo<ClientCard> clientCardRepository;

    public ClientService(CarServiceRepo<ClientCard> clientCardRepository) {
        this.clientCardRepository = clientCardRepository;
    }

    // ---add
    // TODO: CNP must be unique, we have to check it here
    public boolean addNewClientCard(ClientCard newClinetCard) {
        return this.clientCardRepository.save(newClinetCard);
    }

    // ---delete
    public boolean removeClientCard(int idClientCard) {
        return this.clientCardRepository.delete(idClientCard);
    }


    // ---update

    public boolean updateClientCard(ClientCard updatedClientCard) {
        return this.clientCardRepository.update(updatedClientCard);
    }


    // ---read one
    // full text search

    public ClientCard getClientCard(String firstName, String lastName) {
        return this.clientCardRepository.findAll().stream().
                filter(clientCard -> clientCard.getFirstName().contains(firstName) ||
                        clientCard.getLastName().contains(lastName)).
                findFirst().
                orElse(null);
    }
    public ClientCard getClientCardById(int id){
        return clientCardRepository.findAll().
                stream().
                filter(clientCard -> clientCard.getId() == id).
                findFirst().
                orElse(null);
    }


    // ---read all
    public List<ClientCard> getAllClientCards() {
        return this.clientCardRepository.findAll().stream().toList();
    }


}
