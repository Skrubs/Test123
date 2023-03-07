package application;
	
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		ArrayList<Label> labelList = new ArrayList<>();
		
		Button b = new Button("Button");
		b.setLayoutX(50);
		b.setLayoutY(50);
		
		Button c = new Button("Button2");
		c.setLayoutX(150);
		c.setLayoutY(50);
		
		Pane p = new Pane();
		p.setPrefSize(400, 400);
		p.getChildren().addAll(b,c);
		b.setOnAction(e->{
			Label l = new Label("You pressed the button, why?");
			l.setLayoutX(new Random().nextDouble(300));
			l.setLayoutY(new Random().nextDouble(400));
			labelList.add(l);
			p.getChildren().add(l);
		});
		
		c.setOnAction(e->{
			
				for(Node l : p.getChildren()) {
						p.getChildren().remove(l);
						
					}
				
			
		});
		
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			root.getChildren().add(p);
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
