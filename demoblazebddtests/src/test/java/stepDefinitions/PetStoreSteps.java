package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import utils.Constants;
import utils.Status;
import utils.Pet;
import utils.Category;
import utils.Tag;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PetStoreSteps {
    private static RequestSpecification requestSpecification;
    public static Response response;
    public static String PHOTO_URL = "https://cdn.pixabay.com/photo/2015/03/26/09/54/pug-690566_960_720.jpg";
    @Given("^get all the Pets by status$")
    public void getPetByStatus() {
        RestAssured.baseURI = Constants.BASE_URL;
        requestSpecification = RestAssured.given();
        response = requestSpecification.header("accept", "application/json")
                .queryParam("status", Status.AVAILABLE)
                .when()
                .get(Constants.PET_ENDPOINT + "/findByStatus");
        response.then().log().all();
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
    }
@When("^the user adds a new Pet$")
    public void addNewPet() {
        Map<String, String> headerParams = new HashMap<>();
        headerParams.put("Content-Type", "application/json");
        headerParams.put("accept", "application/json");
        Pet pet = new Pet.Builder()
            .withId(RandomStringUtils.randomNumeric(8))
            .withName(RandomStringUtils.randomAlphabetic(5))
            .withPhotoUrls(PHOTO_URL)
            .withStatus(Status.AVAILABLE)
            .withTags(Collections.singletonList(new Tag(1, "golden-retriever")))
            .inCategory(new Category(1, "dogs")).build();
        System.out.println(pet);
        requestSpecification = RestAssured.given();
        response = requestSpecification.headers(headerParams).body(pet).post(Constants.PET_ENDPOINT);
        response.then().log().all();
    }
}

