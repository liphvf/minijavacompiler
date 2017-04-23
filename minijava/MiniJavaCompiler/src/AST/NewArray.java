package AST;
import AST.Visitor.Visitor;

public class NewArray extends Exp {
  public Exp e;
  
  public NewArray(Exp ae, int ln) {
    super(ln);
    e=ae; 
  }

  public void setNode(Visitor v) {
    v.visit(this);
  }
}
