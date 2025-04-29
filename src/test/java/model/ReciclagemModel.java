package model;
import com.google.gson.annotations.Expose;
import lombok.Data;
@Data
public class ReciclagemModel {
    @Expose//(serialize = false)
    private int id;
    @Expose
    private int usuario;
    @Expose
    private String local;
    @Expose
    private String data;
    @Expose
    private int peso;
}