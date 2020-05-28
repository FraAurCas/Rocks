import javafx.animation.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.util.Duration;

public class SimArea extends Application{
    public void start(Stage primaryStage){

        final int FPS = 144;

        VBox vbox = new VBox();              //The main VBox, contains the visual display at top and GUI at bottom
            GridPane sim = new GridPane();      //Where the actual simulation occurs. 
            sim.setGridLinesVisible(true);
            sim.getChildren().addAll();         //Any actors in the simulation need to be added here

            HBox hbox = new HBox();             //Will be used to add buttons and things later
        vbox.getChildren().addAll(sim, hbox);

        final Scene scene = new Scene(vbox, 1280, 720); //Display setup. Numbers are display resolution
        primaryStage.setTitle("Rocks");                 //Title
        primaryStage.setScene(scene);
        primaryStage.show();

        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(1000 / FPS), t -> { //This is where all looped code goes
            
        }));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
    }

    public static void main(final String[] args) { 
        launch(args);
    };
}
