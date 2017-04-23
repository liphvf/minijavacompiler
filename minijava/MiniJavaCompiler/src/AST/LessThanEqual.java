package AST;
import AST.Visitor.Visitor;

public class LessThanEqual extends Exp {
  public Exp e1,e2;
  
  public LessThanEqual(Exp ae1, Exp ae2, int ln) {
    super(ln);
    e1=ae1; e2=ae2;
  }

  public void setNode(Visitor v) {
    v.visit(this);
  }
  
  public String imprimeTermo1() {
	  return e1.toString();
  }
  
  public String imprimeTermo2() {
	  return e2.toString();
  }
  
  public String imprimeSimbolo() {
	  return "<=";
  }
  
}
