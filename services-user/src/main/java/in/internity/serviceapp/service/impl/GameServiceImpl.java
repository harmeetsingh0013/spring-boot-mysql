package in.internity.serviceapp.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.internity.serviceapp.entities.Game;
import in.internity.serviceapp.repo.GameRepo;
import in.internity.serviceapp.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepo gameRepo;
	
	@Override
	public Optional<Game> addNewGame(Game game) {
		return Optional.ofNullable(gameRepo.save(game));
	}

}
