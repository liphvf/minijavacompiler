package AST.Visitor;

import AST.And;
import AST.ArrayAssign;
import AST.ArrayLength;
import AST.ArrayLookup;
import AST.Assign;
import AST.Block;
import AST.BooleanType;
import AST.Call;
import AST.ClassDeclExtends;
import AST.ClassDeclSimple;
import AST.DoubleLiteral;
import AST.DoubleType;
import AST.EqualEqual;
import AST.False;
import AST.FloatLiteral;
import AST.FloatType;
import AST.Formal;
import AST.GreatThan;
import AST.GreatThanEqual;
import AST.Identifier;
import AST.IdentifierExp;
import AST.IdentifierType;
import AST.If;
import AST.Instanceof;
import AST.IntArrayType;
import AST.IntegerLiteral;
import AST.IntegerType;
import AST.LessThan;
import AST.LessThanEqual;
import AST.MainClass;
import AST.MethodDecl;
import AST.Minus;
import AST.NewArray;
import AST.NewObject;
import AST.Not;
import AST.NotEqual;
import AST.Plus;
import AST.Print;
import AST.Program;
import AST.This;
import AST.Times;
import AST.True;
import AST.VarDecl;
import AST.While;

public class WriteVisitor implements Visitor {
	
	// MainClass m;
	// ClassDeclList cl;
	public void visit(Program n) {
		n.m.setNode(this);
		for (int i = 0; i < n.cl.size(); i++) {
			System.out.println();
			n.cl.elementAt(i).setNode(this);
		}
	}

	// Identifier i1,i2;
	// Statement s;
	public void visit(MainClass n) {
		System.out.print("class ");
		n.i1.setNode(this);
		System.out.println(" {");
		System.out.print("  public static void main (String [] ");
		n.i2.setNode(this);
		System.out.println(") {");
		System.out.print("    ");
		n.s.setNode(this);
		System.out.println("  }");
		System.out.println("}");
	}

	// Identifier i;
	// VarDeclList vl;
	// MethodDeclList ml;
	public void visit(ClassDeclSimple n) {
		System.out.print("class ");
		n.i.setNode(this);
		System.out.println(" { ");
	
		for (int i = 0; i < n.vl.size(); i++) {
			
			System.out.print("  ");
			n.vl.elementAt(i).setNode(this);
		
			if (i + 1 < n.vl.size()) {
				System.out.println();
			}
		}
		
		for (int i = 0; i < n.ml.size(); i++) {
			System.out.println();
			n.ml.elementAt(i).setNode(this);
		}
		System.out.println();
		System.out.println("}");
	}

	// Identifier i;
	// Identifier j;
	// VarDeclList vl;
	// MethodDeclList ml;
	public void visit(ClassDeclExtends n) {
		System.out.print("class ");
		n.i.setNode(this);
		System.out.println(" extends ");
		n.j.setNode(this);
		System.out.println(" { ");
		
		for (int i = 0; i < n.vl.size(); i++) {
			System.out.print("  ");
			n.vl.elementAt(i).setNode(this);
			if (i + 1 < n.vl.size()) {
				System.out.println();
			}
		}
		
		for (int i = 0; i < n.ml.size(); i++) {
			System.out.println();
			n.ml.elementAt(i).setNode(this);
		}
		
		System.out.println();
		System.out.println("}");
	}

	// Type t;
	// Identifier i;
	public void visit(VarDecl n) {
		
		if(n.exp == null){
			n.t.setNode(this);
			System.out.print(" ");
			n.i.setNode(this);
			System.out.print(";");
		}else{
			n.t.setNode(this);
			System.out.print(" ");
			n.i.setNode(this);
			System.out.print(" = ");
			n.exp.setNode(this);
			System.out.print(";");
		}
	}

	// Type t;
	// Identifier i;
	// FormalList fl;
	// VarDeclList vl;
	// StatementList sl;
	// Exp e;
	public void visit(MethodDecl n) {
		
		System.out.print("  public ");
		n.t.setNode(this);
		System.out.print(" ");
		n.i.setNode(this);
		System.out.print(" (");
		
		for (int i = 0; i < n.fl.size(); i++) {
			n.fl.elementAt(i).setNode(this);
			if (i + 1 < n.fl.size()) {
				System.out.print(", ");
			}
		}
		
		System.out.println(") { ");
		
		for (int i = 0; i < n.vl.size(); i++) {
			System.out.print("    ");
			n.vl.elementAt(i).setNode(this);
			System.out.println("");
		}
		
		for (int i = 0; i < n.sl.size(); i++) {
			System.out.print("    ");
			n.sl.elementAt(i).setNode(this);
			if (i < n.sl.size()) {
				System.out.println("");
			}
		}
		
		System.out.print("    return ");
		n.e.setNode(this);
		System.out.println(";");
		System.out.print("  }");
	}

	// Type t;
	// Identifier i;
	public void visit(Formal n) {
		n.t.setNode(this);
		System.out.print(" ");
		n.i.setNode(this);
	}

	public void visit(IntArrayType n) {
		System.out.print("int []");
	}

	public void visit(BooleanType n) {
		System.out.print("boolean");
	}

	public void visit(IntegerType n) {
		System.out.print("int");
	}

	// String s;
	public void visit(IdentifierType n) {
		System.out.print(n.s);
	}

	// StatementList sl;
	public void visit(Block n) {
		System.out.println("{ ");
		for (int i = 0; i < n.sl.size(); i++) {
			System.out.print("      ");
			n.sl.elementAt(i).setNode(this);
			System.out.println();
		}
		System.out.print("    } ");
	}

	// Exp e;
	// Statement s1,s2;
	public void visit(If n) {
		System.out.print("if (");
		n.e.setNode(this);
		System.out.println(") ");
		System.out.print("    ");
		n.s1.setNode(this);
		System.out.println();
		System.out.print("    else ");
		n.s2.setNode(this);
	}

	// Exp e;
	// Statement s;
	public void visit(While n) {
		System.out.print("while (");
		n.e.setNode(this);
		System.out.print(") ");
		n.s.setNode(this);
	}

	// Exp e;
	public void visit(Print n) {
		System.out.print("System.out.println(");
		n.e.setNode(this);
		System.out.print(");");
	}

	// Identifier i;
	// Exp e;
	public void visit(Assign n) {
		n.i.setNode(this);
		System.out.print(" = ");
		n.e.setNode(this);
		System.out.print(";");
	}

	// Identifier i;
	// Exp e1,e2;
	public void visit(ArrayAssign n) {
		n.i.setNode(this);
		System.out.print("[");
		n.e1.setNode(this);
		System.out.print("] = ");
		n.e2.setNode(this);
		System.out.print(";");
	}

	// Exp e1,e2;
	public void visit(And n) {
		System.out.print("(");
		n.e1.setNode(this);
		System.out.print(" && ");
		n.e2.setNode(this);
		System.out.print(")");
	}

	// Exp e1,e2;
	public void visit(LessThan n) {
		System.out.print("(");
		n.e1.setNode(this);
		System.out.print(" < ");
		n.e2.setNode(this);
		System.out.print(")");
	}

	// Exp e1,e2;
	public void visit(Plus n) {
		System.out.print("(");
		n.e1.setNode(this);
		System.out.print(" + ");
		n.e2.setNode(this);
		System.out.print(")");
	}

	// Exp e1,e2;
	public void visit(Minus n) {
		System.out.print("(");
		n.e1.setNode(this);
		System.out.print(" - ");
		n.e2.setNode(this);
		System.out.print(")");
	}

	// Exp e1,e2;
	public void visit(Times n) {
		System.out.print("(");
		n.e1.setNode(this);
		System.out.print(" * ");
		n.e2.setNode(this);
		System.out.print(")");
	}

	// Exp e1,e2;
	public void visit(ArrayLookup n) {
		n.e1.setNode(this);
		System.out.print("[");
		n.e2.setNode(this);
		System.out.print("]");
	}

	// Exp e;
	public void visit(ArrayLength n) {
		n.e.setNode(this);
		System.out.print(".length");
	}

	// Exp e;
	// Identifier i;
	// ExpList el;
	public void visit(Call n) {
		n.e.setNode(this);
		System.out.print(".");
		n.i.setNode(this);
		System.out.print("(");
		for (int i = 0; i < n.el.size(); i++) {
			n.el.elementAt(i).setNode(this);
			if (i + 1 < n.el.size()) {
				System.out.print(", ");
			}
		}
		System.out.print(")");
	}

	// int i;
	public void visit(IntegerLiteral n) {
		System.out.print(n.i);
	}

	public void visit(True n) {
		System.out.print("true");
	}

	public void visit(False n) {
		System.out.print("false");
	}

	// String s;
	public void visit(IdentifierExp n) {
		System.out.print(n.s);
	}

	public void visit(This n) {
		System.out.print("this");
	}

	// Exp e;
	public void visit(NewArray n) {
		System.out.print("new int [");
		n.e.setNode(this);
		System.out.print("]");
	}

	// Identifier i;
	public void visit(NewObject n) {
		System.out.print("new ");
		System.out.print(n.i.s);
		System.out.print("()");
	}

	// Exp e;
	public void visit(Not n) {
		System.out.print("!");
		n.e.setNode(this);
	}

	// String s;
	public void visit(Identifier n) {
		System.out.print(n.s);
	}

	// float literals
	public void visit(FloatLiteral n) {
		System.out.print(n.f);
	}

	// float type
	public void visit(FloatType n) {
		System.out.print("float");
	}
	
	// double literals
	public void visit(DoubleLiteral n) {
		System.out.print(n.d);
	}

	// double type
	public void visit(DoubleType n) {
		System.out.print("double");
	}

	public void visit(GreatThan n) {
		System.out.print("(");
		n.e1.setNode(this);
		System.out.print(" > ");
		n.e2.setNode(this);
		System.out.print(")");
	}

	@Override
	public void visit(GreatThanEqual n) {
		System.out.print("(");
		n.e1.setNode(this);
		System.out.print(" >= ");
		n.e2.setNode(this);
		System.out.print(")");
	}

	@Override
	public void visit(EqualEqual n) {
		System.out.print("(");
		n.e1.setNode(this);
		System.out.print(" == ");
		n.e2.setNode(this);
		System.out.print(")");
	}

	@Override
	public void visit(NotEqual n) {
		System.out.print("(");
		n.e1.setNode(this);
		System.out.print(" != ");
		n.e2.setNode(this);
		System.out.print(")");
	}
	
	@Override
	public void visit(Instanceof n) {
		System.out.print("(");
		n.e1.setNode(this);
		System.out.print(" instanceof ");
		n.e2.setNode(this);
		System.out.print(")");
	}
	
	@Override
	public void visit(LessThanEqual n) {
		System.out.print("(");
	    n.e1.setNode(this);
	    System.out.print(" <= ");
	    n.e2.setNode(this);
	    System.out.print(")");
	}
}
