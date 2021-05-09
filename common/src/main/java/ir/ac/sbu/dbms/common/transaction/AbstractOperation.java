package ir.ac.sbu.dbms.common.transaction;

public abstract class AbstractOperation implements Operation {
    private int transactionId;
    private int operationId;

    public AbstractOperation(int transactionId, int operationId) {
        this.transactionId = transactionId;
        this.operationId = operationId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public int getOperationId() {
        return operationId;
    }
}
