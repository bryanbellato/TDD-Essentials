package test.java.br.com.bellato.dao;

import main.java.br.com.bellato.dao.IClientDAO;
import main.java.br.com.bellato.domain.Client;
import main.java.br.com.bellato.exception.KeyTypeNotFoundException;

import java.util.Collection;
import java.util.List;

public class ClientDAOMock implements IClientDAO {


    @Override
    public Boolean register(Client entity) throws KeyTypeNotFoundException {
        return true;
    }

    @Override
    public void remove(Long value) {

    }

    @Override
    public void update(Client entity) throws KeyTypeNotFoundException {

    }

    @Override
    public Client search(Long value) {
        Client client = new Client();
        client.setCpf(value);
        return client;
    }

    @Override
    public Collection<Client> searchAll() {
        return List.of();
    }

}
