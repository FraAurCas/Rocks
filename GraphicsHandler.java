import javafx.animation.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.*;
import javafx.beans.value.*;


public class GraphicsHandler extends Application{
    public void start(Stage primaryStage){

        final int FPS = 60;
        final int X_LEN = 200; //How many spaces wide the world is
        final int Y_LEN = 125; //How many spaces tall the world is
        final int EDGE_LEN = 10; //How many pixels each material is graphically displayed as

        SimArea sim = new SimArea(X_LEN, Y_LEN);

        ObservableList<String> materials =
            FXCollections.observableArrayList( //New material names need to be added here. Also need to be added in the switch statement
                "Dirt",
                "Water",
                "Rock",
                "Custom (WIP)"
            );
        final ComboBox selection = new ComboBox(materials);
        selection.setValue("Dirt");

        final TextField amount = new TextField();
        amount.setText("25");
        amount.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
            String newValue) {
              if (!newValue.matches("\\d*")) {
                amount.setText(newValue.replaceAll("[^\\d]", ""));
              }
            }
        });

        VBox vbox = new VBox();              //The main VBox, contains the visual display at top and GUI at bottom
            Pane pane = new Pane();            //Where the actual simulation occurs.
                pane.setPickOnBounds(true);



                pane.setOnMousePressed(e -> {


                    if (e.isSecondaryButtonDown()) {
                      int x = (int)e.getX()/EDGE_LEN;
                      int y = (int)e.getY()/EDGE_LEN;

                      Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000/60), (ActionEvent event) -> {

                      Material m = null;

                      switch ((String)selection.getValue()) {
                          case "Dirt":
                              m = new Dirt(sim, x, y);
                              break;
                          case "Water":
                              m = new Water(sim, x, y);
                              break;
                          case "Rock":
                            m = new Rock(sim, x, y);
                            break;
                          case "Custom (WIP)":
                              return;
                      }
                      sim.add(m, x, y);

                      }));
                      timeline.setCycleCount(Integer.parseInt(amount.getText()));
                      timeline.play();

                    }
                    else if (e.isPrimaryButtonDown()){
                      int x = (int)e.getX()/EDGE_LEN;
                      int y = (int)e.getY()/EDGE_LEN;

                      Material m = null;

                      switch ((String)selection.getValue()) {
                          case "Dirt":
                              m = new Dirt(sim, x, y);
                              break;
                          case "Water":
                              m = new Water(sim, x, y);
                              break;
                          case "Rock":
                              m = new Rock(sim, x, y);
                              break;
                          case "Custom (WIP)":
                              return;
                      }
                      sim.add(m, x, y);
                    }
                    else if (e.isMiddleButtonDown()){
                      int x = (int)e.getX()/EDGE_LEN;
                      int y = (int)e.getY()/EDGE_LEN;
                      if(sim.getMaterial(x,y)==null)
                      {}
                      else if(!sim.getMaterial(x,y).getName().equals("Dirt")){
                        sim.delete(x, y);
                      }
                    }
                });
                pane.setPrefSize(X_LEN * EDGE_LEN, Y_LEN * EDGE_LEN);
                pane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderStroke.MEDIUM)));

            HBox hbox = new HBox();             //Will be used to add buttons and things later
                hbox.getChildren().addAll(new Text("Material: "), selection, new Text("Amount per right-click: "), amount);
                hbox.setPadding(new Insets(20, 60, 20, 60));
                hbox.setSpacing(10);
        vbox.getChildren().addAll(pane, hbox);
        vbox.setPadding(new Insets(20, 20, 20, 20));

        final Scene scene = new Scene(vbox); //Display setup
        primaryStage.setResizable(false);    //Don't resize cause thats a lot of work
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
                        r.setFill(m.getColor());
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
