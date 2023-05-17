package ke.co.pookie;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        staticFileLocation("/public");

        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
        get("/new/squad", (req, res) -> {
            return new ModelAndView(new HashMap<>(), "create_squad.hbs");
        }, new HandlebarsTemplateEngine());

        // Get all heroes
        get("/heroes", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("heroes", heroDao.getAllHeroes(sql));

            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());

        // Get all squads
        get("/squads", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("squads", squadsDao.getAllSquads(sql));
            return new ModelAndView(model, "squads.hbs");
        }, new HandlebarsTemplateEngine());

        // Get a hero by id
        get("/heroes/:id", (req, res) -> {
            return heroDao.getHero(sql, Integer.parseInt(req.params(":id")));
        });

        // Get a squad by id
        get("/squads/:id", (req, res) -> {
            return squadsDao.getSquad(sql, Integer.parseInt(req.params(":id")));
        });

        // Get a hero by squad id
        get("/squads/:id/heroes", (req, res) -> {
            return heroDao.getHeroBySquadId(sql, Integer.parseInt(req.params(":id")));
        });

        // Create a hero
        post("/heroes", (req, res) -> {
            Hero hero = new Hero(0, req.queryParams("name"), req.queryParams("power"), req.queryParams("weakness"), Integer.parseInt(req.queryParams("squadId")));
            heroDao.createHero(sql, hero);
            res.redirect("/heroes");
            return hero;
        });

        // Create a squad
        post("/squads", (req, res) -> {
            Squad squad = new Squad(0, req.queryParams("name"), req.queryParams("cause"), Integer.parseInt(req.queryParams("maxsize")), LocalDateTime.now());
            squadsDao.createSquad(sql, squad);
            res.redirect("/squads");
            return squad;
        });

        // Update a hero
        post("/heroes/:id", (req, res) -> {
            Hero hero = new Hero(Integer.parseInt(req.params(":id")), req.queryParams("name"), req.queryParams("power"), req.queryParams("weakness"), Integer.parseInt(req.queryParams("squadId")));
            heroDao.updateHero(sql, hero);
            return hero;
        });

        // Update a squad
        post("/squads/:id", (req, res) -> {
            Squad squad = new Squad(Integer.parseInt(req.params(":id")), req.queryParams("name"), req.queryParams("cause"), Integer.parseInt(req.queryParams("maxsize")), LocalDateTime.now());
            squadsDao.updateSquad(sql, squad);
            return squad;
        });

        // Delete a hero
        post("/heroes/:id/delete", (req, res) -> {
            heroDao.deleteHero(sql, Integer.parseInt(req.params(":id")));
            return "Hero deleted";
        });

        // Delete a squad
        post("/squads/:id/delete", (req, res) -> {
            squadsDao.deleteSquad(sql, Integer.parseInt(req.params(":id")));
            return "Squad deleted";
        });

        // Delete a hero by id
        delete("/heroes/:id/delete", (req, res) -> {
            heroDao.deleteHero(sql, Integer.parseInt(req.params(":id")));
            res.redirect("/heroes");
            return "Hero deleted";
        });

        // Delete a squad by id
        delete("/squads/:id/delete", (req, res) -> {
            squadsDao.deleteSquad(sql, Integer.parseInt(req.params(":id")));
            res.redirect("/squads");
            return "Squad deleted";
        });

    }

    }