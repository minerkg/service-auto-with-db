package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.ClientCard;

import java.util.List;

public interface ClientCardRepository {
    public void addNewClientCard(ClientCard clientCard);
    public boolean removeClientCard(int id);
    public List<ClientCard> getAllClientCards();
    public ClientCard getClientCard(String firstName, String lastName);
    public boolean updateClientCard(ClientCard clientCard);

}
