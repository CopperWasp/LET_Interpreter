import java.util.ArrayList;

public class Parser {
    public static int index = 0;
    public static Scanner.Token Token;
    public static ArrayList<Scanner.Token> token_list_1 = new ArrayList<>();
    public static ArrayList<String> token_list_2 = new ArrayList<>();

    public static void increment() {
        if(index < token_list_1.size()) {
            Token = token_list_1.get(index);
            index++;
        }
    }
    public static LetLanguageExpression getParser(String input) {
        token_list_1 = Scanner.lexer(input);
        Token = Parser.token_list_1.remove(0);
        return expression();
    }
    public static LetLanguageExpression number() {
        System.out.println("INTEGER: " + Token.data);
        token_list_2.add(Token.data);
        int num = Integer.parseInt(Token.data);
        increment();
        LetLanguageExpression l3 = new LetLanguageExpression();
        return l3.new constExpression((num));
    }
    public static LetLanguageExpression expression() {
        while(!Token.data.isEmpty()) {
            switch(Token.type) {
                case INTEGER: { return number(); }
                case MINUS: { return diffExpression(); }
                case IDNTFR: { return identifier(); }
                case LETEXP: { return letExpression(); }
                default: { increment(); return null; }
            }
        }
        System.out.println("Token.data is empty.");
        return null;
    }
    public static LetLanguageExpression diffExpression() {
        System.out.println("SUBTRACT: " + Token.data);
        token_list_2.add(Token.data);
        increment();
        leftParenthesis();
        LetLanguageExpression l1 = expression();
        comma();
        LetLanguageExpression l2 = expression();
        rightParenthesis();
        LetLanguageExpression l3 = new LetLanguageExpression();
        return l3.new diffExpression(l1, l2);
    }

    public static void leftParenthesis() {
        if(Token.type.equals(TokenType.LPARN)) {
            System.out.println("LEFT PARENTHESIS: (");
            increment();
        }
        else System.out.print("error in LEFT PARENTHESIS");
    }
    public static void rightParenthesis() {
        if(Token.type.equals(TokenType.RPARN)) {
            System.out.println("RIGHT PARENTHESIS: )");
            increment();
        }
        else System.out.println("Error in RIGHT PARENTHESIS");
    }

    public static void comma() {
        if(Token.type.equals(TokenType.COMMA)) {
            System.out.println("COMMA: ,");
            increment();
        }
        else System.out.println("Error in COMMA");
    }
    public static void assignment() {
        if(Token.type.equals(TokenType.ASSGN)) {
            System.out.println("ASSIGNMENT: "+Token.data);
            increment();
        }
        else System.out.println("Error in ASSGN");
    }
    public static void in() {
        if(Token.type.equals(TokenType.INEXP)) {
            System.out.println("IN: "+Token.type);
            increment();
        }
        else System.out.println("Error in IN");

    }

    public static LetLanguageExpression identifier() {
        System.out.println("IDENTIFIER: " + Token.data);
        token_list_2.add(Token.data);
        String Var = Token.data;
        increment();
        LetLanguageExpression l3 = new LetLanguageExpression();
        return l3.new varExpression(Var);
    }
    public static LetLanguageExpression letExpression() {
        System.out.println("LET: " + Token.data);
        token_list_2.add(Token.data);
        increment();
        LetLanguageExpression Ide = identifier();
        assignment();
        LetLanguageExpression l3 = new LetLanguageExpression();
        LetLanguageExpression l1 = expression();
        in();
        LetLanguageExpression l2 = expression();
        return l3.new letExpression(Ide, l1, l2);
    }

}
