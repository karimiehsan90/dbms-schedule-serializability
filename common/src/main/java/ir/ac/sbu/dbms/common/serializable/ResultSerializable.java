package ir.ac.sbu.dbms.common.serializable;

import ir.ac.sbu.dbms.common.database.DB;
import ir.ac.sbu.dbms.common.transaction.Schedule;

public class ResultSerializable implements Serializable {
    @Override
    public boolean isSerializable(Schedule firstSchedule, Schedule secondSchedule) {
        DB firstScheduleState = firstSchedule.execute();
        DB secondScheduleState = secondSchedule.execute();
        return firstScheduleState.equals(secondScheduleState);
    }
}
