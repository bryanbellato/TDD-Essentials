package main.java.br.com.bellato.dao;

import main.java.br.com.bellato.domain.Client;

public class ClientDAO implements IClientDAO {

    @Override
    public Boolean save(Client client) {
        // TODO
        return true;
    }

    @Override
    public Client searchByCPF(Long cpf) {
        return null;
    }
}
