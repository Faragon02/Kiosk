package kiosk.level5part1.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidationCheck {

    public static int checkCommentInt(String command, Scanner scanner) {
        int tempInput;
        while (true) {
            try {
                System.out.println(command);
                tempInput = scanner.nextInt();
                return  tempInput;
            }
            catch (InputMismatchException ex) {
                System.out.println("[Exception] 숫자를 입력하세요");
                scanner.nextLine();
            }
        }
    }
}
