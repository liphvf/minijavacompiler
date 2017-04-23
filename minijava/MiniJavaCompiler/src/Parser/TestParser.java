package Parser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import AST.Program;
import AST.Visitor.WriteVisitor;
import Scanner.scanner;
import java_cup.runtime.Symbol;

public class TestParser {
	public static void main(String[] args) {
		try {

			File f = new File("C:\\Users\\liphvf\\Documents\\minijavacompiler\\minijava\\MiniJavaCompiler\\testFile\\Test.java");
			InputStream is = new FileInputStream(f);

			scanner s = new scanner(new BufferedReader(new InputStreamReader(is)));
			parser p = new parser(s);
			Symbol root;
			root = p.parse();

			Program prog = (Program) root.value;
			prog.accept(new WriteVisitor());

			System.out.print("\nParsing successfull");
		} catch (Exception e) {
			System.err.println("Unexpected internal compiler error: " + e.toString());
			e.printStackTrace();
		}
	}
}