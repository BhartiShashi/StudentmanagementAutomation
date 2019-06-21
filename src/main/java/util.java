package main.java;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
//import jdk.nashorn.internal.ir.RuntimeNode;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

public class util {


    public static Response searchById(Long Id) throws JSONException {

        Response response = null;

        String url = Config.BASEURL + Id;
        response = get(url);

        System.out.println("response of api " + response.toString());
        return response;
    }


    public static Response searchByIdandName(Long Id, String Name) throws JSONException {

        Response response = null;

        String url = Config.BASEURL + "?id=" +Id +"&studentName=" +Name;
        response = get(url);

        System.out.println("response of api " + response.toString());
        return response;
    }

//    public static void deleteById(Long Id){
//
//        RestAssured.baseURI = "http://localhost:8080";
//        String url=Config.CBASEURL;
//        Response response = null;
//
//        try {
//            response = RestAssured.given()
//                    .contentType(ContentType.JSON)
//                    .delete("/delete/10");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//}







}