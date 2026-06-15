
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in); 
        boolean KeepRunning=true;
        System.out.println("=== Welcome to this Java Calculator ===");
        System.out.println("Available operations: + , - , / , * , %");
        System.out.println("Type 'q' when asked for an operation to stop and start over");
        System.out.println("=================");
        while (KeepRunning){
            System.out.println("\nEnter First NUMBER:");
            double num1=sc.nextDouble();
            System.out.println("Enter an Operator(+,*,/,-,%) or 'q' to quit:");
        char operator=sc.next().charAt(0);
            if (operator=='q' || operator=='Q'){
                KeepRunning=false;
                System.out.println("Goodbye SAYONARA GRACIAS");
                break;
            }
            System.out.println("Enter Second NUMBER:");
            double num2=sc.nextDouble();
            double result=0;
            boolean validOperation=true;//greenflag given to start the calculation
            switch(operator){
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    if (num2==0) {
                        System.out.println("Error-division by zero not possible");
                        validOperation=false;
                    
                    }else{
                        result=num1/num2;
                        
                    }
                    break;
                case '%':
                    if (num2==0) {
                        System.out.println("Error-cannot find remainder of a zero");
                        validOperation=false;
            }else{
                        result=num1%num2;
                        
            }
                    break;
                default:
                    System.out.println("invalid operator chosen");
                    validOperation=false;
        }
                    if(validOperation)//print the result if no mathematical rule is broken
                        System.out.println("Result:"+result);
        }
        sc.close();
    }
    
}
