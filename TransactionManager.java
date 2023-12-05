public class TransactionManager {

    public String state;

    public TransactionManager(String state) {
        this.state = state;
    }

    public boolean transact(Transaction transaction1, TransactionNode node1, Transaction transaction2, TransactionNode node2) {
        boolean prepareResult = prepare(node1, node2);
        if (!prepareResult) {
            return false;
        }
        if (!prepareCommit(transaction1, node1)) {
            node1.lockNode = null;
            node2.lockNode = null;
            return false;
        }
        if (!prepareCommit(transaction2, node2)) {
            node1.lockNode = null;
            node2.lockNode = null;
            return false;
        }
        return node1.commit(transaction1) && node2.commit(transaction2);
    }

    public boolean prepare(TransactionNode node1, TransactionNode node2){
        boolean ret = true;
        boolean node1Lock = node1.acquireLock(this);
        boolean node2Lock = node2.acquireLock(this);
        if (!node1Lock) {
            if (node2Lock) {
                node2.lockNode = null;
            }
            ret = false;
        }
        if (!node2Lock) {
            if (node1Lock) {
                node1.lockNode = null;
            }
            ret = false;
        }
        return ret;

    }
    public boolean prepareCommit(Transaction transaction, TransactionNode node) {
        return node.checkCommit(transaction);
    }
    public boolean commit(Transaction transaction, TransactionNode node) {
        return node.commit(transaction);
    }

}
