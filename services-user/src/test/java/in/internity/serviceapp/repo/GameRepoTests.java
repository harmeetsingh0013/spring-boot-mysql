package in.internity.serviceapp.repo;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import in.internity.serviceapp.entities.Game;
import in.internity.serviceapp.repo.GameRepo;

@DataJpaTest
@RunWith(SpringRunner.class)
public class GameRepoTests {

	@Autowired
	private GameRepo gameRepo;
	
	@Test
	public void findAllGames() {
		List<Game> games = gameRepo.findAll();
		assertNotNull(games);
		assertThat(games, hasSize(3));
	}
}
