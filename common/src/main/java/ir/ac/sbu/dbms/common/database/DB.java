package ir.ac.sbu.dbms.common.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DB {
    private static DB instance;

    private Map<String, Integer> data;

    private DB() {
        this.data = new HashMap<>();
    }

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    public static DB getSnapshot() {
        DB snapshot = new DB();
        for (String variable : instance.data.keySet()) {
            snapshot.data.put(variable, instance.data.get(variable));
        }
        return snapshot;
    }

    public Integer read(String query) {
        return this.data.get(query);
    }

    public void write(String query, Integer value) {
        this.data.put(query, value);
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DB db = (DB) o;
        return Objects.equals(data, db.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
