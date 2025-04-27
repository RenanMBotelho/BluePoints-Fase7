package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import model.ErrorMessageModel;
import org.junit.Assert;
import services.CadastroReciclagemService;

import java.util.List;
import java.util.Map;

public class CadastroReciclagemSteps {
    CadastroReciclagemService cadastroReciclagemService = new CadastroReciclagemService();
    @Dado("que eu tenha os seguintes dados da reciclagem:")
    public void queEuTenhaOsSeguintesDadosDaReciclagem(List<Map<String, String>> rows) {
        for(Map<String, String> columns : rows) {
            cadastroReciclagemService.setFieldsDelivery(columns.get("campo"),  columns.get("valor"));
        }
    }
    @Quando("eu enviar a requisição para o endpoint {string} de cadastro de reciclagem")
    public void euEnviarARequisicaoParaOEndpointDeCadastroDeReciclagem(String endPoint) {
        cadastroReciclagemService.createDelivery(endPoint);
    }
    @Então("o status code da resposta deve ser {int}")
    public void oStatusDaRespostaDeveSer(int statusCode) {
        Assert.assertEquals(statusCode, cadastroReciclagemService.response.statusCode());
    }

    @E("o corpo de resposta de erro da api deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDaApiDeveRetornarAMensagem(String message) {
        ErrorMessageModel errorMessageModel = cadastroReciclagemService.gson.fromJson(
                cadastroReciclagemService.response.jsonPath().prettify(), ErrorMessageModel.class);
        Assert.assertEquals(message, errorMessageModel.getPeso());
    }
}
