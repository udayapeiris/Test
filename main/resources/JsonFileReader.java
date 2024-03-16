/*
* @description This is the Json file reader class, you just have the pass the file name from you test-class to this class.
* Place the Json file under the test data folder and pass the file name to this class.  
* */

package resources;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFileReader {
	public static JSONObject cvJsonObject;

	public static Properties readPropertyFile(String fileName) throws IOException {
		Properties cvObjectRepository = new Properties();
		FileInputStream cvObjectFileStream = new FileInputStream(fileName);
		cvObjectRepository.load(cvObjectFileStream);
		return cvObjectRepository;
	}

	public static void readJsonFile(String fileName, String Type) throws IOException, Exception {
		if (Type == "TestData") {
			fileName = ".\\testdata\\" + fileName;

		}

		JSONParser cvParser = new JSONParser();
		Object cvObject = cvParser.parse(new FileReader(fileName));
		cvJsonObject = (JSONObject) cvObject;
	}

	public static JSONObject readJsonFile() throws IOException, Exception {
		return cvJsonObject;

	}

}
