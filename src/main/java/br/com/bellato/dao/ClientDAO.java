package main.java.br.com.bellato.dao;

import main.java.br.com.bellato.dao.generics.GenericDAO;
import main.java.br.com.bellato.domain.Client;

public class ClientDAO extends GenericDAO<Client> implements IClientDAO {

    public ClientDAO() {
        super();
    }

    @Override
    public Class<Client> getClassType() {
        return Client.class;
    }

    @Override
    public void updateData(Client entity, Client entityRegistered) {

    }


}
