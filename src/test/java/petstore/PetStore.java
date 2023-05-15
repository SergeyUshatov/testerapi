package petstore;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.sergius.testerapi.RequestProcessor;

public class PetStore {
    public Pet addPet(Pet pet) {
        //could be extracted to a class with default request specs, e.g. for specified:
        // default cookies, headers and so on.
        RequestSpecification newPetSpec = new RequestSpecBuilder()
                .addHeader("myHeader", "myHeaderValue")
                .build();

        //could be extracted to a class with default response specs, e.g. for every status:
        // OK, BAD REQUEST, UNAUTHORIZED and so on.
        ResponseSpecification defaultResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_CREATED)
                .build();
        return new RequestProcessor()
                .sendPost("myAwesomeUrl", pet, newPetSpec, defaultResponseSpec)
                .extractResponseAs(Pet.class);
    }
}
