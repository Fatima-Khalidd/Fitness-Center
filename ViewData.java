package membership.sourcecode;

import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ViewData {

    public static void Data(Stage stage) {
        // Create the GridPane layout
        GridPane tableLayout = new GridPane();

        // Create the TableView
        TableView<MemberData> table = new TableView<>();

        // Create and set up table columns
        TableColumn<MemberData, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<MemberData, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<MemberData, String> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<MemberData, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

        TableColumn<MemberData, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));




        table.getColumns().addAll(nameColumn, emailColumn, ageColumn, genderColumn, typeColumn);

        // Read data from file and add to the table
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Read line: " + line); // Debug statement
                String[] values = line.split(",");
                if (values.length == 5) {
                    table.getItems().add(new MemberData(values[0], values[1], values[2], values[3], values[4]));
                } else {
                    System.err.println("Skipping invalid line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO Exception: " + e.getMessage());
        }

        // Set constraints and add table to the layout
        GridPane.setConstraints(table, 0, 0);
        GridPane.setHalignment(table, HPos.CENTER);
        tableLayout.getChildren().add(table);

        // Create a scene with the layout
        Scene tableScene=new Scene(tableLayout, 600, 500);

        // Set the scene to the stage
        stage.setScene(tableScene);
        stage.show();
    }
}
