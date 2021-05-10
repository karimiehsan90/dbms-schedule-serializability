package ir.ac.sbu.dbms.common.operation.graph;

import ir.ac.sbu.dbms.common.operation.AbstractOperation;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class OperationNode {
    private AbstractOperation operation;
    private Set<AbstractOperation> adjList;

    public OperationNode(AbstractOperation operation, Set<AbstractOperation> adjList) {
        this.operation = operation;
        this.adjList = adjList;
    }

    public AbstractOperation getOperation() {
        return operation;
    }

    public Set<AbstractOperation> getAdjList() {
        return adjList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationNode that = (OperationNode) o;
        return Objects.equals(operation, that.operation) &&
                Objects.equals(adjList, that.adjList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, adjList);
    }

    @Override
    public String toString() {
        return "OperationNode{" +
                "operation=" + operation +
                ", adjList=" + adjList +
                '}';
    }
}
