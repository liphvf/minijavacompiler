package AST;
import AST.Visitor.Visitor;

public class FloatLiteral extends Exp {
  public int f;

  public FloatLiteral(int af, int ln) {
    super(ln);
    f=af;
  }

  public void setNode(Visitor v) {
    v.visit(this);
  }
}
