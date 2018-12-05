/**************************************************************************

	Matthew Wright
	Ronald Enz
	Lab 6
	7/18/2018
	
***************************************************************************/

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.event.ActionEvent;
import javafx.event.*;
import javafx.geometry.*;
                                               // implement Event Listener
public class JavaFxGuiForm extends Application implements EventHandler<ActionEvent>{
	Button findBtn;
	Button insertBtn;
	Button deleteBtn;
	Button updateBtn;
	Button exitBtn;
	TextField idText = new TextField();
	TextField firstNameText = new TextField();
	TextField lastNameText = new TextField();
	TextField emailText = new TextField();
	TextField gpaText = new TextField();
	
	
	
	
	public static void main(String[] args){
		launch(args);
	}// end main
	
	@Override public void start(Stage primaryStage){
		primaryStage.setTitle("Student Info App.");
		
		//create the text variables for the toppane
		Text title = new Text("Student Information");
		
		// create buttons
		//find button
		findBtn = new Button();
		findBtn.setText("Find");
		findBtn.setTooltip(new Tooltip("Locate a student"));
		//insert button
		insertBtn = new Button();
		insertBtn.setText("Insert");
		insertBtn.setTooltip(new Tooltip("Insert student Info"));
		//delete button
		deleteBtn = new Button();
		deleteBtn.setText("Delete");
		deleteBtn.setTooltip(new Tooltip("Delete student Info"));
		//update button
		updateBtn = new Button();
		updateBtn.setText("Update");
		updateBtn.setTooltip(new Tooltip("Update student Info"));
		//exit button
		exitBtn = new Button();
		exitBtn.setText("Exit");
		exitBtn.setTooltip(new Tooltip("Exit Session"));
		
		//register the exit button
		exitBtn.setOnAction(e -> JFxG_ExitAlert.Alert());
		// register the find button
		findBtn.setOnAction(this);
		// register the insert button
		insertBtn.setOnAction(this);
		// register the update button
		updateBtn.setOnAction(this);
		// register the delete button
		deleteBtn.setOnAction(this);
		
		//create Center Grid elements
			// ID label
		Label id = new Label("ID: ");
		GridPane.setConstraints(id, 0, 0);
			// First Name label
		Label firstName = new Label("First Name: ");
		GridPane.setConstraints(firstName, 0, 1);
			// Last Name label
		Label lastName = new Label("Last Name: ");
		GridPane.setConstraints(lastName, 0, 2);
			// Email label
		Label email = new Label("Email: ");
		GridPane.setConstraints(email, 0, 3);
			// GPA label
		Label gpa = new Label("GPA: ");
		GridPane.setConstraints(gpa, 0, 4);	
		// Textfield Elements
			// ID Text Field
		idText.setPromptText("   34074   " );
		GridPane.setConstraints(idText, 1, 0);
			// First Name Text Field
		firstNameText.setPromptText("   John   ");
		GridPane.setConstraints(firstNameText, 1, 1);
			// Last Name Text Field
		lastNameText.setPromptText("   Doe   ");
		GridPane.setConstraints(lastNameText, 1, 2);
			// Email Text Field
		emailText.setPromptText("   JDoe@example.com   ");
		GridPane.setConstraints(emailText, 1, 3);
			// GPA Text Field
		gpaText.setPromptText("   3.96   ");
		GridPane.setConstraints(gpaText, 1, 4);
	
		//Add a title to to a flow plan. I will add it to the top of the border pane
		FlowPane topflowpane = new FlowPane();
		topflowpane.getChildren().add(title);
		topflowpane.setAlignment(Pos.CENTER);
		topflowpane.setPadding(new Insets(15, 0, 0, 0));
		topflowpane.setStyle("-fx-font-size: 20px");
		// create a grid pane with labels and text boxes to display in the center of the border pane 
		GridPane midgridpane = new GridPane();
		midgridpane.setPadding(new Insets(15, 0, 15, 0));
		midgridpane.setAlignment(Pos.CENTER);
		midgridpane.setVgap(13);
		midgridpane.setHgap(21);
		midgridpane.getChildren().addAll(id, idText, firstName, firstNameText, lastName, lastNameText, email, emailText, gpa, gpaText);
		//Add buttons to a layout pane. I will add them to flowpane to the bottom of the border pane 
		FlowPane bottomflowpane = new FlowPane();
		bottomflowpane.getChildren().addAll(findBtn, insertBtn, deleteBtn, updateBtn, exitBtn);
		bottomflowpane.setAlignment(Pos.CENTER);
		bottomflowpane.setPadding(new Insets(0, 0, 15, 0));
		bottomflowpane.setHgap(10);
		
		// After  the top flow, grid, and bottom flow panes are added to the border pane, the border pane will then be added to the scene
		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(topflowpane);
		borderPane.setCenter(midgridpane);
		borderPane.setBottom(bottomflowpane);
		
		
		//Create scene to display content
		Scene scene = new Scene(borderPane, 500, 300);
		scene.getStylesheets().add("TheCountry.css");
		primaryStage.setScene(scene);
		primaryStage.show();
	}// end start
	
	                                                             // BUTTON NAMES
																 
	// findBtn;
	// insertBtn;
	// deleteBtn;
	// updateBtn;
	// exitBtn;
	
																// TEXT FIELD NAMES
																
	// idText 
	// firstNameText
	// lastNameText
	// emailText
	// gpaText
	
	// create global object of the Student.java class
	Student s1 = new Student();

	// handle method for action events caused by the buttons button
		public void handle(ActionEvent ae){
			// action event Find
			if(ae.getSource() == findBtn){
				System.out.println("Find Button Pressed.");
					// id
				String id = idText.getText();
				s1.selectDB(Integer.parseInt(id));
					// first name
				firstNameText.setText(s1.getFirstName());
					// last name
				lastNameText.setText(s1.getLastName());
					// email
				emailText.setText(s1.getEmail());
					// gpa
				gpaText.setText(s1.getGPA()+"");
				s1.Display();
			}// end if
				// action event Insert
			if(ae.getSource() == insertBtn){
				System.out.println(" Insert Button Pressed. ");
					// id
			    String id = idText.getText();
					// first name
				String firstName = firstNameText.getText();
					// last name
				String lastName = lastNameText.getText();
					// street
				String street = "";
					// city
				String city = "";
					// state
				String state = "";
					// zip
				String zip = "";
					// email
				String email = emailText.getText();
					// gpa
				String gpa = gpaText.getText();
				s1.insertDB(Integer.parseInt(id), firstName, lastName,  street, city, state, 0 , email, Double.parseDouble(gpa));   
			}// end if
			// action event Update
			if(ae.getSource() == updateBtn){
				System.out.println(" Update Button Pressed. ");
				// id
				String id = idText.getText();
			    s1.selectDB(Integer.parseInt(id));
				// first name
				s1.setFirstName(firstNameText.getText());
				// last name
				s1.setLastName(lastNameText.getText());
				// email
				s1.setEmail(emailText.getText());
				// gpa 
				String gpa = gpaText.getText();
				s1.setGPA(Double.parseDouble(gpa));
				s1.updateDB();
				s1.Display();
			}// end if
			// action event Delete
			if(ae.getSource() == deleteBtn){
				System.out.println(" Delete Button Pressed. ");
				String id = idText.getText();
				s1.selectDB(Integer.parseInt(id));
				s1.deleteDB();
				s1.Display();
			}// end if
			
			// action event for Exit
			if(ae.getSource() == exitBtn){
				System.exit(0);
			}// end if
		}// end event handler
		
}// end class 

