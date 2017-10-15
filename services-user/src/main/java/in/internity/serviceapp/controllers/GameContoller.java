package in.internity.serviceapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import in.internity.serviceapp.entities.Game;
import in.internity.serviceapp.service.GameService;
import in.internity.serviceapp.utility.ResponseData;

@Controller
@RequestMapping(value="/api")
public class GameContoller {

	@Autowired
	private GameService gameService;
	
	@ResponseBody
	@PostMapping(value="/game")
	public ResponseData<Game> addNewGame(@RequestBody Game game) {
		return gameService.addNewGame(game)
				.map(gm -> new ResponseData<>(gm, "successfully addd game", "1001"))
				.orElse(new ResponseData<Game>(game, "proble", "1005"));
	}
}
