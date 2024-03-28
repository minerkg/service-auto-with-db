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
    public boolean addNewClientCard(ClientCard clientCard) {
        return clientCardsList.add(clientCard);
    }

    @Override
    public boolean removeClientCard(int id) {
         return clientCardsList.removeIf(clientCard -> clientCard.getId() == id);
    }

    @Override
    public List<ClientCard> getAllClientCards() {
        return clientCardsList.stream().toList();
    }

    @Override
    public ClientCard getClientCard(String firstName, String lastName) {
        return clientCardsList.stream().
                filter(clientCard -> clientCard.getFirstName().contains(firstName) ||
                        clientCard.getLastName().contains(lastName)).
                findFirst().
                orElse(null);
    }

    @Override
    public boolean updateClientCard(ClientCard updatedClientCard) {
        for (ClientCard clientCard: clientCardsList) {
            if (clientCard.getId() == updatedClientCard.getId()) {
                clientCard = updatedClientCard;
                return true;
            }
        }
        return false;
    }
}
