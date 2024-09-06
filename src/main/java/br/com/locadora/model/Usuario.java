package br.com.locadora.model;
import javax.persistence.*; 

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String nome; 
    private String enderecoCep; 
    private String enderecoRua; 
    private String enderecoBairro; 
    private String enderecoCidade; 
    private String enderecoEstado; 
    private String telefone;    
    private String email;
    private String senha;
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEnderecoCep() {
        return enderecoCep;
    }
    public void setEnderecoCep(String enderecoCep) {
        this.enderecoCep = enderecoCep;
    }
    public String getEnderecoRua() {
        return enderecoRua;
    }
    public void setEnderecoRua(String enderecoRua) {
        this.enderecoRua = enderecoRua;
    }
    public String getEnderecoBairro() {
        return enderecoBairro;
    }
    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }
    public String getEnderecoCidade() {
        return enderecoCidade;
    }
    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }
    public String getEnderecoEstado() {
        return enderecoEstado;
    }
    public void setEnderecoEstado(String enderecoEstado) {
        this.enderecoEstado = enderecoEstado;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    } 




}
