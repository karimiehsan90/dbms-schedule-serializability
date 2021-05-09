package ir.ac.sbu.dbms;

import ir.ac.sbu.dbms.common.database.DB;
import ir.ac.sbu.dbms.common.parser.Parser;
import ir.ac.sbu.dbms.common.serializable.ResultSerializable;
import ir.ac.sbu.dbms.common.transaction.Schedule;

// TODO remove. It's for test now
public class App {
    public static void main( String[] args ) {
        String[] inputLines = new String[]{
                "# x = 2",
                "# y = 5",
                "<1 , 1 , R(x)>",
                "<2 , 1 , x = x + 5>",
                "<3 , 1 , W(x)>",
                "<4 , 2 , R(x)>",
                "<5 , 2 , x = x * 3>",
                "<6 , 2 , W(x)>",
                "<7 , 1 , R(y)>",
                "<8 , 1 , y = y + 5>",
                "<9 , 1 , W(y)>"
        };
        DB db = DB.getInstance();
        Parser parser = new Parser();
        Schedule schedule = parser.parse(db, inputLines);
        System.out.println(schedule.isSerializable(new ResultSerializable()));
    }
}
