public class CalculatorVisitorImpl extends CalculatorBaseVisitor<Integer> {
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
