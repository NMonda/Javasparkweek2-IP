package ke.co.pookie.dao;

import ke.co.pookie.Hero;
import ke.co.pookie.config.Database;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;


public class HeroDao {
    // LIST ALL HEROES
    public static List<Hero> getAllHeroes (){
        List<Hero> allHeroes = null;

        try(Connection db = Database.getConnect().open()){
            String heroes = "SELECT * FROM heroes;";
            allHeroes = db.createQuery(heroes).executeAndFetch(Hero.class);

        } catch (Exception error) {
            System.out.println(error.getMessage());
            return allHeroes;
        }

        return allHeroes;
    }
    public static void add(Hero newHero){
        try(Connection db = Database.getConnect().open()){
            String heroAdd ="INSERT INTO heroes (heroName, power, weakness, squadId) VALUES (:name, :power, :weakness, :squadId)"
            db.createQuery(heroAdd).bind(newHero).executeUpdate();
        } catch (Exception error) {
            System.out.println(error.getMessage());}
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
        public Hero getHero(Connection sql, int id) {
            try {
                return sql.createQuery("SELECT * FROM heroes WHERE id = :id")
                        .addParameter("id", id)
                        .executeAndFetchFirst(Hero.class);
            } catch (Exception e) {
                throw new RuntimeException("Error Occured", e);
            }
        }

        public List<Hero> getAllHeroes(Connection sql) {
            return sql.createQuery("SELECT * FROM heroes")
                    .executeAndFetch(Hero.class);
        }
}
