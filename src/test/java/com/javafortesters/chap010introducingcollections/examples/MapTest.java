package com.javafortesters.chap010introducingcollections.examples;

import com.javafortesters.domainentities.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class MapTest {
    /*
    * A Map is a collection where each element is a value, and it is stored with an associated key.
    * The Map is a collection of key value pairs.
    * Each key must be unique.
    * And each key maps to only one value
    */

    private Map<String, String> map = new HashMap<>();

    @Before
    public void createMapAsHashMap() {
        Map<String, User> mapa = new HashMap<>();
        Map<String, User> mapb = new HashMap<String, User>();
        Map<String, User> mapc = new <String, User>HashMap();
    }

    @Test
    public void putInsteadOfAdd() {
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        assertEquals(3, map.size());
    }

    /*If I put a “key, value” pair, where the key already exists in the Map then the old value will be overwritten with the new value:*/
    @Test
    public void putSameKeyPairOverwritesValue() {
        putInsteadOfAdd();

        map.put("key1", "newvalue1");
        assertEquals("newvalue1", map.get("key1"));
    }

    /*get(k) to retrieve a value from the Map*/
    @Test
    public void getToRetrieveValueFromMap() {
        putSameKeyPairOverwritesValue();

        assertEquals("newvalue1", map.get("key1"));
        assertEquals("value2", map.get("key2"));
        assertEquals("value3", map.get("key3"));
    }

    @Test
    public void removeToRemoveKyValuePair() {
        getToRetrieveValueFromMap();

        map.remove("key1");
        assertEquals(2, map.size());
        assertFalse(map.containsKey("key1"));
    }

    @Test
    public void clearToEmpltyWoleMap() {
        removeToRemoveKyValuePair();

        map.clear();
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }

    @Test
    public void checkContentsWithContainsKeyAndCntainsValue() {
        Map<String, String> m = new HashMap<>();
        m.put("k1", "v1");
        m.put("k2", "v2");
        m.put("k3", "v3");

        assertTrue(m.containsKey("k1"));
        assertFalse(m.containsKey("k12"));
        assertTrue(m.containsValue("v2"));
        assertFalse(m.containsValue("v123"));
    }

    @Test
    public void putAllToAddMapToAnotherMap() {
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");

        Map<String, String> mapToAdd = new HashMap<>();
        mapToAdd.put("k1", "kv1");
        mapToAdd.put("k4", "v4");

        map.putAll(mapToAdd);

        assertEquals(4, map.size());
        assertEquals("kv1", map.get("k1"));
    }

    @Test
    public void keySetReturnsSetOfKeys() {
        putInsteadOfAdd();

        /*
        * values() returns a Collection view of the values contained in this map.
        * The collection is backed by the map, so changes to the map are reflected in the collection, and vice-versa. Cant add -only remove.
        */
        Collection<String> mapValues = map.values(); /* Collection is an Interface! What class Collection interface is implemented by? - AbstractSollection*/
        mapValues.remove("value3");
        assertEquals(2, map.size());
    }

    @Test
    public void valuesReturnsCollectionOfValues() {
        putInsteadOfAdd();
        Set<String> mapKeys = map.keySet(); /*Set is an Interface. What class Set interface is implemented by? - AbstractSet?
    }

    @Test
    public void entrySetReturnsSetOfEntries() {
        /*An Entry is the “key, value” pair*/
        putInsteadOfAdd();
        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            entry.setValue("bobo");
        }
    }
}
