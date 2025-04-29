package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import model.ErrorMessageModel;
import org.junit.Assert;
import services.AlteracaoReciclagemService;

import java.util.List;
import java.util.Map;

public class AlteracaoReciclagemSteps {

    AlteracaoReciclagemService alteracaoReciclagemService = new AlteracaoReciclagemService();

    @Dado("que eu tenha os seguintes dados da reciclagem para alteração:")
    public void queEuTenhaOsSeguintesDadosDaReciclagemParaAlteração(List<Map<String, String>> rows) {
        for(Map<String, String> columns : rows) {
            alteracaoReciclagemService.setFieldsDelivery(columns.get("campo"),  columns.get("valor"));
        }
    }
    @Quando("eu enviar a requisição para o endpoint {string} de alteração de reciclagem")
    public void euEnviarARequisiçãoParaOEndpointDeAlteraçãoDeReciclagem(String endPoint) {
        alteracaoReciclagemService.createDelivery(endPoint);
    }

    @Então("o status code da resposta de alteração deve ser {int}")
    public void oStatusCodeDaRespostaDeAlteraçãoDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, alteracaoReciclagemService.response.statusCode());
    }

    @E("o corpo de resposta de erro da api de alteração deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDaApiDeAlteraçãoDeveRetornarAMensagem(String message) {
        ErrorMessageModel errorMessageModel = alteracaoReciclagemService.gson.fromJson(
                alteracaoReciclagemService.response.jsonPath().prettify(), ErrorMessageModel.class);
        Assert.assertEquals(message, errorMessageModel.getMessage());
    }
}
