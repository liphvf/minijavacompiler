package Tests;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import AST.Statement;
import AST.Visitor.PrettyPrintVisitor;
import Parser.parser;
import Scanner.scanner;
import java_cup.runtime.Symbol;

public class TestParser {
    public static void main(String [] args) {
        try {
            // create a scanner on the input file
            scanner s = new scanner(new BufferedReader(new InputStreamReader(System.in)));
            parser p = new parser(s);
            Symbol root;
	    // replace p.parse() with p.debug_parse() in next line to see trace of
	    // parser shift/reduce actions during parse
            root = p.parse();
            List<Statement> program = (List<Statement>)root.value;
            for (Statement statement: program) {
                statement.accept(new PrettyPrintVisitor());
				System.out.print("\n");
            }
            System.out.print("\nParsing completed"); 
        } catch (Exception e) {
            // yuck: some kind of error in the compiler implementation
            // that we're not expecting (a bug!)
            System.err.println("Unexpected internal compiler error: " + 
                               e.toString());
            // print out a stack dump
            e.printStackTrace();
        }
    }
}
