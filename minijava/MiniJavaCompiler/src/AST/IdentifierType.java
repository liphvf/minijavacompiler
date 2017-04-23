package AST;
import AST.Visitor.Visitor;

public class IdentifierType extends Type {
  public String s;

  public IdentifierType(String as, int ln) {
    super(ln);
    s=as;
  }

  public void setNode(Visitor v) {
    v.visit(this);
  }
}
