package dad.login.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class LoginView extends VBox {

	private TextField usuarioText;
	private PasswordField contraseñaPass;
	private CheckBox ldapCheck;
	private Button accederButton, cancelarButton;

	public LoginView() {
		super();

		usuarioText = new TextField();
		usuarioText.setPromptText("Nombre de usuario");

		contraseñaPass = new PasswordField();
		contraseñaPass.setPromptText("Contraseña del usuario");

		ldapCheck = new CheckBox("Usar LDAP");

		accederButton = new Button("Acceder");
		accederButton.setDefaultButton(true);

		cancelarButton = new Button("Cancelar");

		GridPane loginPane = new GridPane();
		loginPane.setHgap(5);
		loginPane.setVgap(5);
		loginPane.setPadding(new Insets(5));
		loginPane.addRow(0, new Label("Usuario: "), usuarioText);
		loginPane.addRow(1, new Label("Contraseña: "), contraseñaPass);

		ColumnConstraints[] cols = { new ColumnConstraints(), new ColumnConstraints() };
		loginPane.getColumnConstraints().setAll(cols);

		RowConstraints[] rows = { new RowConstraints(), new RowConstraints() };
		loginPane.getRowConstraints().setAll(rows);

		cols[0].setHgrow(Priority.ALWAYS);

		cols[1].setHgrow(Priority.ALWAYS);

		rows[0].setVgrow(Priority.ALWAYS);

		rows[1].setVgrow(Priority.ALWAYS);

		HBox checkBotonesBox = new HBox(5, accederButton, cancelarButton);
		checkBotonesBox.setAlignment(Pos.CENTER);

		setSpacing(5);
		setFillWidth(false);
		setAlignment(Pos.CENTER);
		getChildren().addAll(loginPane, ldapCheck, checkBotonesBox);
	}

	public TextField getUsuarioText() {
		return usuarioText;
	}

	public PasswordField getContraseñaPass() {
		return contraseñaPass;
	}

	public CheckBox getLdapCheck() {
		return ldapCheck;
	}

	public Button getAccederButton() {
		return accederButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}

}
