package main.java.br.com.bellato.services;

import main.java.br.com.bellato.domain.Client;
import main.java.br.com.bellato.exception.KeyTypeNotFoundException;

public interface IClientService {

    Boolean save(Client client) throws KeyTypeNotFoundException;

    Client searchByCPF(Long cpf);

    void remove(Long cpf);

    void update(Client client) throws KeyTypeNotFoundException;
}
