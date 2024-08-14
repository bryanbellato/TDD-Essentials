package main.java.br.com.bellato;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * This Singleton class guarantee that <code>map</code> will be unique on the application lifetime.
 *
 */

public class SingletonMap {

    private static SingletonMap singletonMap;

    /**
     * Contains all the apllication registrations.
     * It simulates the database.
     */
    protected Map<Class, Map<Long, ?>> map;

    private SingletonMap() {
        map = new HashMap<>();
    }

    /**
     * This method guarantee the return of only an instance of this object.
     *
     * @return SingletonMap
     */
    public static SingletonMap getInstance() {
        if (singletonMap == null) {
            singletonMap = new SingletonMap();
        }
        return singletonMap;
    }

    public Map<Class, Map<Long, ?>> getMap() {
        return this.map;
    }
}
