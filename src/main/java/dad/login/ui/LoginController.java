package dad.login.ui;

import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
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
		model.passwordProperty().bind(view.getPasswordPass().textProperty());
		model.ldapProperty().bindBidirectional(view.getLdapCheck().selectedProperty());

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

		AuthService auth = model.isLdap() ? new LdapAuthService() : new FileAuthService();

		try {
			if (auth.login(model.getUsuario(), model.getPassword()) == true) {
				Alert correctoAlert = new Alert(AlertType.INFORMATION);
				correctoAlert.setTitle("Iniciar sesión");
				correctoAlert.setHeaderText("Acceso permitido");
				correctoAlert.setContentText("Las credenciales de acceso son válidas.");
				correctoAlert.showAndWait();
			} else {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setTitle("Iniciar sesión");
				errorAlert.setHeaderText("Acceso denegado");
				errorAlert.setContentText("El usuario y/o la contraseña no son válidos.");
				errorAlert.showAndWait();
				view.getUsuarioText().clear();
				view.getPasswordPass().clear();
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
