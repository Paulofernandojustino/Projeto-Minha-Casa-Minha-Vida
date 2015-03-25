package br.com.droid;

import java.util.ArrayList;
import br.com.droid.model.Cliente;

public class Banco {

    private static Banco instance;
    private ArrayList<Cliente> listaClientes;
    private int idCliente;
    
    private Banco() {
     idCliente = 1;
     listaClientes = new ArrayList<Cliente>();
     Cliente cliente = new Cliente();
     cliente.setCpf("111222333-00");
     cliente.setNome("Alexandre Antunes");
     cliente.setEndereco("Rua das ruas, 9");
     inserir(cliente);
    }
    
    public static Banco getBancoInstance(){
     if(instance==null)
         instance = new Banco();
     return instance;
    }
    
    public ArrayList<Cliente> getListaClientes(){
     return listaClientes;
    }
    
    public String inserir(Cliente cliente){
     cliente.setId(idCliente++);
     listaClientes.add(cliente);
     return "Cliente inserido no banco com sucesso!";
    }
    
    public Cliente buscar(int id){
     Cliente cliente = null;
     for (int i = 0; i < listaClientes.size(); i++) {
         if (listaClientes.get(i).getId() == id){
             cliente = new Cliente();
             cliente = listaClientes.get(i);
             break;
         }
     }
     return cliente;
    }
    
    private int getPosition(int id) {
     int pos = -1;
     for (int i = 0; i < listaClientes.size(); i++) {
         if (listaClientes.get(i).getId() == id){
             pos = i;
         }
     }
     return pos;
    }
    
    public String delete(int id){
     Cliente cliente = buscar(id);
     int pos = getPosition(id);
     if(cliente == null || pos < 0){
         return "Cliente não encontrado!";
     } else {
         listaClientes.remove(pos);
         return "Cliente removido com sucesso!";
     }
         
    }
}