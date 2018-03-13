import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {
    private String name;
    private int sumCount = 0;
    private int countUser = 0;

    public Country(String name) {
        this.name = name;
    }

    public void addSumCount(int sumCount) {
        this.sumCount += sumCount;
    }

    public void addCountUser() {
        this.countUser++;
    }
}
