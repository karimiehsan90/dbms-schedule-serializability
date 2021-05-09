package ir.ac.sbu.dbms.common.transaction;

import java.util.Comparator;

public class OperatorIdComparator implements Comparator<AbstractOperation> {
    @Override
    public int compare(AbstractOperation o1, AbstractOperation o2) {
        return o1.getOperationId() - o2.getOperationId();
    }
}
