package iss.view;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import iss.app.IssApp;
import iss.services.LocationService;

public class ConsoleService {

LocationService ls = new LocationService();
	
	public void run() throws IOException, ParseException {
		ls.setLocation();
	}
}
