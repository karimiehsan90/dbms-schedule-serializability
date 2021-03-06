package ir.ac.sbu.dbms.common.operation.comparator;

import ir.ac.sbu.dbms.common.operation.AbstractOperation;

import java.util.Comparator;

public class SerialComparator implements Comparator<AbstractOperation> {
    @Override
    public int compare(AbstractOperation o1, AbstractOperation o2) {
        if (o1.getTransactionId() != o2.getTransactionId()) {
            return o1.getTransactionId() - o2.getTransactionId();
        }
        return o1.getOperationId() - o2.getOperationId();
    }
}
