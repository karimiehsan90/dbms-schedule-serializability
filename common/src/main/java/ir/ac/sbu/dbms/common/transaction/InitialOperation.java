package ir.ac.sbu.dbms.common.transaction;

import ir.ac.sbu.dbms.common.database.DB;

import java.util.Map;

public class InitialOperation extends AbstractOperation {
    private String variable;
    private int value;

    public InitialOperation(String variable, int value) {
        super(0, 0);
        this.variable = variable;
        this.value = value;
    }

    @Override
    public void operate(DB db, Map<String, Integer> transactionMemoryData) {
        db.write(variable, value);
    }
}
