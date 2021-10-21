package dad.login.ui;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {

	private LoginView view = new LoginView();
	private LoginModel model = new LoginModel();
	private Stage primaryStage;

	public LoginController(Stage primaryStage) {
		this.primaryStage = primaryStage;

		model.usuarioProperty().bind(view.getUsuarioText().textProperty());
		model.contraseñaProperty().bind(view.getContraseñaPass().textProperty());

		view.getAccederButton().setOnAction(e -> onAccederAction(e));
		view.getCancelarButton().setOnAction(e -> onCancelarAction(e));
	}

	public LoginView getView() {
		return view;
	}

	public LoginModel getModel() {
		return model;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	private void onCancelarAction(ActionEvent e) {
		primaryStage.close();
	}

	private void onAccederAction(ActionEvent e) {

		if (view.getLdapCheck().isSelected()) {

		} else {
			if (view.getLdapCheck().isSelected()) {

			} else {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setTitle("Iniciar sesión");
				errorAlert.setHeaderText("Acceso denegado");
				errorAlert.setContentText("El usuario y/o la contraseña no son válidos.");

				errorAlert.showAndWait();

				view.getUsuarioText().clear();

				view.getContraseñaPass().clear();
			}
		}
	}
}
