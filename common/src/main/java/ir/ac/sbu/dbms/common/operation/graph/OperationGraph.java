package ir.ac.sbu.dbms.common.operation.graph;

import java.util.Objects;
import java.util.Set;

public class OperationGraph {
    private Set<OperationNode> nodes;

    public OperationGraph(Set<OperationNode> nodes) {
        this.nodes = nodes;
    }

    public Set<OperationNode> getNodes() {
        return nodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationGraph that = (OperationGraph) o;
        return Objects.equals(nodes, that.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes);
    }

    @Override
    public String toString() {
        return "OperationGraph{" +
                "nodes=" + nodes +
                '}';
    }
}
