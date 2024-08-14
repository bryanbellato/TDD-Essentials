package test.java.br.com.bellato;

import main.java.br.com.bellato.dao.IClientDAO;
import main.java.br.com.bellato.domain.Client;
import main.java.br.com.bellato.exception.KeyTypeNotFoundException;
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
    public void init() throws KeyTypeNotFoundException {
        client = new Client();
        client.setCpf(123456789L);
        client.setName("Fulano");
        client.setAddress("Fim do Mundo");
        client.setCity("Black Hole");
        client.setState("Somewhere in your nearest galaxy.");
        client.setPhone(40028922L);

        clientDAO.register(client);
    }

    @Test
    public void searchClient() {
        Client clientSearched = clientDAO.search(client.getCpf());
        Assert.assertNotNull(clientSearched);
    }

    @Test
    public void saveClient() throws KeyTypeNotFoundException {
        Boolean save_return = clientDAO.register(client);
        Assert.assertTrue(save_return);
    }

    @Test
    public void removeClient() {
        clientDAO.remove(client.getCpf());
    }

    @Test
    public void updateClient() throws KeyTypeNotFoundException {
        client.setName("Beltrano");
        clientDAO.update(client);

        Assert.assertEquals("Beltrano", client.getName());;
    }


}
