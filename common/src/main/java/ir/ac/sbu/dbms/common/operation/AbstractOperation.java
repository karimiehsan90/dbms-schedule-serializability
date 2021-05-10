package ir.ac.sbu.dbms.common.operation;

import java.util.List;
import java.util.stream.Collectors;

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

    // TODO implement
    @Override
    public boolean hasConflict(AbstractOperation that) {
        // At least one of them must be write operation
        if (!(this instanceof WriteOperation || that instanceof WriteOperation)) {
            return false;
        }
        // The operations must be in different transactions
        if (this.transactionId == that.transactionId) {
            return false;
        }
        // This should work on the same data
        // If any of working variables in this list is in that list, they work on the same data
        return this.getWorkingVariables().stream().anyMatch(that.getWorkingVariables()::contains);
    }

    protected abstract List<String> getWorkingVariables();

    @Override
    public String toString() {
        return "AbstractOperation{" +
                "transactionId=" + transactionId +
                ", operationId=" + operationId +
                '}';
    }
}
