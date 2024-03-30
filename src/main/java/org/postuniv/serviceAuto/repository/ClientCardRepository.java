package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.ClientCard;

import java.util.List;


public interface
ClientCardRepository {
    boolean addNewClientCard(ClientCard clientCard);

    boolean removeClientCard(int id);

    List<ClientCard> getAllClientCards();

    public ClientCard getClientCard(int id);

    boolean updateClientCard(ClientCard updatedClientCard);
}
