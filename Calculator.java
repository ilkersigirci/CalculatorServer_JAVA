public class Calculator {

    String text;

    public Calculator(String text) {
        this.text = text;
    }

    public int calculate() {

        int result = 0;
            
            String[] splitted = text.trim().split("\\s+");

            int operand1 = Integer.parseInt(splitted[0]);
            String operator = splitted[1];
            int operand2 = Integer.parseInt(splitted[2]);

            
            switch(operator) {
            case "+":
                result = operand1 + operand2;
                break;

            case "-":
                result = operand1 - operand2;
                break;

            case "*":
                result = operand1 * operand2;
                break;

            case "/":
                result = operand1 / operand2;
                break;

            default:
                result = -1;
            }
        return result;
    }
}