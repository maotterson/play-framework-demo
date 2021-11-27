package controllers;

import play.mvc.*;

public class PlayersController extends Controller {
    public Result index() {
        return ok(views.html.players.render());
    }
}
