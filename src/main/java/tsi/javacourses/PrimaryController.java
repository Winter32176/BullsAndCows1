package tsi.javacourses;

import java.io.IOException;
import java.util.*;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;

public class PrimaryController {

    private int count;
    private List<Integer> myNumbers;
    public Spinner<Integer> num1;
    public Spinner<Integer> num2;
    public Spinner<Integer> num3;
    public Spinner<Integer> num4;
    public TableView<Turn> turnsTable;
    public Button goButton;

    public void initialize() {
        generateRandom();

        goButton.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> {
                            Set<Integer> tmp = new HashSet<>();
                            tmp.add(num1.getValue());
                            tmp.add(num2.getValue());
                            tmp.add(num3.getValue());
                            tmp.add(num4.getValue());

                            return tmp.size() < 4;
                        }
                        , num1.valueProperty()
                        , num2.valueProperty()
                        , num3.valueProperty()
                        , num4.valueProperty()
                )
        );
    }

    private void generateRandom() {
        Set<Integer> tmp = new LinkedHashSet<>();
        Random rand = new Random();
        while (tmp.size() < 4) {
            int i = rand.nextInt(10);
            tmp.add(i);
        }
        myNumbers = List.copyOf(tmp);

        System.out.println(myNumbers);
    }

    public void doTurn() {
        count++;
        int n1 = num1.getValue();
        int n2 = num2.getValue();
        int n3 = num3.getValue();
        int n4 = num4.getValue();

        List<Integer> userNumber = List.of(n1, n2, n3, n4);

//        int cows = calculateCows(userNumber);
//       int bulls = calculateBulls(userNumber);

        var turn = new Turn();
        calculateCowsAndBulls(userNumber, turn);
        turn.setNr(count);
        turn.setGuess("" + n1 + n2 + n3 + n4);

//        turn.setBulls(bulls);
//        turn.setCows(cows);

        turnsTable.getItems().add(0, turn);

        System.out.printf("%d %d %d %d %n", n1, n2, n3, n4);

    }

    private void calculateCowsAndBulls(List<Integer> userNumber, Turn turn) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int mn = myNumbers.get(i);
                int un = userNumber.get(j);
                if (un == mn) {
                    if (i == j) {
                        bulls++;
                    } else {
                        cows++;
                    }
                }
            }
        }
        turn.setBulls(bulls);
        turn.setCows(cows);
    }

//    private int calculateBulls(List<Integer> userNumber) {
//        int bulls = 0;
//        for (int i = 0; i < 4; i++) {
//            int un = userNumber.get(i);
//            int mn = myNumbers.get(i);
//            if (un == mn) {
//                bulls++;
//            }
//        }
//        return bulls;
//    }
//
//    private int calculateCows(List<Integer> userNumber) {
//        int cows = 0;
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j <4; j++) {
//                int un = userNumber.get(i);
//                int mn = myNumbers.get(i);
//                if (un == mn && !(i==j)) {
//                    cows++;
//                }
//            }
//
//        }
//        return cows;
//    }

}
