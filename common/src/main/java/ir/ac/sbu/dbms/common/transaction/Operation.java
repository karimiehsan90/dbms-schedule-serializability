package ir.ac.sbu.dbms.common.transaction;

import ir.ac.sbu.dbms.common.database.DB;

import java.util.Map;

public interface Operation {
    void operate(DB db, Map<String, Integer> transactionMemoryData);
}
