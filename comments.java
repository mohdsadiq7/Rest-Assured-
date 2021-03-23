import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class comments {
    @Test
    void commentdata() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
        RequestSpecification vari = RestAssured.given();
        Response res = vari.request(Method.GET, "/1/comments");
        String resbody = res.getBody().asString();
        //System.out.println(resbody);
        JsonPath j = res.jsonPath();
        ArrayList a = j.get();
        for(var i : a)
        {
            var l = (HashMap)i;
            System.out.println("-----------------------------------------");
            System.out.println("Post Id : " + l.get("postId"));
            System.out.println("ID : " + l.get("id"));
            System.out.println("Name : " + l.get("name"));
            System.out.println("Email : " + l.get("email"));
            System.out.println("Body : " + l.get("body"));
            System.out.println("-----------------------------------------");
        }
    }
}
