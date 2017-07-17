package com.qainfotech.tap.training.snl.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BoardTest {

	@Test
	public void registerPlayerTest() throws FileNotFoundException, UnsupportedEncodingException, IOException,
			PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption {
		Board board = new Board();
		JSONObject boardobject = new JSONObject(
				new String(Files.readAllBytes(Paths.get(board.getUUID().toString() + ".board"))));
		JSONArray jsonarray = boardobject.getJSONArray("players");
		jsonarray = board.registerPlayer("vidushi");
		jsonarray = board.registerPlayer("vids");
		jsonarray = board.registerPlayer("vidu");
		jsonarray = board.registerPlayer("vidz");
		assertThat(boardobject.length()).isNotEqualTo(0);
		assertThat(jsonarray.length()).isNotEqualTo(0);
		assertThat(jsonarray.length()).isEqualTo(4);
		assertThat(jsonarray.get(0).toString().equalsIgnoreCase("vidushi"));

	}

	@Test(expectedExceptions = MaxPlayersReachedExeption.class)
	public void registerPlayerTestForMaxPlayerException() throws FileNotFoundException, UnsupportedEncodingException,
			IOException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption {
		Board board = new Board();
		JSONObject boardobject = new JSONObject(
				new String(Files.readAllBytes(Paths.get(board.getUUID().toString() + ".board"))));
		JSONArray jsonarray = boardobject.getJSONArray("players");
		jsonarray = board.registerPlayer("vidushi");
		jsonarray = board.registerPlayer("vids");
		jsonarray = board.registerPlayer("vidu");
		jsonarray = board.registerPlayer("vidz");
		jsonarray = board.registerPlayer("aadi");
	}

	@Test(expectedExceptions = PlayerExistsException.class)
	public void registerPlayerTestForPlayerExistException() throws FileNotFoundException, UnsupportedEncodingException,
			PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException {
		Board board = new Board();
		JSONObject boardobject = new JSONObject(
				new String(Files.readAllBytes(Paths.get(board.getUUID().toString() + ".board"))));
		JSONArray jsonarray = boardobject.getJSONArray("players");
		jsonarray = board.registerPlayer("vidushi");
		jsonarray = board.registerPlayer("vids");
		jsonarray = board.registerPlayer("vidu");
		jsonarray = board.registerPlayer("vids");

	}

	@Test(expectedExceptions = GameInProgressException.class)
	public void registerPlayerTestForGameInProgressException()
			throws FileNotFoundException, UnsupportedEncodingException, IOException, PlayerExistsException,
			GameInProgressException, MaxPlayersReachedExeption {
		Board board = new Board();
		JSONArray jsonArray=board.registerPlayer("vidushi");
		JSONArray jsonArray=board.registerPlayer("vids");
		JSONArray jsonArray=board.registerPlayer("vidu");
		board.rollDice(jsonArray.)
	
		
       
	}

}
