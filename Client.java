public class Client {

    public TransactionManager manager;

    public Client(TransactionManager manager) {
        this.manager = manager;
    }

    public void move(int amount, TransactionNode node1, TransactionNode node2) throws Exception {
        Transaction subTransaction = new Transaction("-", amount);
        Transaction addTransaction = new Transaction("+", amount);
        this.manager.transact(subTransaction, node1, addTransaction, node2);
    }

}
