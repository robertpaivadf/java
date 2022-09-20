package gui;

import java.util.Locale;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewController {

	@FXML
	private TextField txtNumber1;
	
	@FXML
	private TextField txtNumber2;
	
	@FXML
	private TextField txtNumber3;
	
	@FXML
	private Label labelResult;
	
	
	
	@FXML
	private Button btSum;
	
	@FXML
	public void onBtSumAction() {
		try {
			Locale.setDefault(Locale.US);
			Double n1 = Double.parseDouble(txtNumber1.getText());
			Double n2 = Double.parseDouble(txtNumber2.getText());
			Double n3 = Double.parseDouble(txtNumber3.getText());
			
			Double sum  =  n2 * n3 / n1;			
			
			labelResult.setText(sum.toString());
		}
		catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse Error", e.getMessage(), AlertType.ERROR);
		}
	}

}
