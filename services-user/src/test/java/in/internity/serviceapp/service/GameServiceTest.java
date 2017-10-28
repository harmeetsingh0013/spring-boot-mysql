package in.internity.serviceapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import in.internity.serviceapp.entities.Game;
import in.internity.serviceapp.repo.GameRepo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GameServiceTest {

	@MockBean
	private GameRepo gameRepo;
	
	@Autowired
	private GameService service;
	
	@Test
	public void testAddNewGame() {
		Game game = new Game("GOT", LocalDateTime.now(), LocalDateTime.now(), "Done");
		given(gameRepo.save(game)).willReturn(game);
		
		Optional<Game> gameSaved = service.addNewGame(game);
		assertThat(gameSaved).isNotEmpty();
		assertThat(gameSaved).contains(game);
	}
}
