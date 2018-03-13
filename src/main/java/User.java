import lombok.Data;

@Data
public class User {
    private String name;
    private int count;
    private String country;

    public User(String name, int count, String country) {
        this.name = name;
        this.count = count;
        this.country = country;
    }
}
