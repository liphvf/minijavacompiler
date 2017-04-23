package AST;
import AST.Visitor.Visitor;

public class Plus extends Exp {
  public Exp e1,e2;
  
  public Plus(Exp ae1, Exp ae2, int ln) { 
    super(ln);
    e1=ae1; e2=ae2;
  }

  public void setNode(Visitor v) {
    v.visit(this);
  }
  
  @Override
	public String toString() {
		// TODO Auto-generated method stub
		return e1.toString() + " + " + e2.toString();
	}
}
