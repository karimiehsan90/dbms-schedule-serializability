package ir.ac.sbu.dbms.common.parser;

import ir.ac.sbu.dbms.common.database.DB;
import ir.ac.sbu.dbms.common.operation.*;
import ir.ac.sbu.dbms.common.operation.comparator.OperatorIdComparator;
import ir.ac.sbu.dbms.common.transaction.*;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    // TODO maybe a better implementation
    public Schedule parse(DB db, String[] lines) {
        List<AbstractOperation> operations = new ArrayList<>(lines.length);
        for (String line : lines) {
            if (line.startsWith("#")) {
                String[] lineSplit = line.split("[#\\s=]+");
                // First item is an empty string
                operations.add(new InitialOperation(lineSplit[1], Integer.parseInt(lineSplit[2])));
            } else if (line.startsWith("<")) {
                String[] lineSplit = line.split("[<>\\s,=]+");
                int operationId = Integer.parseInt(lineSplit[1]);
                int transactionId = Integer.parseInt(lineSplit[2]);
                if (lineSplit[3].startsWith("R")) {
                    String variable = lineSplit[3].substring(2, 3);
                    operations.add(new ReadOperation(transactionId, operationId, variable));
                } else if (lineSplit[3].startsWith("W")) {
                    String variable = lineSplit[3].substring(2, 3);
                    operations.add(new WriteOperation(transactionId, operationId, variable));
                } else {
                    String result = lineSplit[3];
                    String op1 = lineSplit[4];
                    String operator = lineSplit[5];
                    String op2 = lineSplit[6];
                    operations.add(new BinaryOperation(transactionId, operationId, op1, op2, operator, result));
                }
            }
        }
        operations.sort(new OperatorIdComparator());
        return new Schedule(db, operations);
    }
}
