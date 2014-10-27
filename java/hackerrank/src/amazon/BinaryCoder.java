package amazon;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/*Question 2: 
 Baidu URL:  geocoding.baidu.com?format=binary
 Request:
 ID    long    
 PROVINCE    string    optional
 CITY    string    
 ADDRESSLINE    string    
 RESULT COUNT    byte    

 Response:
 STATUS    byte
 RESULT COUNT    byte
 RESULT PROVINCE    string
 RESULT CITY    string
 RESULT DISTRICT    string
 RESULT TYPE    byte
 RESULT CONFIDENT    byte
 RESULT FROMAT ADDRESS    string
 RESULT LONGITUDE    double
 RESULT LATITUDE    double
 */



public class BinaryCoder {


	static byte[] testData = new byte[]{ 
		0,1,1,
		0,1,1,
		0, 7, 66,101,105,106,105,110,103,
		0, 13, 87,	97,	110,103,106,105,110,103,32,	78,	111,46,	50,
		0, 6, 	87,	97,	110,103,106,105,
		0, 1, 3,
		0, 1, 0,
		0, 8, 	87,	97,	110,103,106,105,110,111,
		0, 4, 50,50,46,51,
		0, 4, 51,51,46,50,		
 }; 

	//only for simple validation
	public static void main(String[] args) {

		System.out.println("============ encoder=========");
		
		//test encoder
		GeoRequest req = new GeoRequest();
		req.ID = 123L;
		req.CITY = "Bj";
		req.PROVINCE = "Beijing"; // optional
		req.ADDRESSLINE = "Wangjing No.2";
		req.RESULTCOUNT = 1;

		byte[] b0 = BinaryCoder.generateRequest(req);	//using OutputStream

		byte[] b1 = BinaryCoder.generateRequest1(req);  //using array.  asserted, b0 equals to b1

		for(int i =0; i<b0.length ;i++){
			System.out.println(b0[i] );
		
		}
		System.out.println("============parser===========");		
		
		//test parser
		GeoResponse resp = BinaryCoder.parseResponse(testData);
		System.out.println("status:" + resp.STATUS);
		System.out.println("type:" + resp.TYPE);
		System.out.println("province:" + resp.PROVINCE);
		System.out.println("city:" + resp.CITY);
		System.out.println("count:" + resp.COUNT);
		System.out.println("confident:" + resp.CONFIDENT);
		System.out.println("address:" + resp.FROMATADDRESS);
		System.out.println("latitude:" + resp.LATITUDE);
		System.out.println("longitude:" + resp.LONGITUDE);
		
	}

	
	//using InputStream
	public static GeoResponse parseResponse(byte[] data) {
		// decode
		GeoResponse resp = new GeoResponse();

		// parse the byte[]
		ByteArrayInputStream is = new ByteArrayInputStream(data);

		try {

			int opt = is.read();
			if (opt == -1) {
				return null;
			}
			int fdIdx = 0;
			
			while (opt != -1) {
				
				
				int len = is.read();
				//System.out.println(len);
				if (len > 0) {
					byte[] value = new byte[len];
					is.read(value);

					if (fdIdx == 0) {
						resp.STATUS = value[0];

					} else if (fdIdx == 1) {
						resp.COUNT = value[0];
						
					} else if (fdIdx == 2) {
						resp.PROVINCE = new String(value);

					} else if (fdIdx == 3) {
						resp.CITY = new String(value);

					} else if (fdIdx == 4) {
						resp.DISTRICT = new String(value);

					} else if (fdIdx == 5) {
						resp.TYPE = value[0];

					} else if (fdIdx == 6) {
						resp.CONFIDENT = value[0];

					} else if (fdIdx == 7) {
						resp.FROMATADDRESS = new String(value);

					} else if (fdIdx == 8) {
						if(value.length>0)
							resp.LONGITUDE = Double.parseDouble(new String(value));

					} else if (fdIdx == 9) {
						if(value.length>0)
							resp.LATITUDE = Double.parseDouble(new String(value));

					}

				}

				fdIdx++;
				opt = is.read(); // optional
			}

			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block

			return null;
		}
		return resp;

	}

	//using OutputStream
	public static byte[] generateRequest(GeoRequest req) {

		// populate
		Element[] els = populateElements(req);

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			for (int i = 0; i < els.length; i++) {

				bos.write(els[i].optional);
				bos.write(els[i].len);
				bos.write(els[i].value);

			}

			bos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte retArr[] = bos.toByteArray();
		return retArr;

	}

	// with array operations
	public static byte[] generateRequest1(GeoRequest req) {

		// populate
		Element[] els = populateElements(req);

		// encoding
		int total = 0;
		for (int i = 0; i < els.length; i++)
		{
			total = total + (els[i].len + 2);
		}

		byte[] tmp = new byte[total];
		int index = 0;
		for (int i = 0; i < els.length; i++)
		{

			tmp[index] = els[i].optional;
			index++;
			tmp[index] = els[i].len;
			index++;

			for (int j = 0; j < els[i].len; j++) {
				tmp[index] = els[i].value[j];
				index++;
			}

		}

		return tmp;
	}


	private static Element[] populateElements(GeoRequest req) {
		Element[] els = new Element[5];
		els[0] = new Element();
		els[0].optional = 0;
		els[0].value = req.ID.toString().getBytes();
		els[0].len = (byte) els[0].value.length;

		els[1] = new Element();
		els[1].optional = 0;
		els[1].value = req.CITY.getBytes();
		els[1].len = (byte) els[1].value.length;

		els[2] = new Element();
		els[2].optional = 1;
		els[2].value = req.PROVINCE.getBytes();
		if (req.PROVINCE.isEmpty())
			els[2].len = 0;
		else
			els[2].len = (byte) els[2].value.length;

		els[3] = new Element();
		els[3].optional = 0;
		els[3].value = req.ADDRESSLINE.getBytes();
		els[3].len = (byte) els[3].value.length;

		els[4] = new Element();
		els[4].optional = 0;
		els[4].value = new byte[1];
		els[4].value[0] = req.RESULTCOUNT;
		els[4].len = (byte) els[4].value.length;
		return els;
	}

	
}

class GeoRequest {

	Long ID;
	String PROVINCE; // optional
	String CITY;
	String ADDRESSLINE;
	byte RESULTCOUNT;

}

class GeoResponse {

	byte STATUS;
	byte COUNT;
	String PROVINCE;
	String CITY;
	String DISTRICT;
	byte TYPE;
	byte CONFIDENT;
	String FROMATADDRESS;
	double LONGITUDE;
	double LATITUDE;

}

class Element {
	byte optional;
	byte len;
	byte[] value;
}

