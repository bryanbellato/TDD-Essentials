package main.java.br.com.bellato.services;
import main.java.br.com.bellato.dao.ClientDAO;
import main.java.br.com.bellato.dao.IClientDAO;
import main.java.br.com.bellato.domain.Client;

public class ClientService implements IClientService {

    private IClientDAO clientDAO;

    public ClientService(IClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public Boolean save(Client client) {
        return clientDAO.save(client);
    }

    @Override
    public Client searchByCPF(Long cpf) {
        return clientDAO.searchByCPF(cpf);
    }

}
