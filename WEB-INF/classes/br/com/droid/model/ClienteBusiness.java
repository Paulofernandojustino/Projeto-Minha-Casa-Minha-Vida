package br.com.droid.model;

import java.util.ArrayList;
import br.com.droid.dao.ClienteDAO;

public class ClienteBusiness {

    public ArrayList<Cliente> buscarTodos() {
     ClienteDAO clienteDAO = new ClienteDAO();
     return clienteDAO.buscarTodos();
    }
    
    public String inserir(Cliente cliente) {

     ClienteDAO clienteDAO = new ClienteDAO();
     if(clienteDAO.inserir(cliente) > 0){
         return "Cliente inserido no banco com sucesso!";
     } else {
         return "Falha ao inserir o cliente no banco!";
     }
    }
    
    public String deletar(int id) {
     ClienteDAO clienteDAO = new ClienteDAO();
     if(clienteDAO.deletar(id) > 0){
         return "Cliente removido no banco com sucesso!";
     } else {
         return "Cliente não existe!";
     }
    }
    
    public Cliente buscar(int id) {
     ClienteDAO clienteDAO = new ClienteDAO();
     return clienteDAO.buscar(id);
    }
    
    public String inserirLista(ArrayList<Cliente> listaClientes) {
     ClienteDAO clienteDAO = new ClienteDAO();
     String retorno = "";
     for (int i = 0; i < listaClientes.size(); i++) {
         if(clienteDAO.inserir(listaClientes.get(i)) < 1){
             retorno += "Erro ao inserir o cliente de CPF: "+ listaClientes.get(i).getCpf() +"\n";
         }
     }
     if(retorno.length() == 0){
         retorno = "Lista de clientes inserida no banco com sucesso!";
     }
     return retorno;
    }
}