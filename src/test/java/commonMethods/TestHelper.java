package commonMethods;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ArrayList;



/**
 * Created by obaskirt on 22-Jan-18.
 */
public class TestHelper {

    //Verify the http response status returned. Check Status Code is 200?
    public static void checkStatusIs200 (Response res) {
        Assert.assertEquals(res.getStatusCode(),200, "Status Check is OK!");
    }

    //Get Clients
    public ArrayList getClients (JsonPath jp) {
        ArrayList clientList = jp.get();
        return clientList;
    }
}
