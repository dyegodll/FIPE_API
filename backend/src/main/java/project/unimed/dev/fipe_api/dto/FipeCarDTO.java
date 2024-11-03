package project.unimed.dev.fipe_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import project.unimed.dev.fipe_api.entity.FipeCar;

import java.io.Serializable;

public class FipeCarDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Campo Obrigatório!")
    @Positive(message = "O preço deve ser um valor Positivo")
    private Double valor;

    @NotBlank(message = "Campo Obrigatório!")
    private String marca;

    @Size(min=5, max=60, message="Campo deve ter entre 5 e 60 caracteres")
    @NotBlank(message = "Campo Obrigatório!")

    @NotBlank(message = "Campo Obrigatório!")
    private String modelo;

    @NotBlank(message = "Campo Obrigatório!")
    private Integer anoModelo;

    @NotBlank(message = "Campo Obrigatório!")
    private String codigoFipe;

    public FipeCarDTO(FipeCar entity) {
        this.id = entity.getId();
        this.valor = entity.getValor();
        this.marca = entity.getMarca();
        this.modelo = entity.getModelo();
        this.anoModelo = entity.getAnoModelo();
        this.codigoFipe = entity.getCodigoFipe();
    }

    public FipeCarDTO(Long id, Double valor, String marca, String modelo, Integer anoModelo, String codigoFipe) {
        this.id = id;
        this.valor = valor;
        this.marca = marca;
        this.modelo = modelo;
        this.anoModelo = anoModelo;
        this.codigoFipe = codigoFipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }
}
