import java.util.Objects;

public class Transaction {
    public String operator;
    public int value;

    public Transaction(String operator, int value) throws Exception {
        if (!Objects.equals(operator, "+") && !Objects.equals(operator, "-")) {
            throw new Exception("Not a valid operator");
        }
        if (value < 0) {
            throw new Exception("Value is less than 0");
        }
        this.operator = operator;
        this.value = value;
    }
}
