class FindOperator {
    static String operator(String expression){

        for(char element : expression.toCharArray()) {
            switch (element){
                case 43:
                    return "+";
                case 45:
                    return  "-";
                case 42:
                    return  "*";
                case 47:
                    return "/";
            };
        };
        return null;
    }
}
