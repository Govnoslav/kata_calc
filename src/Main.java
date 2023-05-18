import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static String calc(String input) throws IOException {

        /*-------------------------VALIDATE USER INPUT---------------*/
        boolean userInputArabicNumbers = input.matches("\\d{1,2}\s?[\\+\\-\\*\\/]\s?\\d{1,2}");
        boolean userInputRomanNumbers = input.matches("[IVX]{1,4}\s?[\\+\\-\\*\\/]\s?[IVX]{1,4}");
        input = input.replaceAll("\\s+","");
        String[] numbers = input.split("[\\+\\-\\*\\/]");

        if(!userInputArabicNumbers && !userInputRomanNumbers){
            throw new IOException("Invalid input");
        }
        /*-------------------------ARABIC------------------------------------------*/

        if(userInputArabicNumbers){
                                                                                                            
            int firstOperand = Integer.parseInt(numbers[0]),
                secondOperand = Integer.parseInt(numbers[1]);

            if((1>firstOperand || firstOperand>10)||(1>secondOperand || secondOperand >10)) {

                throw new IOException("Number less then 1 or bigger then 10");
            }

            String operator = FindOperator.operator(input);
            return Calculate.calc(firstOperand,secondOperand,operator)+"";
        }


        /*-------------------------ROMAN------------------------------------------*/

        if(userInputRomanNumbers){

            try {
                RomanToArabic number = RomanToArabic.valueOf(numbers[0]);
                RomanToArabic number2 = RomanToArabic.valueOf(numbers[1]);

            }
            catch(Exception e) {
                throw new IOException("Number less then 1 or bigger then 10");
            }

            RomanToArabic number = RomanToArabic.valueOf(numbers[0]);
            RomanToArabic number2 = RomanToArabic.valueOf(numbers[1]);

            int firstOperand = number.getValue(),
                secondOperand = number2.getValue();


            String operator = FindOperator.operator(input);

            if((1>firstOperand || firstOperand>10)||(1>secondOperand || secondOperand >10)) {
                throw new IOException("Number less then 1 or bigger then 10");
            }

            int result = Calculate.calc(firstOperand,secondOperand,operator);

            if (result <1 ) {
                throw new IOException("There are no Roman number less than 1 ");
                }
            return ArabicToRoman.romanNumbers[result];
            }

        return null;
        }

    public static void main(String[] args) throws IOException {
        Scanner userInput = new Scanner(System.in);
        String userExpression = userInput.nextLine();

        System.out.println(calc(userExpression));

        }
    }
