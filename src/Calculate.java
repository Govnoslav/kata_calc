class Calculate {

    static int calc (int first, int second, String operator){
        switch (operator){
            case "+":
                return first+second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first/second;
        };
        return 0;
    }
}
