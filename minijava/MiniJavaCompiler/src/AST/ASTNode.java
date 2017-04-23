package AST;

abstract public class ASTNode {
	protected int line_number;

	public ASTNode(int ln) {
		line_number = ln;
	}

	public int getLine() {
		return line_number;
	}
}
