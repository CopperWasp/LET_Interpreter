public class Main {

    public static int valueOf(LetLanguageExpression exp, Environment env) {
        switch(exp.variable) {
            case NUMBER: { return exp.getNum(); }
            case VAR: { return env.getValue(exp.getVar()); }
            case MINUS: { return valueOf(exp.getDiffExp1(), env)-valueOf(exp.getDiffExp2(), env); }
            case LET: { return valueOf(exp.getLetExp2(), new Environment(exp.getIdentifier().getVar(), valueOf(exp.getLetExp1(), env), env)); }
            default: { throw new RuntimeException("UNKNOWN");
            }
        }
    }

    public static void main(String... args) {

        String input_program = "LET x=7 in LET y=2 in LET y= LET x= -(x,1) in -(x,y) in -(-(x,8),y)";
        LetLanguageExpression program_expression = Parser.getParser(input_program);

        System.out.println();
        System.out.println("---Evaluation result---");
        System.out.println(valueOf(program_expression, null));
    }

}
