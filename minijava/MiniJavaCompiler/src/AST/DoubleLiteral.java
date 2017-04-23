package AST;

import AST.Visitor.Visitor;

public class DoubleLiteral extends Exp {
	public int d;

	public DoubleLiteral(int af, int ln) {
		super(ln);
		d = af;
	}

	public void setNode(Visitor v) {
		v.visit(this);
	}
}
