package models.Player;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPAPlayerRepository.class)
public interface PlayerRepository {

    CompletionStage<Player> add(Player player);

    CompletionStage<Stream<Player>> list();
}