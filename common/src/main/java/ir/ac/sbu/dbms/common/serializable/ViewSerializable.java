package ir.ac.sbu.dbms.common.serializable;

import ir.ac.sbu.dbms.common.transaction.Schedule;

public class ViewSerializable implements Serializable {

    // TODO implement
    @Override
    public boolean isSerializable(Schedule firstSchedule, Schedule secondSchedule) {
        return false;
    }
}
