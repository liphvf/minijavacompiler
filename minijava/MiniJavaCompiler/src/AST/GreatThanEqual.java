package AST;

import AST.Visitor.Visitor;

public class GreatThanEqual extends Exp{
	public Exp e1,e2;
	  
	  public GreatThanEqual(Exp ae1, Exp ae2, int ln) {
		  super(ln);
		  e1=ae1; e2=ae2;
	  }

	  public void setNode(Visitor v) {
	    v.visit(this);
	  }
	
}
