package in.internity.serviceapp.service;

import java.util.Optional;

import in.internity.serviceapp.entities.Game;

public interface GameService {
	
	public Optional<Game> addNewGame(Game game);
}
