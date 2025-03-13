package kiosk.level3.kiosk.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputCheck {
   public InputCheck(){}

    public int validationCheck(String command, Scanner scanner)
    {
        int tempInput;
        while (true){
            try{
                System.out.println(command);
                tempInput = scanner.nextInt();
                return  tempInput;
            }
            catch (InputMismatchException ex){
                System.out.println("[Exception] 숫자를 입력하세요");
                scanner.nextLine();
            }
        }

    }

}
