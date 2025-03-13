package kiosk.level5part2.kiosk.util;

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
                System.out.println("보기에 없는 입력입니다. 다시 입력 해주세요.");
                scanner.nextLine();
            }
        }
    }
}
