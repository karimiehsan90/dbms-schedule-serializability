package ir.ac.sbu.dbms;

import ir.ac.sbu.dbms.common.database.DB;

// TODO remove. It's for test now
public class App {
    public static void main( String[] args ) {
        DB db = DB.getInstance();
        db.write("a", 20);
        db.write("b", 2);
        int a = db.read("a");
        int b = db.read("b");
        a = a / 2;
        b = b + 2;
        db.write("a", a);
        db.write("b", b);
        System.out.println(db);
    }
}
