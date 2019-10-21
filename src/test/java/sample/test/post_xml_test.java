package sample.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.util.IOUtils;
import io.restassured.response.Response;
import javax.ws.rs.core.MediaType;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
public class post_xml_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 String ROOT_URI = "http://www.dneonline.com/calculator.asmx";
		
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
		
		
		/*FileInputStream fileInputStream = new FileInputStream(new File(".\\SOAPRequest\\SoapRequestFile.xml"));
        RestAssured.baseURI="http://currencyconverter.kowabunga.net";

        Response response=given()
               .header("Content-Type", "text/xml")
               .and()
               .body(IOUtils.toString(fileInputStream,"UTF-8"))
        .when()
           .post("/converter.asmx")
        .then()
               .statusCode(200)
               .and()
               .log().all()
               .extract().response();*/
	}

}
