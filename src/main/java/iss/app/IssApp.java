package iss.app;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import iss.view.ConsoleService;

public class IssApp {
static ConsoleService cs = new ConsoleService();

	public static void main(String[] args) throws IOException, ParseException {
		
		cs.run();
		

	}

}
