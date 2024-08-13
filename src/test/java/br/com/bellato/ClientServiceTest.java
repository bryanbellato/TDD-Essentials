package test.java.br.com.bellato;

import main.java.br.com.bellato.dao.IClientDAO;
import main.java.br.com.bellato.domain.Client;
import main.java.br.com.bellato.services.ClientService;
import main.java.br.com.bellato.services.IClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import test.java.br.com.bellato.dao.ClientDaoMock;

public class ClientServiceTest {

    private IClientService clientService;
    private Client client;

    public ClientServiceTest() {
        IClientDAO dao = new ClientDaoMock();
        clientService = new ClientService(dao);
    }

    @Before
    public void init() {
        client = new Client();
        client.setCpf(123456789L);
        client.setName("Fulano");
        client.setAddress("Fim do Mundo");
        client.setCity("Black Hole");
        client.setState("Somewhere in your nearest galaxy.");
        client.setPhone(40028922L);

        clientService.save(client);
    }

    @Test
    public void searchClient() {
        Client clientSearched = clientService.searchByCPF(client.getCpf());
        Assert.assertNotNull(clientSearched);
    }

}
