import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scanner {
    public static ArrayList<Token> lexer(String input) {

        ArrayList<Token> tokens = new ArrayList<>();
        StringBuilder tokenPatternsBuffer = new StringBuilder();

        for(TokenType tokenType : TokenType.values())
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));

        Pattern tokenPatterns = Pattern.compile(tokenPatternsBuffer.substring(1));
        Matcher matcher = tokenPatterns.matcher(input);

        while(matcher.find()) {
            if(matcher.group().matches(TokenType.IFEXP.pattern)) {
                tokens.add(new Token(TokenType.IFEXP, matcher.group()));
                continue;
            }
            else if(matcher.group().matches(TokenType.INTEGER.pattern)) {
                tokens.add(new Token(TokenType.INTEGER, matcher.group()));
                continue;
            }
            else if(matcher.group().matches(TokenType.LETEXP.pattern)) {
                tokens.add(new Token(TokenType.LETEXP, matcher.group()));
                continue;
            }
            else if(matcher.group().matches(TokenType.INEXP.pattern)) {
                tokens.add(new Token(TokenType.INEXP, matcher.group()));
                continue;
            }
            else if(matcher.group().matches(TokenType.IDNTFR.pattern)) {
                tokens.add(new Token(TokenType.IDNTFR, matcher.group()));
                continue;
            }
            else if(matcher.group().matches(TokenType.ASSGN.pattern)) {
                tokens.add(new Token(TokenType.ASSGN, matcher.group()));
                continue;
            }
            else if(matcher.group().matches(TokenType.LPARN.pattern)) {
                tokens.add(new Token(TokenType.LPARN, matcher.group()));
                continue;
            }
            else if(matcher.group().matches(TokenType.RPARN.pattern)) {
                tokens.add(new Token(TokenType.RPARN, matcher.group()));
                continue;
            }
            else if(matcher.group().matches(TokenType.COMMA.pattern)) {
                tokens.add(new Token(TokenType.COMMA, matcher.group()));
                continue;
            }
            else if(matcher.group().matches(TokenType.MINUS.pattern)) {
                tokens.add(new Token(TokenType.MINUS, matcher.group()));
                continue;
            }
            else if(matcher.group().matches(TokenType.ISZERO.pattern)) {
                tokens.add(new Token(TokenType.ISZERO, matcher.group()));
                continue;
            }
            else if(matcher.group().matches(TokenType.THENEXP.pattern)) {
                tokens.add(new Token(TokenType.THENEXP, matcher.group()));
                continue;
            }
            else if(matcher.group().matches(TokenType.ESLEEXP.pattern)) {
                tokens.add(new Token(TokenType.ESLEEXP, matcher.group()));
                continue;
            }
            else if(matcher.group().matches(TokenType.WHITESPACE.pattern)) {
                continue;
            }
        }
        return tokens;
    }
    public static class Token {
        public TokenType type;
        public String data;

        public Token(TokenType type, String data) {
            this.type = type;
            this.data = data;
        }
    }
}
