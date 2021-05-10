package ir.ac.sbu.dbms.common.transaction;

import ir.ac.sbu.dbms.common.database.DB;
import ir.ac.sbu.dbms.common.operation.AbstractOperation;
import ir.ac.sbu.dbms.common.operation.comparator.SerialComparator;
import ir.ac.sbu.dbms.common.operation.graph.OperationGraph;
import ir.ac.sbu.dbms.common.operation.graph.OperationNode;
import ir.ac.sbu.dbms.common.serializable.Serializable;

import java.util.*;

public class Schedule {
    private DB db;
    private List<AbstractOperation> operations;
    private Map<Integer, Map<String, Integer>> memoryData = new HashMap<>();

    public Schedule(DB db, List<AbstractOperation> operations) {
        this.db = db;
        this.operations = operations;
    }

    /**
     * executes the operations on the database
     * @return result state of the execution
     */
    public DB execute() {
        for (AbstractOperation operation : operations) {
            memoryData.putIfAbsent(operation.getTransactionId(), new HashMap<>());
            operation.operate(db, memoryData.get(operation.getTransactionId()));
        }
        return db;
    }

    public OperationGraph getConflictPrecedenceGraph() {
        Set<OperationNode> resultNodes = new HashSet<>();
        for (int i = 0; i < operations.size(); i++) {
            Set<AbstractOperation> hasConflictOperations = new HashSet<>();
            for (int j = i + 1; j < operations.size(); j++) {
                if (operations.get(i).hasConflict(operations.get(j))) {
                    hasConflictOperations.add(operations.get(j));
                }
            }
            resultNodes.add(new OperationNode(operations.get(i), hasConflictOperations));
        }
        return new OperationGraph(resultNodes);
    }

    public Schedule getSerialSchedule() {
        DB serialScheduleDb = DB.getSnapshot();
        List<AbstractOperation> serialScheduleOperations = new ArrayList<>(operations);
        serialScheduleOperations.sort(new SerialComparator());
        return new Schedule(serialScheduleDb, serialScheduleOperations);
    }

    public boolean isSerializable(Serializable serializable) {
        return serializable.isSerializable(this, getSerialSchedule());
    }

    public DB getDb() {
        return this.db;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "db=" + db +
                ", operations=" + operations +
                '}';
    }
}
