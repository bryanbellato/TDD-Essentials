package test.java.br.com.bellato.dao;

import main.java.br.com.bellato.dao.IClientDAO;
import main.java.br.com.bellato.domain.Client;

public class ClientDaoMock implements IClientDAO {

    @Override
    public void save(Client client) {
        // TODO
    }

    @Override
    public Client searchByCPF(Long cpf) {
        Client client = new Client();
        client.setCpf(cpf);
        return client;
    }

}
