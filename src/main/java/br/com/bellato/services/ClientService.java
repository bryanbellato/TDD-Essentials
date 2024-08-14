package main.java.br.com.bellato.services;
import main.java.br.com.bellato.dao.ClientDAO;
import main.java.br.com.bellato.dao.IClientDAO;
import main.java.br.com.bellato.domain.Client;
import main.java.br.com.bellato.exception.KeyTypeNotFoundException;

public class ClientService implements IClientService {

    private IClientDAO clientDAO;

    public ClientService(IClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public Boolean save(Client client) throws KeyTypeNotFoundException {
        return clientDAO.register(client);
    }

    @Override
    public Client searchByCPF(Long cpf) {
        return clientDAO.search(cpf);
    }

    @Override
    public void remove(Long cpf) {
        clientDAO.remove(cpf);
    }

    @Override
    public void update(Client client) throws KeyTypeNotFoundException {
        clientDAO.update(client);
    }

}
