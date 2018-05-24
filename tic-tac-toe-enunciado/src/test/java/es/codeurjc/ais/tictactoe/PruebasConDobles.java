package es.codeurjc.ais.tictactoe;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import es.codeurjc.ais.tictactoe.TicTacToeGame.EventType;
import es.codeurjc.ais.tictactoe.TicTacToeGame.WinnerResult;


public class PruebasConDobles {

	@Test
	public void primerJugadorGanasTest() {
		TicTacToeGame tictac = new TicTacToeGame();
		
		Connection connection1 = mock(Connection.class);
		Connection connection2 = mock(Connection.class);
		
		tictac.addConnection(connection1);
		tictac.addConnection(connection2);
		
		Player player1 = new Player(1,"X","Fran");
		Player player2 = new Player(2,"O","Jose");
		
		tictac.addPlayer(player1);		
		tictac.addPlayer(player2);
		verify(connection1,times(2)).sendEvent(EventType.JOIN_GAME,tictac.getPlayers());	
		verify(connection2,times(2)).sendEvent(EventType.JOIN_GAME,tictac.getPlayers());
		
		tictac.mark(0);
		verify(connection1).sendEvent(EventType.SET_TURN,player1);
		tictac.mark(4);
		verify(connection2).sendEvent(EventType.SET_TURN,player2);
		tictac.mark(1);
		verify(connection1,times(2)).sendEvent(EventType.SET_TURN,player1);
		tictac.mark(3);
		verify(connection2,times(2)).sendEvent(EventType.SET_TURN,player2);
		tictac.mark(2);
		
		int [] pos= {0,1,2};
	    WinnerResult win = new  WinnerResult();
	    win.pos=pos;
	    win.win=true;
	    
	    WinnerResult winner = tictac.checkWinner();
	    assertEquals(winner.win,win.win);
	    assertArrayEquals(win.pos,winner.pos);
	}

	@Test
	public void primerJugadorPierdeTest() {
		TicTacToeGame tictac = new TicTacToeGame();

		Connection connection1 = mock(Connection.class);
		Connection connection2 = mock(Connection.class);
		
		tictac.addConnection(connection1);
		tictac.addConnection(connection2);
		
		Player player1 = new Player(1,"X","Fran");
		Player player2 = new Player(2,"O","Jose");
		
		tictac.addPlayer(player1);		
		tictac.addPlayer(player2);
		verify(connection1,times(2)).sendEvent(EventType.JOIN_GAME,tictac.getPlayers());	
		verify(connection2,times(2)).sendEvent(EventType.JOIN_GAME,tictac.getPlayers());
		
		tictac.mark(0);
		verify(connection1).sendEvent(EventType.SET_TURN,player1);
		tictac.mark(4);
		verify(connection2).sendEvent(EventType.SET_TURN,player2);
		tictac.mark(1);
		verify(connection1,times(2)).sendEvent(EventType.SET_TURN,player1);
		tictac.mark(3);
		verify(connection2,times(2)).sendEvent(EventType.SET_TURN,player2);
		tictac.mark(6);
		verify(connection1,times(3)).sendEvent(EventType.SET_TURN,player1);
		tictac.mark(5);
	    
	    WinnerResult winner = tictac.checkWinner();
	    assertTrue(winner.win);
	    boolean jugador = tictac.checkTurn(2);
	    assertTrue(jugador);
	}
	
	@Test
	public void EmpateTest() {
		TicTacToeGame tictac = new TicTacToeGame();

		Connection connection1 = mock(Connection.class);
		Connection connection2 = mock(Connection.class);
		
		tictac.addConnection(connection1);
		tictac.addConnection(connection2);
		
		Player player1 = new Player(1,"X","Fran");
		Player player2 = new Player(2,"O","Jose");
		
		tictac.addPlayer(player1);		
		tictac.addPlayer(player2);
		verify(connection1,times(2)).sendEvent(EventType.JOIN_GAME,tictac.getPlayers());	
		verify(connection2,times(2)).sendEvent(EventType.JOIN_GAME,tictac.getPlayers());
		
		tictac.mark(0);
		verify(connection1).sendEvent(EventType.SET_TURN,player1);
		tictac.mark(4);
		verify(connection2).sendEvent(EventType.SET_TURN,player2);
		tictac.mark(1);
		verify(connection1,times(2)).sendEvent(EventType.SET_TURN,player1);
		tictac.mark(3);
		verify(connection2,times(2)).sendEvent(EventType.SET_TURN,player2);
		tictac.mark(5);
		verify(connection1,times(3)).sendEvent(EventType.SET_TURN,player1);
		tictac.mark(2);
		verify(connection2,times(3)).sendEvent(EventType.SET_TURN,player2);
	    tictac.mark(6);
	    verify(connection1,times(4)).sendEvent(EventType.SET_TURN,player1);
	    tictac.mark(7);
	    verify(connection2,times(4)).sendEvent(EventType.SET_TURN,player2);
	    tictac.mark(8);
	    
	    WinnerResult winner = tictac.checkWinner();
	    assertNull(winner.pos);
	}
}
