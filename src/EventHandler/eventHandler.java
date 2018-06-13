//package EventHandler;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
//
//import Views.View;
//
//
//public class eventHandler {
//
//	private static eventHandler handler;
//	private static View view;
//
//	public eventHandler(View view) {
//		this.view = view;
//	}
//
//	
//	public static void EndProgram() {
//		view.exit();
//	}
//
//	/*private void EscapeFromGame() {
//		System.out.println("pause");
//		view.setScene("pause");
//		snapshot = controller.pause();
//	}
//
//	public void continueGame() {
//		Game gameScene = new Game(view.getHeight(), view.getWidth());
//		view.setScene(gameScene.getScene());
//		controller = new gameController(gameScene, snapshot);
//		Thread game = new Thread(controller, "game begin");
//		game.start();
//	}
//
//	public void MainMenu() {
//		view.setScene("MainMenu");
//	}
//
//	
//
//	public void ExitConfirmation() {
//		System.out.println("exit confirmation");
//		ExitConfrmationWindow.display();
//	}
//
//	public void Instructions() {
//		view.setScene("Instructions");
//	}
//
//	public void mainOptions() {
//		view.setScene("MainOptions");
//	}
//
//	public void EndGame(String winnerName) {
//		Logs.log("winner:" + winnerName, "debug");
//		EndGame scene = new EndGame(view.getHeight(), view.getWidth());
//		scene.setWinner(winnerName);
//		view.setScene(scene.getScene());
//	}
//
//	public void gameOptions() {
//		view.setScene("GameOptions");
//	}
//	
//	public void setLevel(String level) {
//		gameOptions.setGameStrategy(level);
//	}
//	
//	public void setKeyContol(String control) {
//		if (control.equals("KeyMouse")) {
//			gameOptions.setPlayer2Mouse();
//		} else if (control.equals("MouseKey")) {
//			gameOptions.setPlayer1Mouse();
//		} 
//	}
//	
//	public void setStrategy(String strategy, int maxTime, int maxScore) {
//		gameOptions.setGameStrategy(strategy);
//		gameOptions.setMaxTime(maxTime);
//		gameOptions.setMaxScore(maxScore);
//	}
//
//	public void GameOptionsReturn() {
//		view.setScene("pause");
//	}
//
//	
//	public void saveGame() {
//		save1.save(this.snapshot);
//	}
//	
//
//*/
//}
