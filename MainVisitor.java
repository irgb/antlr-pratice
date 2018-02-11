import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class MainVisitor {
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if (args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if (inputFile!=null ) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);

        CalculatorLexer lexer = new CalculatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        //System.out.println(tokens.getText());
        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.expr(); // parse

        CalculatorVisitorImpl eval = new CalculatorVisitorImpl();
        System.out.println(eval.visit(tree));
    }
}

class CalculatorVisitorImpl extends CalculatorBaseVisitor<Integer> {
    @Override
    public Integer visitMulDiv(CalculatorParser.MulDivContext ctx) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.op.getType() == CalculatorParser.MUL) {
            return left * right;
        } else {
            return left / right;
        }
	}

	@Override
    public Integer visitAddSub(CalculatorParser.AddSubContext ctx) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        if (ctx.op.getType() == CalculatorParser.ADD) {
            return left + right;
        } else {
            return left - right;
        }
    }

	@Override
    public Integer visitParens(CalculatorParser.ParensContext ctx) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        return visit(ctx.expr());
    }

	@Override
    public Integer visitInt(CalculatorParser.IntContext ctx) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		return Integer.valueOf(ctx.INT().getText());
    }
}
