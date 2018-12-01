package View;

import Controller.Controller;
import Model.Period;
import Model.Schedule;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.*;

import static javafx.geometry.Pos.CENTER;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;

public class GUI extends Application {

    GridPane grid;
    Controller controller = new Controller();

//    public static void main(String[] args){
//        launch(args);
//    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label per1;
        grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setGridLinesVisible(true);
        for (int i = 1; i < 13 ; i++) {
            per1 = new Label(Integer.toString(i));
            per1.setAlignment(CENTER);
            per1.setPrefSize(100,20);
            grid.add(per1,i,0);
        }
        per1 = new Label("Sat");
        per1.setPrefSize(60,110);
        per1.setAlignment(CENTER);
        grid.add(per1,0,1);
        per1 = new Label("Sun");
        per1.setPrefSize(60,110);
        per1.setAlignment(CENTER);
        grid.add(per1,0,2);
        per1 = new Label("Mon");
        per1.setPrefSize(60,110);
        per1.setAlignment(CENTER);
        grid.add(per1,0,3);
        per1 = new Label("Tue");
        per1.setPrefSize(60,110);
        per1.setAlignment(CENTER);
        grid.add(per1,0,4);
        per1 = new Label("Wed");
        per1.setPrefSize(60,110);
        per1.setAlignment(CENTER);
        grid.add(per1,0,5);
        per1 = new Label("Thu");
        per1.setPrefSize(60,110);
        per1.setAlignment(CENTER);
        grid.add(per1,0,6);
        displaySchedule();
        primaryStage.setScene(new Scene(grid,1300,700));
        primaryStage.show();
    }

    void displaySchedule() throws Exception {
        controller.makeSchedule();
        Schedule schedule = controller.getSchedule();
        Period[][] periods = schedule.getSchedule();
        Label period;
        Rectangle background;
        String CName;
        schedule.printSchedule();
        int length;
        for (int i = 0; i < 6 ; i++) {
            for (int j = 0; j < 12  ; j++) {
                if((periods[i][j]!=null)) {
                    CName = periods[i][j].getCourseName();
                    length = periods[i][j].getLength();
                    period = new Label(CName);
                    period.setAlignment(Pos.CENTER);
                    background = new  Rectangle((100*length)-5,105, WHITE);
                    background.setX(5);
                    grid.add(background,j + 1,i + 1,length,1);
                    grid.add(period, j + 1, i + 1,length,1);
                    j+=length-1;
                    }
                }
            }
        }
    }




