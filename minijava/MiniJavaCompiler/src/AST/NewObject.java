package AST;
import AST.Visitor.Visitor;

public class NewObject extends Exp {
  public Identifier i;
  
  public NewObject(Identifier ai, int ln) {
    super(ln);
    i=ai;
  }

  public void setNode(Visitor v) {
    v.visit(this);
  }
  @Override
	public String toString() {
		// TODO Auto-generated method stub
		return i.toString();
	}
}
