package iss.services;

import java.util.Scanner;

import org.json.simple.parser.ParseException;

import org.springframework.web.client.RestTemplate;
import java.io.IOException;

import iss.models.Location;

import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class LocationService {

	private Location location = new Location();

	public void setLocation() throws IOException, ParseException {
		URL iss = new URL("http://api.open-notify.org/iss-now.json");
		ReadableByteChannel rbc1 = Channels.newChannel(iss.openStream());

		Scanner scanner = new Scanner(rbc1);
		String line = "";

		while (scanner.hasNext()) {
			line += scanner.nextLine();

			if (line != "") {
				line = line.replace(",", "");
				line = line.replace("}", "");
				line = line.replace("\"", "");
				String[] issArr = line.trim().split(" ");
				String timestamp = issArr[1];
				String longitude = issArr[6];
				String latitude = issArr[8];
				String message = issArr[8];

				location.setTimestamp(timestamp);
				location.setLongitude(longitude);
				location.setLatitude(latitude);
				location.setMessage(message);

			}

			System.out.println("As of 5 seconds ago, the International Space Station is currently located at latitude: " + location.getLatitude() + ", longitude: " + location.getLongitude());

		}
	}
}
