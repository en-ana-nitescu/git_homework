package practice;

//import org.testng.annotations.Test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapHomework {

     /*
    --------------------------------------------------------
    Tema: Lucru cu HashMap in Java
    --------------------------------------------------------

    Creeaza doua HashMap-uri diferite:
       - Un HashMap<String, String> pentru nume si oras.
       - Un HashMap<String, String> pentru produse si preturi (ex: "Laptop" -> "5000 RON").

    Creeaza cate o functie pentru fiecare metoda comuna folosita cu HashMap:
       - put() → adauga o pereche cheie-valoare.
       - get() → returneaza valoarea pentru o cheie data.
       - containsKey() → verifica daca o cheie exista.
       - remove() → sterge o pereche cheie-valoare.
       - replace() → inlocuieste valoarea unei chei existente.
       - putIfAbsent() → adauga o valoare doar daca cheia nu exista deja.

    iteratii cu entrySet():
       - Foloseste for-each pentru a parcurge entrySet().
       - Printeaza fiecare pereche cheie-valoare.

    iteratii cu lambda function:
       - Foloseste .forEach() pentru a itera prin HashMap.
       - Printeaza fiecare pereche cheie-valoare.
    --------------------------------------------------------
    */

    private Map<String, String> nameCityMap = new HashMap<>();
    private Map<String, String> productPriceMap = new HashMap<>();

    public void addEntry(Map<String, String> map, String key, String value) {
        map.put(key, value);
    }

    public String getValue(Map<String, String> map, String key) {
        return map.get(key);
    }

    public boolean containsKey(Map<String, String> map, String key) {
        return map.containsKey(key);
    }

    public void removeEntryByKey(Map<String, String> map, String key) {
        map.remove(key);
    }

    public void removeEntryByKeyValue(Map<String, String> map, String key, String value) {
        map.remove(key, value);
    }

    public void replaceByKey(Map<String, String> map, String key, String newValue) {
        map.replace(key, newValue);
    }

    public void replaceByKeyValue(Map<String, String> map, String key, String oldValue, String newValue) {
        map.replace(key, oldValue, newValue);
    }

    public void putIfAbsent(Map<String, String> map, String key, String value) {
        map.putIfAbsent(key, value);
    }

    public void iterateWithEntrySet(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }

    public void iterateWithLambda(Map<String, String> map) {
        map.forEach((key, value) -> System.out.println(key + ", " + value));
    }

    @Test
    public void testMethod() {
        addEntry(nameCityMap, "Jane", "New York");
        addEntry(nameCityMap, "Joe", "Chicago");
        addEntry(nameCityMap, "Sarah", "Los Angeles");

        addEntry(productPriceMap, "laptop", "500EUR");
        addEntry(productPriceMap, "book", "10EUR");
        addEntry(productPriceMap, "perfume", "75EUR");

        System.out.println("Get value: " + getValue(nameCityMap, "Jane"));
        System.out.println("Get value: " + getValue(productPriceMap, "laptop"));

        System.out.println("Contains key: " + containsKey(nameCityMap, "Jane"));
        System.out.println("Contains key: " + containsKey(productPriceMap, "bag"));

        removeEntryByKey(nameCityMap, "Sarah");
        removeEntryByKeyValue(productPriceMap, "perfume", "75EUR");

        replaceByKey(nameCityMap, "Joe", "Philadelphia");
        replaceByKeyValue(productPriceMap, "book", "10EUR", "9.99EUR");

        putIfAbsent(nameCityMap, "Sarah", "Los Angeles");
        putIfAbsent(productPriceMap, "perfume", "50EUR");

        System.out.println("\nIterate with entrySet");
        iterateWithEntrySet(nameCityMap);
        iterateWithEntrySet(productPriceMap);

        System.out.println("\nIterate with lambda");
        iterateWithLambda(nameCityMap);
        iterateWithLambda(productPriceMap);
    }
}
