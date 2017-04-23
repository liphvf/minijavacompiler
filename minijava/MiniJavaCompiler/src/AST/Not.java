package AST;
import AST.Visitor.Visitor;

public class Not extends Exp {
  public Exp e;
  
  public Not(Exp ae, int ln) {
    super(ln);
    e=ae; 
  }

  public void setNode(Visitor v) {
    v.visit(this);
  }
}
