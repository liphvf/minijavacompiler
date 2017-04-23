package AST;

import AST.Visitor.Visitor;

public class ArrayLength extends Exp {
	public Exp e;

	public ArrayLength(Exp ae, int ln) {
		super(ln);
		e = ae;
	}

	public void setNode(Visitor v) {
		v.visit(this);
	}
}
