package test.java.br.com.bellato;

import main.java.br.com.bellato.dao.IClientDAO;
import main.java.br.com.bellato.domain.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.java.br.com.bellato.dao.ClientDAOMock;


public class ClientDAOTest {

    private IClientDAO clientDAO;
    private Client client;

    public ClientDAOTest() {
        clientDAO = new ClientDAOMock();
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

        clientDAO.save(client);
    }

    @Test
    public void searchClient() {
        Client clientSearched = clientDAO.searchByCPF(client.getCpf());
        Assert.assertNotNull(clientSearched);
    }

}
