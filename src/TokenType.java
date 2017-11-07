public enum TokenType {
    LPARN("[(]"),
    RPARN("[)]"),
    MINUS("[-]"),
    ASSGN("[=]"),
    LETEXP("LET"),
    INEXP("in"),
    IDNTFR("-?[a-z]+"),
    INTEGER("-?[0-9]+"),
    ISZERO("iszero"),
    COMMA("[,]"),
    WHITESPACE("[ \t \f \r \n]+"),
    IFEXP("if"),
    THENEXP("then"),
    ESLEEXP("else");

    public String pattern;
    TokenType (String pattern) { this.pattern = pattern; }
}