import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import AST.Program;
import Parser.parser;
import Scanner.scanner;

public class MiniJava {

	public static void main(String[] args) {
		try {
        	File f = new File("C:\\Users\\liphvf\\Downloads\\TEST.java");
			InputStream is = new FileInputStream(f);

			scanner s = new scanner(new BufferedReader(new InputStreamReader(is)));

            parser p = new parser(s);
            Program prog = (Program)(p.parse().value);
            	
        } catch (Exception e) {
            // yuck: some kind of error in the compiler implementation
            // that we're not expecting (a bug!)
            System.err.println("Erro interno inesperado no compilador: " + 
                               e.toString());  
            // print out a stack dump
            e.printStackTrace();
        }
	}

}
