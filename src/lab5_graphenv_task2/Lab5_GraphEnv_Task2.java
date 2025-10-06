package lab5_graphenv_task2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Git Repository: https://github.com/jameshuyha/Lab5_GraphEnv_Task2.git
 *
 * @author 6324151
 */
public class Lab5_GraphEnv_Task2 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        double MIN = 0.0, MAX = 20.0, INITIAL = 0.0;
        final double MAJOR_TICK_UNIT = 5.0;
        final int MINOR_TICK_COUNT = 4;
        final double SLIDER_WIDTH = 300.0;

        // Create BorderPane and GridPane
        BorderPane root = new BorderPane();
        GridPane gridPane = new GridPane();
        root.setCenter(gridPane);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create labels
        Label beverageLabel = new Label("Select Beverage: ");
        Label appetizerLabel = new Label("Select Appetizer: ");
        Label mainLabel = new Label("Select Main Course: ");
        Label dessertLabel = new Label("Select Dessert:");
        Label tipLabel = new Label("Select Tip (%): ");
        Label subtotalLabel = new Label("Subtotal: 0.00$");
        Label taxLabel = new Label("Tax: 0.00$");
        Label tipAmountLabel = new Label("Tip: 0.00$");
        Label totalLabel = new Label("Total: 0.00$");

        // Add labels to GridPane
        gridPane.add(beverageLabel, 0, 0);
        gridPane.add(appetizerLabel, 1, 0);
        gridPane.add(mainLabel, 2, 0);
        gridPane.add(dessertLabel, 3, 0);
        gridPane.add(tipLabel, 0, 4);
        gridPane.add(subtotalLabel, 0, 7);
        gridPane.add(taxLabel, 0, 8);
        gridPane.add(tipAmountLabel, 0, 9);
        gridPane.add(totalLabel, 0, 10);

        // Create ComboBoxes
        ComboBox<String> cbBeverage = new ComboBox<>();
        ComboBox<String> cbAppetizer = new ComboBox<>();
        ComboBox<String> cbMain = new ComboBox<>();
        ComboBox<String> cbDessert = new ComboBox<>();

        // Add items to ComboBoxes
        cbBeverage.getItems().addAll("Coffee (2.50$)", "Tea (2.00$)", "Soft Drink (1.75$)", "Water (2.95$)", "Milk (1.50$)", "Juice (2.50$)");
        cbAppetizer.getItems().addAll("Soup (4.50$)", "Salad (3.75$)", "Spring Rolls (5.25$)", "Garlic Bread (3.00$)", "Chips and Salsa (6.95$)");
        cbMain.getItems().addAll("Steak (15.00$)", "Grilled Chicken (13.50$)", "Chicken Alfredo (13.95$)", "Turkey Club (11.90)", "Shrimp Scampi (18.99$)", "Pasta (11.75$)", "Fish and Chips (12.25$)");
        cbDessert.getItems().addAll("Apple Pie (5.95$)", "Carrot Cake (4.50$)", "Mud Pie (4.75$)", "Pudding (3.25$)", "Apple Crisp (5.98$)");

        // Place ComboBoxes in GridPane
        gridPane.add(cbBeverage, 0, 1);
        gridPane.add(cbAppetizer, 1, 1);
        gridPane.add(cbMain, 2, 1);
        gridPane.add(cbDessert, 3, 1);

        // Create slider
        Slider slider = new Slider(MIN, MAX, INITIAL);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(MAJOR_TICK_UNIT);
        slider.setMinorTickCount(MINOR_TICK_COUNT);
        slider.setShowTickLabels(true);
        slider.setSnapToTicks(true);
        slider.setPrefWidth(SLIDER_WIDTH);
        gridPane.add(slider, 0, 5, 4, 1);

        // Create clear button
        Button clearButton = new Button("Clear Bill");
        gridPane.add(clearButton, 0, 12);
        
        // Clear selections for clear button
        clearButton.setOnMouseClicked(e -> {
            cbBeverage.getSelectionModel().clearSelection();
            cbAppetizer.getSelectionModel().clearSelection();
            cbMain.getSelectionModel().clearSelection();
            cbDessert.getSelectionModel().clearSelection();
            slider.setValue(INITIAL);
            subtotalLabel.setText("Subtotal: 0.00$");
            taxLabel.setText("Tax: 0.00$");
            tipAmountLabel.setText("Tip: 0.00$");
            totalLabel.setText("Total: 0.00$");
        });
        
        // Add and show scene
        Scene scene = new Scene(root, 800, 375);
        primaryStage.setTitle("Restaurant Menu Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
