package tutorial.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


@RunWith(Parameterized.class)
public class FruitDAOTest {

    private FruitDAO fruitDAO = new FruitDAO();

    @Parameter
    public String fruitName;

    @Parameters(name = "{0}")
    public static Collection fruitNames() {
        return Arrays.asList(new Object[][] {
                { "Apple" },
                { "Orange" },
        });
    }


    @Test
    public void should_return_only_fruits_with_specified_name () throws Exception {
        //given
        String currentFruitName = fruitName;

        //when
        Collection<Fruit> fruits = fruitDAO.find(fruitName);
        List<String> names = fruits.stream().map(Fruit::getName).collect(toList());

        //then
        assertThat(names, everyItem(equalTo(fruitName)));
    }

}