// عادل عبدالله الشايع


# javaimport java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //-----------------------------------------------------------------------------------------
        System.out.println("------------------ first answer -----------------");

        Scanner s = new Scanner(System.in);

        System.out.print("**The Calculator**\nEnter the first number please: ");
        int firstNumber = s.nextInt();
        System.out.print("Enter the second number please: ");
        int secondNumber = s.nextInt();
        System.out.println("Result for " + firstNumber + " + " + secondNumber + " is " + (firstNumber + secondNumber));
        System.out.println("Result for " + firstNumber + " - " + secondNumber + " is " + (firstNumber - secondNumber));
        System.out.println("Result for " + firstNumber + " * " + secondNumber + " is " + (firstNumber * secondNumber));
        System.out.println("Result for " + firstNumber + " / " + secondNumber + " is " + (firstNumber / secondNumber));
        System.out.println("Result for " + firstNumber + " % " + secondNumber + " is " + (firstNumber % secondNumber));

        //-----------------------------------------------------------------------------------------
        System.out.println("------------------ Second answer -----------------\n");

        //ملاحظة: هذا الكود يظهر خطأ إذا كان النص يحتوي على مسافات وأخبرت المعلمة بذلك وقالت سنبحث عن الموضوع

        System.out.print("Enter any text to change characters to lower case: ");
        String stringReceived = s.next();
        String newText = stringReceived.toLowerCase();
        System.out.println("Your new text is :" + newText);

        //-----------------------------------------------------------------------------------------
        System.out.println("------------------ Third answer -----------------\n");

        //ملاحظة: وهذا الكود أيضاً يظهر خطأ إذا كان النص يحتوي على مسافات 

        System.out.print("Enter any text to revers it: ");
        String theText = s.next();
        char[] splitText = theText.toCharArray();
        for (int i = splitText.length -1; i >=0;i--)
        {
            System.out.print(splitText[i]);
        }
        System.out.println();

        //-----------------------------------------------------------------------------------------
        System.out.println("------------------ Forth answer -----------------\n");

        System.out.print("Enter any number to check if even or odd: ");
        int theNumberReceived = s.nextInt();
        int result = theNumberReceived % 2;
        if (result == 1)
            System.out.println("0");
        else
            System.out.println("1");

        //-----------------------------------------------------------------------------------------
        System.out.println("------------------ fifth answer -----------------\n");

        System.out.print("Kindly enter your role (admin, superuser, user, ...): ");
        String stringReceived1 = s.next();
        if (stringReceived1.equals("admin"))
            System.out.println("Welcome admin");
        else if (stringReceived1.equals("superuser"))
            System.out.println("Welcome superuser");
        else if (stringReceived1.equals("user"))
            System.out.println("Welcome user");
        else
            System.out.println("Welcome " + stringReceived1);

        //-----------------------------------------------------------------------------------------
        System.out.println("------------------ sixth answer -----------------\n");

        System.out.print("**To check if first number + second number = third number**\nEnter your first number: ");
        int theFirstNumber = s.nextInt();
        System.out.print("Enter your second number: ");
        int theSecondNumber = s.nextInt();
        System.out.print("Enter your third number: ");
        int theThirdNumber = s.nextInt();

        int sumInt = theFirstNumber + theSecondNumber;

        System.out.println(sumInt == theThirdNumber);

        //-----------------------------------------------------------------------------------------
        System.out.println("------------------ Seventh answer -----------------\n");

        System.out.print("**print the greatest number**\nEnter your first number: ");
        int theFirstNum = s.nextInt();
        System.out.print("Enter your second number: ");
        int theSecondNum = s.nextInt();
        System.out.print("Enter your third number: ");
        int theThirdNum = s.nextInt();

        if (theFirstNum > theSecondNum)
        {
            if (theFirstNum > theThirdNum)
            {
                System.out.println("The greatest: " + theFirstNum);
            }
            else System.out.println("The greatest: " + theThirdNum);
        }
        else if (theSecondNum > theThirdNum)
            System.out.println("The greatest: " + theSecondNum);
        else System.out.println("The greatest: " + theThirdNum);

        //-----------------------------------------------------------------------------------------
        System.out.println("------------------ eighth answer -----------------\n");

        System.out.print("Enter Any number from 1 to 7 to displays the name of the weekday: ");
        int theNum = s.nextInt();
        switch (theNum)
        {
            case 1: System.out.println("Day is sunday");
            break;
            case 2: System.out.println("Day is Monday");
            break;
            case 3: System.out.println("Day is Tuesday");
            break;
            case 4: System.out.println("Day is Wednesday");
            break;
            case 5: System.out.println("Day is Thursday");
            break;
            case 6: System.out.println("Day is Friday");
            break;
            case 7: System.out.println("Day is Saturday");
            break;
            default: System.out.println("Wrong number");

        }
    }
}
