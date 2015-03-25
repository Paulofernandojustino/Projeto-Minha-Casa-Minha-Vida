package br.com.droid.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cliente {

    private int id;
    private String nome;
    private String cpf;
    private String endereco;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

// getters e setters    
    
    
}