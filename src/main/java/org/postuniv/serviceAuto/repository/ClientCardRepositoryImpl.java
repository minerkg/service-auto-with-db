package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.ClientCard;

import java.util.ArrayList;
import java.util.List;

public class ClientCardRepositoryImpl implements ClientCardRepository{

    private List<ClientCard> clientCardsList;

    public ClientCardRepositoryImpl() {
        clientCardsList = new ArrayList<>();
    }

    @Override
    public void addNewClientCard(ClientCard clientCard) {
        clientCardsList.add(clientCard);
    }

    @Override
    public boolean removeClientCard(int id) {
         return clientCardsList.removeIf(clientCard -> clientCard.getId() == id);
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
