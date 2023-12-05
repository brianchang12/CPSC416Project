import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestCapstone {

    public TransactionNode node1;
    public TransactionNode node2;
    public TransactionManager manager;

    public Client client;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws Exception {
        this.node1 = new TransactionNode(20);
        this.node2 = new TransactionNode(30);
        this.manager = new TransactionManager("commit");
        this.client = new Client(this.manager);

    }

    @Test
    public void TestTransaction() throws Exception {
        this.client.move(10, node1, node2);
        Assertions.assertEquals(this.node1.resourceValue, 10);
        Assertions.assertEquals(this.node2.resourceValue, 40);
    }
}