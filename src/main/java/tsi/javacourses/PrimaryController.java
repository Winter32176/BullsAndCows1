package tsi.javacourses;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;

public class PrimaryController {

    private int count;
    public Spinner<Integer> num1;
    public Spinner<Integer> num2;
    public Spinner<Integer> num3;
    public Spinner<Integer> num4;

    public void doTurn() {

        count++;
        int n1 = num1.getValue();
        int n2 = num2.getValue();
        int n3 = num3.getValue();
        int n4 = num4.getValue();

        var turn = new Turn();
        turn.setNr(count);
        turn.setGuess("" + n1 + n2 + n3 + n4);


        System.out.printf("%d %d %d %d %n", n1, n2, n3, n4);

    }
}
