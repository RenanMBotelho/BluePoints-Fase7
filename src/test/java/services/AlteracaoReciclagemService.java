package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.ReciclagemModel;

import static io.restassured.RestAssured.given;

public class AlteracaoReciclagemService {

    final ReciclagemModel reciclagemModel = new ReciclagemModel();
    public final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    public Response response;
    String baseUrl = "http://localhost:8080";

    public void setFieldsDelivery(String field, String value) {
        switch (field) {
            case "id"       -> reciclagemModel.setId(Integer.parseInt(value));
            case "usuario"  -> reciclagemModel.setUsuario(Integer.parseInt(value));
            case "local"    -> reciclagemModel.setLocal(value);
            case "data"     -> reciclagemModel.setData(value);
            case "peso"     -> reciclagemModel.setPeso(Integer.parseInt(value));
            default -> throw new IllegalStateException("Unexpected feld" + field);
        }
    }

    public void createDelivery(String endPoint) {
        String url = baseUrl + endPoint;
        String bodyToSend = gson.toJson(reciclagemModel);
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(bodyToSend)
                .when()
                .put(url)
                .then()
                .extract()
                .response();
    }

}