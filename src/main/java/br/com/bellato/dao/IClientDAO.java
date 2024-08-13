package main.java.br.com.bellato.dao;

import main.java.br.com.bellato.domain.Client;

public interface IClientDAO {

    Boolean save(Client client);

    Client searchByCPF(Long cpf);

}
