package ir.ac.sbu.dbms.common.serializable;

import ir.ac.sbu.dbms.common.operation.graph.OperationGraph;
import ir.ac.sbu.dbms.common.transaction.Schedule;

public class ConflictSerializable implements Serializable {

    @Override
    public boolean isSerializable(Schedule firstSchedule, Schedule secondSchedule) {
        OperationGraph firstConflictPrecedenceGraph = firstSchedule.getConflictPrecedenceGraph();
        OperationGraph secondConflictPrecedenceGraph = secondSchedule.getConflictPrecedenceGraph();
        return firstConflictPrecedenceGraph.equals(secondConflictPrecedenceGraph);
    }
}
