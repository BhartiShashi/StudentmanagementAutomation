package test;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.mapper.ObjectMapper;
import com.jayway.restassured.mapper.ObjectMapperDeserializationContext;
import com.jayway.restassured.mapper.ObjectMapperSerializationContext;
import com.jayway.restassured.response.Response;
import main.java.Base;
import main.java.Config;
import main.java.util;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.jsoup.nodes.Entities.EscapeMode.base;


public class apiTest extends Base {

//    @Test
//    public void create() throws JSONException {
//
//        String Id= Config.IDS;
//        String Name=Config.STUDENTNAME;
//        String roll=Config.Roll;
//        System.out.println("Id is"+Id);
//
//        Response response= util.create(Long.parseLong(Id), Name,Long.parseLong(roll));
//        System.out.println(response.getStatusCode());
//        Assert.assertTrue(response.getStatusCode()==200);
//        JSONObject object=new JSONObject(response.asString());
//        System.out.println(object);
//    }


    @Test
    public void serchById() throws JSONException {

        String Id= Config.IDS;
        System.out.println("Id is"+Id);

        Response response= util.searchById(Long.parseLong(Id));
        System.out.println(response.getStatusCode());
        Assert.assertTrue(response.getStatusCode()==200);
        JSONObject object=new JSONObject(response.asString());
        System.out.println(object);
    }

    @Test
    public void serchByIdAndName() throws JSONException {

        String Id= Config.IDS;
        String Name=Config.STUDENTNAME;
        System.out.println("Id is"+Id);

        Response response= util.searchByIdandName(Long.parseLong(Id), Name);
        System.out.println(response.getStatusCode());
        Assert.assertTrue(response.getStatusCode()==200);
        JSONObject object=new JSONObject(response.asString());
        System.out.println(object);
    }

        @Test
        public void createNewStudent() {

            RestAssured.baseURI = "http://localhost:8080";

            String requestBody = "{\n" +
                    "  \"id\": \"13\",\n" +
                    "  \"name\": \"Bharti\",\n" +
                    "  \"roll\": \"24\"\n" +
                    "}";

            Response response = null;

            try {
                response = RestAssured.given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .post("/create");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Response :" + response.asString());
            System.out.println("Status Code :" + response.getStatusCode());
            //System.out.println("Does Reponse contains 'shashi'? :" + response.asString().contains("shashi"));
            Assert.assertTrue(response.getStatusCode()==200);

        }

    @Test
    public void deleteStudent() {

        RestAssured.baseURI = "http://localhost:8080";

        Response response = null;

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .delete("/delete/10");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());

    }

    //@Test
//   public void deleteStudent() {
//        String Id= Config.IDS;
//
//    }

    @Test
    public void updateStudent() {

        RestAssured.baseURI = "http://localhost:8080";

        Response response = null;

        String requestBody = "{\n" +
                "  \"id\": \"13\",\n" +
                "  \"name\": \"Bharti\",\n" +
                "  \"roll\": \"24\"\n" +
                "}";

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .put("/update/9");

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());

    }

}
