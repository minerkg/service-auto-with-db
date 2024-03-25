package org.postuniv.serviceAuto.repository;

import org.postuniv.serviceAuto.domain.ClinetCard;

public interface ClientCardRepository {
    public void addNewClientCard(ClinetCard clinetCard);
    public void removeClientCard(int id);
    public void getAllClientCards();
    public void getClientCard(String firstName, String lastName);
    public void updateClientCard();

}
