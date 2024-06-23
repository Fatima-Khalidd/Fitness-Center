package membership.sourcecode;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane layout=new GridPane();
        layout.setHgap(20);
        layout.setVgap(10);
        Text text=new Text("Welcome to Fitness Center");
        text.setFont(Font.font("Times New Roman",30));
       text.setTextAlignment(TextAlignment.CENTER);
        layout.getChildren().add(text);
        Button addButton=new Button("Membership");
        GridPane.setConstraints(addButton,1,1);
        GridPane.setHalignment(addButton, HPos.CENTER);
        // view members button
        Button viewButton=new Button("View Members");
        GridPane.setConstraints(viewButton,1,2);
        GridPane.setHalignment(viewButton,HPos.CENTER);
        layout.getChildren().add(viewButton);
        layout.getChildren().add(addButton);
        layout.setAlignment(Pos.CENTER);


        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                GridPane layout2=new GridPane();
                layout2.setHgap(10);
                layout2.setVgap(10);
                Label name = new Label("Name");
                TextField text1=new TextField();
                layout2.setStyle("-fx-background-color: LIGHTBLUE");
                layout2.add(name,0,0);
                layout2.add(text1,1,0);
                Label email=new Label("Email");
                TextField text2=new TextField();
                layout2.add(email,0,1);
                layout2.add(text2,1,1);
                Label age=new Label("Age");
                TextField text3=new TextField();
                layout2.add(age,0,2);
                layout2.add(text3,1,2);
                Label category=new Label("Type");
                layout2.add(category,0,3);

                ComboBox<String> comboBox=new ComboBox<>();
                comboBox.getItems().addAll("Regular","Premium","VIP");
                GridPane.setConstraints(comboBox,1,3);
                layout2.getChildren().add(comboBox);

                ToggleGroup group=new ToggleGroup();
                RadioButton maleRadioButton=new RadioButton("Male");
                maleRadioButton.setToggleGroup(group);
                RadioButton femaleRadioButton=new RadioButton("Female");
                femaleRadioButton.setToggleGroup(group);
                GridPane.setConstraints(maleRadioButton,0,5);
                GridPane.setConstraints(femaleRadioButton,1,5);
                layout2.getChildren().add(maleRadioButton);
                layout2.getChildren().add(femaleRadioButton);
                layout2.setAlignment(Pos.CENTER);

                Label DOB=new Label("Date of Birth");
                layout2.add(DOB,0,4);
                DatePicker datePicker=new DatePicker();
                layout2.add(datePicker,1,4);
                Label dob=new Label("YYYY-MM-DD");
                layout2.add(dob,1,4);

                Button saveButton=new Button("Save");
                layout2.add(saveButton,0,9);
                saveButton.setAlignment(Pos.CENTER_RIGHT);
                layout2.setScaleX(1.4);
                layout2.setScaleY(1.4);
                saveButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        String name=text1.getText();
                        String email=text2.getText();
                        String age= text3.getText();
                        String gender="";
                        if(maleRadioButton.isSelected())
                            gender="male";
                        else if (femaleRadioButton.isSelected()) {
                            gender="female";
                        }

                        String [] data=new String [] {name,email,age,gender};

                        File file=new File("data.txt");
                        try {
                            FileWriter  fr=new FileWriter(file,true);
                            fr.write(name+","+email+","+age+","+gender+"\n");
                            fr.flush();
                            Alert alert=new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setHeaderText("Information saved!");
                            alert.setContentText("your information has successfully been saved!");
                            alert.show();
                        } catch (IOException e) {
                            Alert alert =new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Error");
                            alert.setHeaderText("Could not save information");
                            alert.setContentText("An error occured while saving your information");
                            alert.show();
                            //Scene saveScene=new Scene(layout2,400,500);
                            System.out.println("Data saved successfully");

                            throw new RuntimeException(e);
                        }
                    }
                });

                         Scene scene1 = new Scene(layout2,400,500);
                layout2.setStyle("-fx-background-color: LIGHTBLUE");
                stage.setScene(scene1);
                stage.show();

            }
        });
        viewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("View Button Clicked");
                //GridPane viewLayout=new GridPane();
                try {
                ;

                     new ViewData().Data(stage);
                   ;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        });
        Scene scene = new Scene(layout,400,500);
        stage.setTitle("Fitness Center");
        layout.setStyle("-fx-background-color: LIGHTBLUE");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}