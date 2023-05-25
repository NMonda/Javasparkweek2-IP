package ke.co.pookie.dao;

import ke.co.pookie.Hero;
import ke.co.pookie.config.Database;
import org.sql2o.Connection;

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
            String heroAdd ="INSERT INTO heroes (heroName, power, weakness, squadId) VALUES (:name, :power, :weakness, :squadId)";
            db.createQuery(heroAdd).bind(newHero).executeUpdate();
        } catch (Exception error) {
            System.out.println(error.getMessage());}
    }

        public void deleteHero(String name) {
            try(Connection db = Database.getConnect().open()){
                String deletedHero = "DELETE FROM heroes WHERE id = : id";
                db.createQuery(deletedHero).addParameter("hero", name).executeUpdate();
            } catch (Exception error) { System.out.println(error.getMessage());}
        }

        public void updateHero(String hero, String squad) {
            try(Connection db = Database.getConnect().open()){
                String heroUpdate = "UPDATE heroes SET heroName = :name, power = :power, weakness = :weakness, squadId = :squadId WHERE id = :id";
                db.createQuery(heroUpdate).addParameter("hero", hero).addParameter("squad", squad).executeUpdate();
            } catch (Exception error) { System.out.println(error.getMessage());}
        }
        public Hero getHero( int id) {
            try(Connection db = Database.getConnect().open()){
                    String heroUpdate= "SELECT * FROM heroes WHERE id = :id";
                db.createQuery(heroUpdate).addParameter("id").executeUpdate();
            } catch (Exception error) { System.out.println(error.getMessage());}
            return null;
        }

    //UPDATES THE HERO DETAILS TO INCLUDE THE SQUAD ID
    public static void updateId (String hero, String squad) {
        try(Connection db = Database.getConnect().open()){
            String heroUpdate = "UPDATE heroes SET squad = (:squad) WHERE hero = (:hero)";
            db.createQuery(heroUpdate).addParameter("hero", hero).addParameter("squad", squad).executeUpdate();
        } catch (Exception error) { System.out.println(error.getMessage());}
    }

}
