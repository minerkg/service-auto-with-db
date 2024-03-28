package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.ClientCard;

import java.util.List;


public interface
ClientCardRepository {
    boolean addNewClientCard(ClientCard clientCard);

    boolean removeClientCard(int id);

    List<ClientCard> getAllClientCards();

    ClientCard getClientCard(String firstName, String lastName);

    boolean updateClientCard(ClientCard updatedClientCard);
}
