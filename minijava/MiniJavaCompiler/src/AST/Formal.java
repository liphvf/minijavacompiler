package AST;
import AST.Visitor.Visitor;

public class Formal extends ASTNode{
  public Type t;
  public Identifier i;
 
  public Formal(Type at, Identifier ai, int ln) {
    super(ln);
    t=at; i=ai;
  }

  public void setNode(Visitor v) {
    v.visit(this);
  }
}
