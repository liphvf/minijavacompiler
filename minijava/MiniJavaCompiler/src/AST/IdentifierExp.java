package AST;
import AST.Visitor.Visitor;

public class IdentifierExp extends Exp {
  public String s;
  public IdentifierExp(String as, int ln) { 
    super(ln);
    s=as;
  }

  public void setNode(Visitor v) {
    v.visit(this);
  }
  
  public String toString() {
	  return s;
  }
}
