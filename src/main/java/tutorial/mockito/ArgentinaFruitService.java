package tutorial.mockito;

import java.util.Collection;
import java.util.stream.Collectors;

public class ArgentinaFruitService {

    FruitDAO fruitDAO = new FruitDAO();

    public Collection<Fruit> getAllApples() {
        return fruitDAO.find(Fruit.Country.ARGENTINA)
                .stream()
                .filter(fruit -> fruit.getName().equals("Apple"))
                .collect(Collectors.toList());
    }

}
