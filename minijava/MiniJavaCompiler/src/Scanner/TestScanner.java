package Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import Parser.sym;
import java_cup.runtime.Symbol;

public class TestScanner {
	public static void main(String[] args) {
		try {
			File f = new File("C:\\Users\\liphvf\\Documents\\minijavacompiler\\minijava\\MiniJavaCompiler\\testFile\\Test.java");
			InputStream is = new FileInputStream(f);

			System.out.println("Lexical analysis Started.");
			System.out.println("");
			scanner s = new scanner(new BufferedReader(new InputStreamReader(is)));
			Symbol t = s.next_token();

			while (t.sym != sym.EOF) {

				System.out.print(s.symbolToString(t) + " ");
				t = s.next_token();
			}

			System.out.println("");
			System.out.println("\nLexical analysis successfull");
		} catch (Exception e) {
			System.err.println("Unexpected internal compiler error: " + e.toString());
			e.printStackTrace();
		}
	}
}
