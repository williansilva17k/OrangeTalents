package com.desafio.OrangeTalents.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
Montado com a ajuda de:
https://www.jsonschema2pojo.org/
e
StackOverflow
 */
@JsonPropertyOrder({
        "Valor",
        "Marca",
        "Modelo",
        "AnoModelo",
        "Combustivel",
        "CodigoFipe",
        "MesReferencia",
        "TipoVeiculo",
        "SiglaCombustivel",
        "Rodizio dia",
        "Rodizio"
})


@Entity(name = "Vehicle")
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Campo nome não pode ser nulo")
    @Column(name = "valor", nullable = false, length = 50)
    @JsonProperty("Valor")
    private String valor;

    @NotNull(message = "Campo nome não pode ser nulo")
    @Column(name = "marca", nullable = false, length = 50)
    @JsonProperty("Marca")
    private String marca;

    @NotNull(message = "Campo nome não pode ser nulo")
    @Column(name = "modelo", nullable = false, length = 50)
    @JsonProperty("Modelo")
    private String modelo;

    @NotNull(message = "Campo nome não pode ser nulo")
    @Column(name = "anoModelo", nullable = false)
    @JsonProperty("AnoModelo")
    private Integer anoModelo;

    @NotNull(message = "Campo nome não pode ser nulo")
    @Column(name = "combustivel", nullable = false, length = 50)
    @JsonProperty("Combustivel")
    private String combustivel;

    @NotNull(message = "Campo nome não pode ser nulo")
    @Column(name = "codigoFipe", nullable = false, length = 50)
    @JsonProperty("CodigoFipe")
    private String codigoFipe;

    @NotNull(message = "Campo nome não pode ser nulo")
    @Column(name = "mesReferencia", nullable = false, length = 50)
    @JsonProperty("MesReferencia")
    private String mesReferencia;

    @NotNull(message = "Campo nome não pode ser nulo")
    @Column(name = "tipoVeiculo", nullable = false)
    @JsonProperty("TipoVeiculo")
    private Integer tipoVeiculo;

    @NotNull(message = "Campo nome não pode ser nulo")
    @Column(name = "siglaCombustivel", nullable = false, length = 50)
    @JsonProperty("SiglaCombustivel")
    private String siglaCombustivel;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonIgnore
    @Column(name = "day_of_week", nullable = false)
    private Integer day_of_week;

    @Transient
    @JsonProperty("Rodizio")
    private Boolean rotation = false;

    public Vehicle() {
    }

    public Vehicle(Long id, String valor, String marca,
                   String modelo, Integer anoModelo, String combustivel,
                   String codigoFipe, String mesReferencia, Integer tipoVeiculo,
                   String siglaCombustivel, User user, Integer day_of_week, Boolean rotation) {
        this.id = id;
        this.valor = valor;
        this.marca = marca;
        this.modelo = modelo;
        this.anoModelo = anoModelo;
        this.combustivel = combustivel;
        this.codigoFipe = codigoFipe;
        this.mesReferencia = mesReferencia;
        this.tipoVeiculo = tipoVeiculo;
        this.siglaCombustivel = siglaCombustivel;
        this.user = user;
        this.day_of_week = day_of_week;
        this.rotation = rotation;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
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

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public Integer getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(Integer tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getSiglaCombustivel() {
        return siglaCombustivel;
    }

    public void setSiglaCombustivel(String siglaCombustivel) {
        this.siglaCombustivel = siglaCombustivel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(Integer day_of_week) {
        this.day_of_week = day_of_week;
    }

    public Boolean getRotation() {
        return rotation;
    }

    public void setRotation(Boolean rotation) {
        this.rotation = rotation;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", valor='" + valor + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoModelo=" + anoModelo +
                ", combustivel='" + combustivel + '\'' +
                ", codigoFipe='" + codigoFipe + '\'' +
                ", mesReferencia='" + mesReferencia + '\'' +
                ", tipoVeiculo=" + tipoVeiculo +
                ", siglaCombustivel='" + siglaCombustivel + '\'' +
                ", user=" + user +
                ", day_of_week=" + day_of_week +
                ", rotation=" + rotation +
                '}';
    }
}
