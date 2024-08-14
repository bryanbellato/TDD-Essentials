package main.java.br.com.bellato.dao.generics;

import main.java.br.com.bellato.domain.Persistent;
import main.java.br.com.bellato.exception.KeyTypeNotFoundException;

import java.util.Collection;

public interface IGenericDAO <T extends Persistent> {

    public Boolean register(T entity) throws KeyTypeNotFoundException;

    public void remove(Long value);

    public void update(T entity) throws KeyTypeNotFoundException;

    public T search(Long value);

    public Collection<T> searchAll();
}
