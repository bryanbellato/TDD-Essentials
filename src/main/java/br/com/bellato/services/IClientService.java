package main.java.br.com.bellato.services;

import main.java.br.com.bellato.domain.Client;

public interface IClientService {

    void save(Client client);

    Client searchByCPF(Long cpf);

}
