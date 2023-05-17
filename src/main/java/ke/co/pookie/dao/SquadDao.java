package ke.co.pookie.dao;

import ke.co.pookie.Squad;
import org.sql2o.Sql2o;

public class SquadDao {
    private final static Sql2o sql2o = Database.getDatabase();
    public static void (Connection sql, Squad squad) {
        try{
            String sqlQuery = "INSERT INTO squads (squad name,cause, maxsize, create) VALUES (:squadName, :cause, :maxSize, :createdAt)";
            return  (int)sql.createQuery(sqlQuery, true)
                    .bind(squad)
                    .executeUpdate().getKey();

        }catch (Exception e){
            throw new RuntimeException("Error Occurred", e);
        }
    }
}
