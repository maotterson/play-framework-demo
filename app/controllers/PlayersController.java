package controllers;

import play.mvc.*;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;

import java.util.ArrayList;
import java.util.List;

import models.Player.*;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static play.libs.Json.toJson;

public class PlayersController extends Controller {

    private final FormFactory formFactory;
    private final PlayerRepository playerRepository;
    private final HttpExecutionContext ec;

    @Inject
    public PlayerController(FormFactory formFactory, PlayerRepository playerRepository, HttpExecutionContext ec) {
        this.formFactory = formFactory;
        this.playerRepository = playerRepository;
        this.ec = ec;
    }
    public Result index(final Http.Request request) {
        return ok(views.html.players.render(request));
    }

    public CompletionStage<Result> addPerson(final Http.Request request) {
        Player player = formFactory.form(Player.class).bindFromRequest(request).get();
        return playerRepository
                .add(player)
                .thenApplyAsync(p -> redirect(routes.PlayerController.index()), ec.current());
    }

    public CompletionStage<Result> getPersons() {
        return playerRepository
                .list()
                .thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
    }

    public Result showPlayer(String id) {
        return ok(views.html.player.render(id));
    }
}
