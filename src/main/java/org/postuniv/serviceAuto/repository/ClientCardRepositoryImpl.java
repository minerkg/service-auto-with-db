package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.ClinetCard;

import java.util.ArrayList;
import java.util.List;

public class ClientCardRepositoryImpl implements ClientCardRepository{

    private List<ClinetCard> clientCardsList;

    public ClientCardRepositoryImpl() {
        clientCardsList = new ArrayList<>();
    }

    @Override
    public void addNewClientCard(ClinetCard clinetCard) {
        clientCardsList.add(clinetCard);
    }

    @Override
    public boolean removeClientCard(int id) {
         return clientCardsList.removeIf(clinetCard -> clinetCard.getId() == id);
    }

    @Override
    public void getAllClientCards() {

    }

    @Override
    public void getClientCard(String firstName, String lastName) {

    }

    @Override
    public void updateClientCard() {

    }
}
