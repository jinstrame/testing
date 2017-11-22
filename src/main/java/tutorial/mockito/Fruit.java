package tutorial.mockito;

import lombok.Data;
import lombok.NonNull;

@Data
public class Fruit {

    public enum Country {
        ARGENTINA,
        TURKEY,
        EGYPT;
    }

    @NonNull
    private final int id;
    @NonNull
    private final String name;
    @NonNull
    private final Country country;
}
