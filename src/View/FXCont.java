package View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import static javafx.geometry.Pos.CENTER;

public class FXCont {
    GridPane grid;

    void addPeriodNums(){
        Label per1;
        for (int i = 1; i < 13 ; i++) {
            per1 = new Label(Integer.toString(i));
            per1.setAlignment(CENTER);
            grid.add(per1,i,0);
        }
    }

}
