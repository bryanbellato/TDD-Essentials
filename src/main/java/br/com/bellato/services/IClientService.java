package main.java.br.com.bellato.services;

import main.java.br.com.bellato.domain.Client;

public interface IClientService {

    Boolean save(Client client);

    Client searchByCPF(Long cpf);

    void remove(Long cpf);

    void update(Client client);
}
