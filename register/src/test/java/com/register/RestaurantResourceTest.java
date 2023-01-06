package com.register;

import com.github.database.rider.cdi.api.DBRider;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response.Status;

import static io.restassured.RestAssured.given;


@DBRider
//@DBUnit(caseInsensitiveStrategy=Orthography.LOWERCASE)
@QuarkusTest
@QuarkusTestResource(RegisterTestLifecycleManager.class)
public class RestaurantResourceTest {

    @Test
   // @DataSet("restaurants-cenario-1.yml")
    public void testGETRestaurantes() {
        String resultado = given()
                .when().get("/restaurant")
                .then()
                .statusCode(Status.OK.getStatusCode())
                .extract().asString();
     //   Approvals.verifyJson(resultado);
    }




}
