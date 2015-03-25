package br.com.droid.resources;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.google.gson.Gson;
import br.com.droid.Banco;
import br.com.droid.exception.NoContentException;
import br.com.droid.model.Cliente;

@Path("/cliente")
public class ClienteResource {
    
    @GET
    @Path("/buscarTodos")
    @Produces("application/json")
    public ArrayList<Cliente> selTodos(){
     return Banco.getBancoInstance().getListaClientes();
    }

    @GET
    @Path("/buscarTodosGSON")
    @Produces("application/json")
    public String selTodosGSON(){
     return new Gson().toJson(Banco.getBancoInstance().getListaClientes());
    }
    
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Cliente getCliente(@PathParam("id") int id){
     Cliente cliente = Banco.getBancoInstance().buscar(id);
     
     if(cliente == null)
         throw new NoContentException("Cliente não encontrado!");
     
     return cliente;
    }
    
    @GET
    @Path("/delete/{id}")
    @Produces("application/json")
    public String deleteCliente(@PathParam("id") int id){
     return Banco.getBancoInstance().delete(id);
    }
    
    @POST
    @Path("/inserir")
    @Produces("application/json")
    @Consumes("application/json")
    public String inserirCliente(Cliente cliente) {
     return Banco.getBancoInstance().inserir(cliente);
    }
}