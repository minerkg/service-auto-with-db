package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.ClientCard;

public interface ClientCardRepository {
    public void addNewClientCard(ClientCard clientCard);
    public boolean removeClientCard(int id);
    public void getAllClientCards();
    public void getClientCard(String firstName, String lastName);
    public void updateClientCard();

}
