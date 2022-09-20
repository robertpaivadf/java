package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewController implements Initializable{

	@FXML
	private TextField txtNumber1;
			
	@FXML
	private TextField txtNumber2;
	
	@FXML
	private Label labelResult;
		
	@FXML
	private Button btSum;
		
	
	@FXML
	public void onBtSumAction() {
		try {
			Locale.setDefault(Locale.US);
			Double sum  = Double.parseDouble(txtNumber1.getText()) + Double.parseDouble(txtNumber2.getText());		
			labelResult.setText(sum.toString());
		}
		catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse Error", e.getMessage(), AlertType.ERROR);
		}
			
		
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtNumber1);
		Constraints.setTextFieldDouble(txtNumber2);
		Constraints.setTextFieldMaxLength(txtNumber1, 12);
		Constraints.setTextFieldMaxLength(txtNumber2, 12);
	}

}
