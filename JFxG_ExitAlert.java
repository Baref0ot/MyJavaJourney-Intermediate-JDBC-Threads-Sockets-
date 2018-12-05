import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.event.ActionEvent;
import javafx.event.*;
import javafx.geometry.*;

public class JFxG_ExitAlert{
	
	public static void Alert(){
		
		//create a stage
		Stage stage = new Stage();

		// prevents user interaction with other window until this one is delt with
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Comfirmation!!!");
		stage.setMinWidth(100);
		
		// create Label
		Label confirm = new Label();
		confirm.setText(" ***Are you sure you want to EXIT?*** ");
		
		
		// create Buttons
			// yes
		Button yes = new Button();
		yes.setText(" YES ");
		GridPane.setConstraints(yes, 0, 2);
		yes.setOnAction(e -> System.exit(0));
			// no
		Button no = new Button();
		no.setText(" NO ");
		GridPane.setConstraints(no, 1, 2);
		no.setOnAction(e -> stage.close());
		
		// create the Flow Pane
		FlowPane flowpane = new FlowPane();
		flowpane.setAlignment(Pos.CENTER);
		flowpane.getChildren().add(confirm);
		flowpane.setPadding(new Insets(0, 0, 0, 0));
		
		
		// create the Grid Pane
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(0, 0, 70, 0));
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setVgap(0);
		gridpane.setHgap(70);
		gridpane.getChildren().addAll(yes, no);
		
		//create Border Pane
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(flowpane);
		borderPane.setBottom(gridpane);
		
		//Create scene to display content
		Scene scene = new Scene(borderPane, 300, 200);
		scene.getStylesheets().add("TheCountry.css");
		stage.setScene(scene);
		stage.showAndWait();
			
	}// end Alert
		
}// end class