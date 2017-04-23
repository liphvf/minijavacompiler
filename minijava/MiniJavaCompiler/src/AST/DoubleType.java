package AST;

import AST.Visitor.Visitor;

public class DoubleType extends Type {
	public DoubleType(int ln) {
		super(ln);
	}

	public void setNode(Visitor v) {
		v.visit(this);
	}
}
