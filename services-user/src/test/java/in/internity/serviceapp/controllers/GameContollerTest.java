package in.internity.serviceapp.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import in.internity.serviceapp.entities.Game;
import in.internity.serviceapp.service.GameService;

@RunWith(SpringRunner.class)
@WebMvcTest(GameContoller.class)
public class GameContollerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private GameService gameService;

	@Test
	public void testAddNewGame() throws Exception {
		Game game = new Game("GOT", null, null, "Done");
		given(gameService.addNewGame(game)).willReturn(Optional.of(game));

		mvc.perform(post("/api/game").accept(MediaType.APPLICATION_JSON_UTF8)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(TestUtil.objectToJson(game))
			)
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.data.name", is(equalTo("GOT"))))
			.andExpect(jsonPath("$.data.status", is(equalTo("Done"))))
			.andExpect(jsonPath("$.message", is(equalTo("successfully addd game"))))
			.andExpect(jsonPath("$.code", is(equalTo("1001"))));

		ArgumentCaptor<Game> captor = ArgumentCaptor.forClass(Game.class); // Create an ArgumentCaptor object which can
																			// capture TodoDTO objects.
		verify(gameService, times(1)).addNewGame(captor.capture()); // Verify that the addNewGame() method of the
																	// GameService interface is called only once and
																	// capture the object given as a parameter.
		verifyNoMoreInteractions(gameService); // Verify that the other methods of our mock object are not called during
												// our test.

		Game captureGame = captor.getValue();
		assertThat(captureGame.getId()).isNull();
		
	}
}
