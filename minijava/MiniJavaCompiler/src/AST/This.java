package AST;
import AST.Visitor.Visitor;

public class This extends Exp {
  public This(int ln) {
    super(ln);
  }
  public void setNode(Visitor v) {
    v.visit(this);
  }
}
