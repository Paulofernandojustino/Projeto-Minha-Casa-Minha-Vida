package br.com.droid.model;

import java.util.ArrayList;


import br.com.droid.dao.ClienteDAO;
import br.com.droid.dao.PinturasDAO;


public class PinturasBusiness {
	
	public ArrayList<Pinturas> buscarTodos() {
	     PinturasDAO pinturaDAO = new PinturasDAO();
	     return pinturaDAO.buscarTodos();
    }
	
	public String inserir(Pinturas pintura) {

	     PinturasDAO pinturasDAO = new PinturasDAO();
	     if(pinturasDAO.inserir(pintura) > 0){
	         return "Cliente inserido no banco com sucesso!";
	     } else {
	         return "Falha ao inserir o cliente no banco!";
	     }
    }
	
	public String alterar(Pinturas pintura)
	{
		PinturasDAO pinturasDAO = new PinturasDAO();
		if(pinturasDAO.alterar(pintura) > 0){
	         return "Cliente atualizado no banco com sucesso!";
	     } else {
	         return "Falha ao inserir o cliente no banco!";
	     }
		
	}
	
	public Pinturas buscar(int id) {
		PinturasDAO pinturasDAO = new PinturasDAO();
	     return pinturasDAO.buscar(id);
    }
	
	public String inserirLista(ArrayList<Pinturas> listaPinturas) {
		PinturasDAO pinturasDAO = new PinturasDAO();
	     String retorno = "";
	     for (int i = 0; i < listaPinturas.size(); i++) {
	         if(pinturasDAO.inserir(listaPinturas.get(i)) < 1){
	             retorno += "Erro ao inserir a QUADRA: "+ listaPinturas.get(i).getQuadra().toString() +"\n";
	         }
	     }
	     if(retorno.length() == 0){
	         retorno = "Lista de quadras inserida no banco com sucesso!";
	     }
	     return retorno;
	    }

}
