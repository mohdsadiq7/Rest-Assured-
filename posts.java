import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashMap;
public class posts {
    @Test
    void postdata() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification vari = RestAssured.given();
        Response res = vari.request(Method.GET, "/posts");
        String resbody = res.getBody().asString();
        //System.out.println(resbody);
        JsonPath j = res.jsonPath();
        ArrayList a = j.get();
        for (int i = 0; i < a.size(); i++) {
            var l = (HashMap)a.get(i);
            System.out.println("-----------------------------------------");
            System.out.println("User Id : " + l.get("userId"));
            System.out.println("ID : " + l.get("userId"));
            System.out.println("Title : " + l.get("title"));
            System.out.println("Body : " + l.get("body"));
            System.out.println("-----------------------------------------");
        }
    }
}
