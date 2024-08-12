package test.java.br.com.bellato;

import main.java.br.com.bellato.domain.Client;
import org.junit.Test;

public class ClientTest {

    @Test
    public void searchClient() {
        Client client = new Client();
        client.setCpf(123456789L);
        client.setName("Fulano");
        client.setAddress("Fim do Mundo");
        client.setCity("Black Hole");
        client.setState("Somewhere in your nearest galaxy.");
        client.setPhone(40028922L);
    }
}
