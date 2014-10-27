package amazon;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by ray on 10/18/14.
 */

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

class Request{
    Long ID;
    String PROV; //optional
    String CITY;
    String ADDRESS;
    byte count;

    public byte[] encode() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        //ID;
        out.write(ID.toString().getBytes().length);
        out.write(ID.toString().getBytes());

        //PROV
        out.write(PROV.isEmpty()?0:PROV.length());
        if(!PROV.isEmpty()){
            out.write(PROV.getBytes());
        }

        //CITY
        out.write(CITY.getBytes().length);
        out.write(CITY.getBytes());

        //Address
        out.write(ADDRESS.getBytes().length);
        out.write(ADDRESS.getBytes());

        //ccount
        out.write(1);
        out.write(count);

        return out.toByteArray();

    }
}


class Response {

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


    public void decode(byte[] data){
        try{
            ByteArrayInputStream  in = new ByteArrayInputStream(data);

            //Status
            int len;
            len =  in.read();
            if (len == -1)return;
            byte[] value = new byte[len];
            in.read(value);
            STATUS = value[0];

            //Count
            len =  in.read();
            value = new byte[len];
            in.read(value);
            COUNT = value[0];

            //prov
            len = in.read();
            value = new byte[len];
            in.read(value);
            PROVINCE = Arrays.toString(value);

            //prov
            len = in.read();
            value = new byte[len];
            in.read(value);
            PROVINCE = Arrays.toString(value);


        }catch(IOException e){
            return;
        }



    }
}

public class GeoCoder {

    public static void main(String[] args) throws IOException {
        Request rq = new Request();
        rq.ID = 123L;
        rq.PROV = "Beijing";
        rq.CITY = "Bj";
        rq.ADDRESS = "Wangjing No.2";
        rq.count = 1;
        System.out.print(Arrays.toString(rq.encode()));
    }

}
