package ir.ac.sbu.dbms.common.operation;

import ir.ac.sbu.dbms.common.database.DB;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class WriteOperation extends AbstractOperation {
    private String variable;

    public WriteOperation(int transactionId, int operationId, String variable) {
        super(transactionId, operationId);
        this.variable = variable;
    }

    @Override
    public void operate(DB db, Map<String, Integer> transactionMemoryData) {
        db.write(variable, transactionMemoryData.get(variable));
    }

    @Override
    protected List<String> getWorkingVariables() {
        return Collections.singletonList(variable);
    }
}
