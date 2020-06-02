import javafx.animation.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;
import javafx.util.Duration;

public class GraphicsHandler extends Application{
    public void start(Stage primaryStage){

        final int FPS = 144;
        final int X_LEN = 20; //How many spaces wide the world is
        final int Y_LEN = 20; //How many spaces tall the world is
        final int EDGE_LEN = 20; //How many pixels each material is graphically displayed as

        SimArea sim = new SimArea(X_LEN, Y_LEN);

        VBox vbox = new VBox();              //The main VBox, contains the visual display at top and GUI at bottom
            Pane pane = new Pane();            //Where the actual simulation occurs. 

            HBox hbox = new HBox();             //Will be used to add buttons and things later
        vbox.getChildren().addAll(pane, hbox);

        final Scene scene = new Scene(vbox, 1280, 720); //Display setup. Numbers are display resolution
        primaryStage.setTitle("Rocks");                 //Title
        primaryStage.setScene(scene);
        primaryStage.show();

        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(1000 / FPS), t -> { //Draws SimArea to the screen
            sim.simulate();
            pane.getChildren().clear();

            for (int x = 0; x < sim.getXLen(); x++) {
                for (int y = 0; y < sim.getYLen(); y++) {
                    Material m = sim.getMaterial(x, y);
                    if (m != null) {
                        Rectangle r = new Rectangle(x * EDGE_LEN, y * EDGE_LEN, EDGE_LEN, EDGE_LEN);
                        // r.setFill(); TODO: Somehow get m's color to be that of the rectangle
                        pane.getChildren().add(r);
                    }
                }
            }
        }));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
    }

    public static void main(final String[] args) { 
        launch(args);
    };
}
