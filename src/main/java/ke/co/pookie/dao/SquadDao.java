package ke.co.pookie.dao;

import ke.co.pookie.models.Squad;
import ke.co.pookie.config.Database;
import org.sql2o.Connection;

import java.util.List;

public class SquadDao {
    //GETS A LIST OF ALL THE SQUADS IN OUR Database
    public static List<Squad> getAllSquads (){
        List<Squad> allSquads = null;
        try(Connection db = Database.getConnect().open()){
            String squads = "SELECT * FROM squads;";
            allSquads = db.createQuery(squads).executeAndFetch(Squad.class);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return allSquads;
        }
        return allSquads;
    }

    //ADDS NEW SQUAD DETAILS TO THE Database
    public static void addSquad(Squad newSquad) {
        try(Connection db = Database.getConnect().open()){
            String squadAdd = "INSERT INTO squads (squad,cause, size) VALUES (:squad, :cause, :size);";
            db.createQuery(squadAdd).bind(newSquad).executeUpdate();
        } catch (Exception error) { System.out.println(error.getMessage());}
    }

    //RETURNS THE SET SQUAD SIZE FROM THE Database
    public static Integer maxSize (String squad) {
        List<Squad> squadSize = null;
        try(Connection db = Database.getConnect().open()){
            String sizeList = "SELECT size from squads WHERE squad = (:squad)"; //gets the size
            squadSize = db.createQuery(sizeList).addParameter("squad", squad).executeAndFetch(Squad.class);
        } catch (Exception error) { System.out.println(error.getMessage());}
        return squadSize.get(0).getSize();
    }

    //DELETES A SQUAD FROM THE Database
    public static void deleteSquad(String name){
        try(Connection db = Database.getConnect().open()){
            String deletedSquad = "DELETE FROM squads WHERE squad = (:squad);";
            db.createQuery(deletedSquad).addParameter("squad", name).executeUpdate();
        } catch (Exception error) { System.out.println(error.getMessage());}
    }

}