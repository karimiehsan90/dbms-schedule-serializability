package ir.ac.sbu.dbms.common.operation;

import ir.ac.sbu.dbms.common.database.DB;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BinaryOperation extends AbstractOperation {
    private String op1;
    private String op2;
    private String operator;
    private String result;

    public BinaryOperation(int transactionId, int operationId,String op1, String op2, String operator, String result) {
        super(transactionId, operationId);
        this.op1 = op1;
        this.op2 = op2;
        this.operator = operator;
        this.result = result;
    }

    // TODO maybe a better implementation
    @Override
    public void operate(DB db, Map<String, Integer> transactionMemoryData) {
        int op1Value;
        if (op1.matches("^\\d+$")) {
            op1Value = Integer.parseInt(op1);
        } else {
            op1Value = transactionMemoryData.get(op1);
        }

        int op2Value;
        if (op2.matches("^\\d+$")) {
            op2Value = Integer.parseInt(op2);
        } else {
            op2Value = transactionMemoryData.get(op2);
        }

        int resultValue;
        switch (operator) {
            case "+":
                resultValue = op1Value + op2Value;
                break;
            case "-":
                resultValue = op1Value - op2Value;
                break;
            case "*":
                resultValue = op1Value * op2Value;
                break;
            case "/":
                resultValue = op1Value / op2Value;
                break;
            default:
                throw new RuntimeException("Unknown operator " + operator);
        }
        transactionMemoryData.put(result, resultValue);
    }

    @Override
    protected List<String> getWorkingVariables() {
        List<String> workingVariables = new ArrayList<>();
        workingVariables.add(result);
        if (!op1.matches("^\\d+$")) {
            workingVariables.add(op1);
        }
        if (!op2.matches("^\\d+$")) {
            workingVariables.add(op2);
        }
        return workingVariables;
    }
}
