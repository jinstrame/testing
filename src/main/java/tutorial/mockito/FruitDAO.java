package tutorial.mockito;

import tutorial.mockito.Fruit.Country;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static tutorial.mockito.Fruit.Country.ARGENTINA;
import static tutorial.mockito.Fruit.Country.TURKEY;


public class FruitDAO {

    private static Map<Integer, Fruit> storage = Collections.synchronizedMap(new HashMap<>());

    static {
        storage.put(1, new Fruit(1, "Apple", ARGENTINA));
        storage.put(2, new Fruit(2, "Orange", TURKEY));
        storage.put(3, new Fruit(3, "Mellon", ARGENTINA));
    }


    public Collection<Fruit> find(String name) {
        return find(f -> f.getName().equals(name));
    }

    public Collection<Fruit> find(Country country) {
        return find(f -> f.getCountry() == country);
    }

    public Optional<Fruit> find(Integer id) {
        return Optional.ofNullable(storage.get(id));
    }

    private Collection<Fruit> find(Predicate<Fruit> predicate) {
        return storage.values()
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public Collection<Fruit> all() {
        return storage.values();
    }








}
