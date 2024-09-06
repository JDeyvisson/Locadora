package br.com.locadora.model;
import javax.persistence.*; 


@Entity 
public class Veiculo { 

    @Id 
    @Column(length = 7) 
    private String placa; 

    private String marca; 
    private String modelo; 
    private Integer ano; 
    private String cor;
    
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
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
    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    } 

    



}
