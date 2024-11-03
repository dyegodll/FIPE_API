package project.unimed.dev.fipe_api.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="fipe_car")
public class FipeCar implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Double valor;
    private String marca;

    @Column(columnDefinition = "TEXT")
    private String modelo;

    private Integer anoModelo;
    private String combustivel;
    private String codigoFipe;

    public FipeCar() {
    }

    public FipeCar(Long id, Double valor, String marca, Integer anoModelo, String modelo, String combustivel, String codigoFipe) {
        this.id = id;
        this.valor = valor;
        this.marca = marca;
        this.anoModelo = anoModelo;
        this.modelo = modelo;
        this.combustivel = combustivel;
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

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FipeCar fipeCar = (FipeCar) o;
        return Objects.equals(id, fipeCar.id) && Objects.equals(valor, fipeCar.valor) && Objects.equals(marca, fipeCar.marca) && Objects.equals(modelo, fipeCar.modelo) && Objects.equals(anoModelo, fipeCar.anoModelo) && Objects.equals(combustivel, fipeCar.combustivel) && Objects.equals(codigoFipe, fipeCar.codigoFipe);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "FipeCar{" +
                "id=" + id +
                ", valor=" + valor +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoModelo=" + anoModelo +
                ", combustivel='" + combustivel + '\'' +
                ", codigoFipe='" + codigoFipe + '\'' +
                '}';
    }
}