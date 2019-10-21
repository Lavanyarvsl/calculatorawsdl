package sample.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class post_xml_test2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/* String ROOT_URI = "http://www.dneonline.com/calculator.asmx";
		
		 Response response = given().
					contentType(ContentType.XML)
					.accept(ContentType.XML)
					.body("<wsdl:Add>\n" + 
							"	<intA>50</intA>\n" + 
							"	<intB>5</intB>\n" + 
							"</wsdl:Add>")
					.when()
					.post(ROOT_URI);
		 System.out.println("My  Response Value::\n" + response);
			System.out.println("POST Response\n" + response.asString());
		*/
		
		FileInputStream fileInputStream = new FileInputStream(new File(".\\SOAPRequest\\SoapRequestFile.xml"));
        RestAssured.baseURI="http://www.dneonline.com";

        Response response=given()
               .header("Content-Type", "text/xml")
               .and()
               .body(IOUtils.toString(fileInputStream,"UTF-8"))
        .when()
           .post("/calculator.asmx")
        .then()
               .statusCode(200)
               .and()
               .log().all()
               .extract().response();
        
        System.out.println("Response::"+response.asString());
        
        FileWriter fileWriter = new FileWriter(".\\SOAPRequest\\SoapResFile.xml");
        fileWriter.write(response.asString());
        fileWriter.close();
	}

}
