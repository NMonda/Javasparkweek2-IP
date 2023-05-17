package ke.co.pookie.dao;

import ke.co.pookie.Hero;
import org.sql2o.Sql2o;

public class HeroDao {
    private final static Sql2o sql2o = Database.getDatabase();
    public static void add(Hero newHero){
        public void createHero(Connection sql, Hero hero) {
            try {
                sql.createQuery("INSERT INTO heroes (heroname, power, weakness, squadid) VALUES (:name, :power, :weakness, :squadId)", true)
                        .bind(hero)
                        .executeUpdate();
            } catch (Exception e) {
                throw new RuntimeException("Error Occured", e);
            }
        }

        public void deleteHero(Connection sql, int id) {
            sql.createQuery("DELETE FROM heroes WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        }

        public void updateHero(Connection sql, Hero hero) {
            sql.createQuery("UPDATE heroes SET heroName = :name, power = :power, weakness = :weakness, squadId = :squadId WHERE id = :id")
                    .bind(hero)
                    .executeUpdate();
        }
}
