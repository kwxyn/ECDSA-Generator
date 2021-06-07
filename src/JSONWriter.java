import java.io.FileWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONWriter {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void JsonWriteData(String fileName, ArrayList<Signature> Signatures) throws Exception {
		
		JSONObject obj = new JSONObject();
		JSONArray JSONSignatures = new JSONArray();
		for (int i = 0; i < Signatures.size(); i++) {
			JSONObject JSONSignature = new JSONObject();
			JSONSignature.put("text", Signatures.get(i).getText());
			JSONObject JSONRAndS = new JSONObject();
			JSONRAndS.put("r", String.valueOf(Signatures.get(i).getR()));
			JSONRAndS.put("s", String.valueOf(Signatures.get(i).getS()));
			JSONSignature.put("signature", JSONRAndS);
			JSONSignatures.add(JSONSignature);
		}
		obj.put("Signatures", JSONSignatures);

		@SuppressWarnings("resource")
		FileWriter file = new FileWriter(fileName);
		// We can write any JSONArray or JSONObject instance to the file
		file.write(obj.toString());
		file.flush();

	}
	
@SuppressWarnings("unchecked")
public static void JsonWriteParameterData(String fileName, CurveParameters cp) throws Exception {
		
		JSONObject obj = new JSONObject();
		obj.put("name", String.valueOf(cp.getName()));
		obj.put("p", String.valueOf(cp.getP()));
		obj.put("a", String.valueOf(cp.getA()));
		obj.put("b", String.valueOf(cp.getB()));
		JSONObject generatorPoints = new JSONObject();
		generatorPoints.put("x", String.valueOf(cp.getX()));
		generatorPoints.put("y", String.valueOf(cp.getY()));
		obj.put("g",generatorPoints);
		obj.put("n", String.valueOf(cp.getN()));
		JSONObject publicKeyPoints = new JSONObject();
		publicKeyPoints.put("x", String.valueOf(cp.getPublic_key().getAffineX()));
		publicKeyPoints.put("y", String.valueOf(cp.getPublic_key().getAffineY()));
		obj.put("public key",publicKeyPoints);
		
		@SuppressWarnings("resource")
		FileWriter file = new FileWriter(fileName);
		// We can write any JSONArray or JSONObject instance to the file
		file.write(obj.toString());
		file.flush();

	}

}