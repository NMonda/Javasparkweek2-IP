package ke.co.pookie.config;

import org.sql2o.Sql2o;

public class Database {
    private static final Sql2o connection = new Sql2o (

            "jdbc:postgresql://localhost:5432/hero_squad_db",
            "postgres",
            "01234"
    );
    public static Sql2o getConnect() { return connection; }
}
