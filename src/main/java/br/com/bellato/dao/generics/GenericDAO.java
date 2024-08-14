package main.java.br.com.bellato.dao.generics;

import main.java.br.com.bellato.SingletonMap;
import main.java.br.com.bellato.annotation.KeyType;
import main.java.br.com.bellato.domain.Persistent;
import main.java.br.com.bellato.exception.KeyTypeNotFoundException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

public abstract class GenericDAO<T extends Persistent> implements IGenericDAO<T> {

    private SingletonMap singletonMap;

    public abstract Class<T> getClassType();

    public abstract void updateData(T entity, T entityRegistered);

    public GenericDAO() {
        this.singletonMap = SingletonMap.getInstance();
    }

    public Long getKey(T entity) throws KeyTypeNotFoundException {
        Field[] fields = entity.getClass().getDeclaredFields();
        Long returnValue = null;
        for (Field field : fields) {
            if (field.isAnnotationPresent(KeyType.class)) {
                KeyType keyType = field.getAnnotation(KeyType.class);
                String methodName = keyType.value();
                try {
                    Method method = entity.getClass().getMethod(methodName);
                    returnValue = (Long) method.invoke(entity);
                    return returnValue;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    throw new KeyTypeNotFoundException("Main key of the object " + entity.getClass() + " not found", e);
                }
            }
        }
        if (returnValue == null) {
            String msg = "Main key of the object " + entity.getClass() + " not found";
            System.out.println("**** ERROR ****" + msg);
            throw new KeyTypeNotFoundException(msg);
        }
        return null;
    }

    @Override
    public Boolean register(T entity) throws KeyTypeNotFoundException {
        Map<Long, T> internMap = (Map<Long, T>) this.singletonMap.getMap().get(getClassType());
        Long keyg = getKey(entity);
        if (internMap.containsKey(keyg)) {
            return false;
        }

        internMap.put(keyg, entity);
        return true;
    }

    @Override
    public void remove(Long value) {
        Map<Long, T> internMap = (Map<Long, T>) this.singletonMap.getMap().get(getClassType());
        T registeredObject = internMap.get(value);
        if (registeredObject != null) {
            internMap.remove(value, registeredObject);
        }
    }

    @Override
    public void update(T entity) throws KeyTypeNotFoundException {
        Map<Long, T> internMap = (Map<Long, T>) this.singletonMap.getMap().get(getClassType());
        Long keyg = getKey(entity);
        T registeredObject = internMap.get(keyg);
        if (registeredObject != null) {
            updateData(entity, registeredObject);
        }
    }

    @Override
    public T search(Long value) {
        Map<Long, T> internMap = (Map<Long, T>) this.singletonMap.getMap().get(getClassType());
        return internMap.get(value);
    }

    @Override
    public Collection<T> searchAll() {
        Map<Long, T> internMap = (Map<Long, T>) this.singletonMap.getMap().get(getClassType());
        return internMap.values();
    }
}
