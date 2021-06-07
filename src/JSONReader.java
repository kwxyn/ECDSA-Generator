import java.io.FileReader;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class JSONReader {

	public static ArrayList<String> JsonReadForText(String fileName) throws Exception // Reader for text to sign
	{
		ArrayList<String> texts = new ArrayList<String>();
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(fileName);
		Object obj = jsonParser.parse(reader);
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray JSONtexts = (JSONArray) jsonObject.get("text"); // Get JSONArray text
		for (int i = 0; i < JSONtexts.size(); i++) {
			String text = (String) JSONtexts.get(i); // Get Text
			texts.add(text); // add text to texts list
		}

		return texts;
	}

}
