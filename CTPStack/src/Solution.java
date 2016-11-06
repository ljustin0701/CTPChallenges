import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Justin on 9/17/2016.
 */
class Parser {

    boolean checkParenthesesBalance(String input){
        char[] arr = new char[input.length()];
        int inputTemp = 0;
        int arrSize = 0;

        if(input.length() == 0)
            return true;
        else {
            while(!(inputTemp > input.length()-1)){
                if(input.charAt(inputTemp) == '(' || input.charAt(inputTemp) == '{'){
                    arr[arrSize] = input.charAt(inputTemp);
                    inputTemp++;
                    arrSize++;
                } else if(input.charAt(inputTemp) == ')'){
                    if(arrSize != 0 && arr[arrSize-1] == '('){
                        inputTemp++;
                        arrSize--;
                    } else {
                        arr[arrSize] = input.charAt(inputTemp);
                        inputTemp++;
                        arrSize++;
                    }
                } else if(input.charAt(inputTemp) == '}'){
                    if(arrSize != 0 && arr[arrSize-1] == '{'){
                        inputTemp++;
                        arrSize--;
                    } else {
                        arr[arrSize] = input.charAt(inputTemp);
                        inputTemp++;
                        arrSize++;
                    }
                }
            }
        }

        if(arrSize != 0)
            return false;
        else
            return true;
    }
}

class Solution{

    public static void main(String[] arg) throws FileNotFoundException
    {
        Parser X=new Parser();
        Scanner in = new Scanner(new File("input002.txt"));

        while (in.hasNext()) {
            System.out.println(X.checkParenthesesBalance(in.next()));
        }

    }
}
