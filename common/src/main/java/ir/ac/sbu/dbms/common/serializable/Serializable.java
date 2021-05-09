package ir.ac.sbu.dbms.common.serializable;

import ir.ac.sbu.dbms.common.transaction.Schedule;

public interface Serializable {
    boolean isSerializable(Schedule firstSchedule, Schedule secondSchedule);
}
