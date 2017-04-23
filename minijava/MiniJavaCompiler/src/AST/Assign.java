package AST;

import AST.Visitor.Visitor;

public class Assign extends Statement {
	public Identifier i;
	public Exp e;

	public Assign(Identifier ai, Exp ae, int ln) {
		super(ln);
		i = ai;
		e = ae;
	}

	public void setNode(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return e.toString();
	}
	
}
