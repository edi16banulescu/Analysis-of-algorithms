package Problema3;

import java.io.IOException;

public class TestSetCover {
    public static void main(String[] args) throws IOException {
        Integer[][] arrayOfSets = {
                {1, 2, 3, 8, 9, 10},
                {1, 2, 3, 4, 5},
                {4, 5, 7},
                {5, 6, 7},
                {6, 7, 8, 9, 10},
        };

        Integer[] solution = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        SetCover test = new SetCover();
        test.test(arrayOfSets, solution);
    }
}
