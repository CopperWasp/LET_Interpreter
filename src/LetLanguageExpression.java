public class LetLanguageExpression {

    protected Variable variable;

    public String getVar() { return null; }

    public LetLanguageExpression getLetExp1() { return null; }
    public LetLanguageExpression getLetExp2() { return null; }
    public LetLanguageExpression getDiffExp1() { return null; }
    public LetLanguageExpression getDiffExp2() { return null; }
    public LetLanguageExpression getIdentifier() { return null; }

    public int getNum() { return 0; }

    public class constExpression extends LetLanguageExpression {
        public int value;
        public int getNum() { return value; }
        public constExpression(int value1) {
            this.value = value1;
            super.variable = Variable.NUMBER;
        }
    }
    public class diffExpression extends LetLanguageExpression {

        private LetLanguageExpression exp1;
        private LetLanguageExpression exp2;
        public LetLanguageExpression getDiffExp1() { return exp1; }
        public LetLanguageExpression getDiffExp2() { return exp2; }

        public diffExpression(LetLanguageExpression exp1, LetLanguageExpression exp2) {
            this.exp1 = exp1;
            this.exp2 = exp2;
            super.variable = Variable.MINUS;
        }
    }
    public class varExpression extends LetLanguageExpression {
        private String exp;
        public String getVar() { return exp; }
        public varExpression(String exp) {
            this.exp = exp;
            super.variable = Variable.VAR;
        }
    }
    public class letExpression extends LetLanguageExpression {

        public letExpression(LetLanguageExpression exp, LetLanguageExpression exp1, LetLanguageExpression exp2) {
            this.exp = exp;
            this.exp1 = exp1;
            this.exp2 = exp2;
            super.variable = Variable.LET;
        }

        public LetLanguageExpression exp;
        public LetLanguageExpression exp1;
        public LetLanguageExpression exp2;

        public LetLanguageExpression getIdentifier() { return exp; }
        public LetLanguageExpression getLetExp1() { return exp1; }
        public LetLanguageExpression getLetExp2() { return exp2; }
    }
}