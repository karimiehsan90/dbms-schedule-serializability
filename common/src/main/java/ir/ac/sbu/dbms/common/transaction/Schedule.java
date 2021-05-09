package ir.ac.sbu.dbms.common.transaction;

import ir.ac.sbu.dbms.common.database.DB;
import ir.ac.sbu.dbms.common.serializable.Serializable;

import java.util.List;

public class Schedule {
    private DB db;
    private List<Operation> operations;

    public Schedule(DB db, List<Operation> operations) {
        this.db = db;
        this.operations = operations;
    }

    // TODO implement

    /**
     * executes the operations on the database
     * @return result state of the execution
     */
    public DB execute() {
        return null;
    }

    // TODO implement
    private Schedule getSerialSchedule() {
        return null;
    }

    public boolean isSerializable(Serializable serializable) {
        return serializable.isSerializable(this, getSerialSchedule());
    }

    public DB getDb() {
        return this.db;
    }
}
