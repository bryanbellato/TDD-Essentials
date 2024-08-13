package test.java.br.com.bellato.dao;

import main.java.br.com.bellato.dao.IClientDAO;
import main.java.br.com.bellato.domain.Client;

public class ClientDAOMock implements IClientDAO {

    @Override
    public Boolean save(Client client) {
        // TODO
        return true;
    }

    @Override
    public Client searchByCPF(Long cpf) {
        Client client = new Client();
        client.setCpf(cpf);
        return client;
    }

    @Override
    public void remove(Long cpf) {
        // TODO
    }

}
