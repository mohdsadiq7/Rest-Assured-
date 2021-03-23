import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class users {
    @Test
    void userdata(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        RequestSpecification vari = RestAssured.given();
        Response res = vari.request(Method.GET,"/users");
        String resbody = res.getBody().asString();
        //System.out.println(resbody);
        JsonPath jp = res.jsonPath();
        ArrayList a = jp.get();
        for(int k=0; k < a.size(); k++)
        {
            var l = (HashMap) a.get(k);
            System.out.println("-----------------------------------------");
            System.out.println("ID : "+l.get("id"));
            System.out.println("Name : "+l.get("name"));
            System.out.println("Username : "+l.get("username"));
            System.out.println("Email id : "+l.get("email"));

            HashMap address = (HashMap) l.get("address");
            System.out.println("street : "+address.get("street"));
            System.out.println("suite : "+address.get("suite"));
            System.out.println("city : "+address.get("city"));
            System.out.println("zipcode : "+address.get("zipcode"));

            HashMap coordinates = (HashMap) address.get("geo");
            System.out.println("Latitude :" +coordinates.get("lat"));
            System.out.println("Latitude :" +coordinates.get("lng"));

            System.out.println("Phone Number : "+l.get("phone"));
            System.out.println("Website : "+l.get("website"));

            HashMap company = (HashMap) l.get("company");
            System.out.println("Company Name : "+company.get("name"));
            System.out.println("Catch Phrase : "+company.get("catchPhrase"));
            System.out.println("BS : "+company.get("bs"));
            System.out.println("--------------------------------------------------");
        }
    }
}