import java.util.Objects;

public class TransactionNode {
    public int resourceValue;
    public TransactionManager lockNode = null;
    public TransactionNode(int value) throws Exception {
        if (value < 0) {
            throw new Exception("Value must be greater than 0: %d".formatted(value));
        }
        this.resourceValue = value;
    }

    public TransactionNode(int value, TransactionManager lockNode) throws Exception {
        if (value < 0) {
            throw new Exception("Value must be greater than 0: %d".formatted(value));
        }
        this.lockNode = lockNode;
        this.resourceValue = value;
    }
    public boolean acquireLock(TransactionManager manager) {
        if (this.lockNode != null) {
            return false;
        } else {
            this.lockNode = manager;
            return true;
        }
    }
    public boolean checkCommit(Transaction transaction) {
        if (Objects.equals(transaction.operator, "-")) {
            return this.resourceValue >= transaction.value;
        }
        return true;
    }

    public boolean commit(Transaction transaction) {
        if (checkCommit(transaction)) {
            if (Objects.equals(transaction.operator, "-")) {
                this.resourceValue -= transaction.value;
            } else {
                this.resourceValue += transaction.value;
            }
            return true;
        }
        return false;
    }
}
