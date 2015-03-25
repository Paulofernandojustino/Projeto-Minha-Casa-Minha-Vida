package br.com.droid.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pinturas {
	

	private Integer id, quadra, lote;
	private String empreiteira, pintor, dtInicial, dtFinal, textura, pintura, porta, limpeza, problema;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getQuadra() {
		return quadra;
	}
	public void setQuadra(Integer quadra) {
		this.quadra = quadra;
	}
	public Integer getLote() {
		return lote;
	}
	public void setLote(Integer lote) {
		this.lote = lote;
	}
	public String getEmpreiteira() {
		return empreiteira;
	}
	public void setEmpreiteira(String empreiteira) {
		this.empreiteira = empreiteira;
	}
	public String getPintor() {
		return pintor;
	}
	public void setPintor(String pintor) {
		this.pintor = pintor;
	}
	public String getDtInicial() {
		return dtInicial;
	}
	public void setDtInicial(String dtInicial) {
		this.dtInicial = dtInicial;
	}
	public String getDtFinal() {
		return dtFinal;
	}
	public void setDtFinal(String dtFinal) {
		this.dtFinal = dtFinal;
	}
	public String getTextura() {
		return textura;
	}
	public void setTextura(String textura) {
		this.textura = textura;
	}
	public String getPintura() {
		return pintura;
	}
	public void setPintura(String pintura) {
		this.pintura = pintura;
	}
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}
	public String getLimpeza() {
		return limpeza;
	}
	public void setLimpeza(String limpeza) {
		this.limpeza = limpeza;
	}
	public String getProblema() {
		return problema;
	}
	public void setProblema(String problema) {
		this.problema = problema;
	}
	
	

}
