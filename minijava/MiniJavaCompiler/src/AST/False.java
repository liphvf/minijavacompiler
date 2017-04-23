package AST;
import AST.Visitor.Visitor;

public class False extends Exp {
  public False(int ln) {
    super(ln);
  }
  public void setNode(Visitor v) {
    v.visit(this);
  }
  
  @Override
	public String toString() {
		// TODO Auto-generated method stub
		return "false";
	}
}
