package dad.login;

import dad.login.ui.LoginController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private LoginController loginController;

	@Override
	public void start(Stage primaryStage) throws Exception {
		loginController = new LoginController(primaryStage);

		Scene scene = new Scene(loginController.getView(), 320, 200);

		primaryStage.setTitle("Iniciar sesión");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
