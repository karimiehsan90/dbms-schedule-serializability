package ir.ac.sbu.dbms.common.transaction;

import ir.ac.sbu.dbms.common.database.DB;

import java.util.Map;

public class ReadOperation extends AbstractOperation {
    private String variable;

    public ReadOperation(int transactionId, int operationId,String variable) {
        super(transactionId, operationId);
        this.variable = variable;
    }

    @Override
    public void operate(DB db, Map<String, Integer> transactionMemoryData) {
        transactionMemoryData.put(variable, db.read(variable));
    }
}
