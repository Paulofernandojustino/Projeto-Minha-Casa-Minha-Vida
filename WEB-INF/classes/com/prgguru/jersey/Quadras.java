package com.prgguru.jersey;
 
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import br.com.droid.model.Pinturas;
import br.com.droid.model.PinturasBusiness;
//Path: http://localhost/<appln-folder-name>/login
@Path("/quadras")
public class Quadras {
	
	@GET
    @Path("/buscarTodos")
    @Produces("application/json")
    public ArrayList<Pinturas> selTodos(){
     return new PinturasBusiness().buscarTodos();
    }
	
	// HTTP Get Method
    @GET
    // Path: http://localhost/<appln-folder-name>/register/doregister
    @Path("/adds")  
    // Produces JSON as response
    @Produces("application/json") 
    // Query parameters are parameters: http://localhost/<appln-folder-name>/quadra/add?quadra=pqrs&lote=abc&empreiteira=xyz
    public String doLogin(@QueryParam("quadra") Integer quadra, @QueryParam("lote") Integer lote, @QueryParam("empreiteira") String empreita){
    	String response = "";
    	Pinturas pintura = new Pinturas();
        pintura.setQuadra(quadra);
        pintura.setLote(lote);
        pintura.setEmpreiteira(empreita);
        pintura.setPintor("");
        pintura.setDtInicial("");
        pintura.setDtFinal("");
        pintura.setTextura("");
        pintura.setPintura("");
        pintura.setLimpeza("");
        pintura.setProblema("");
        pintura.setPorta("");
        String resp = new PinturasBusiness().inserir(pintura);
        response = Utility.constructJSON("register "+resp,true);
        return response;
    }
    
    
    @GET
    // Path: http://localhost/<appln-folder-name>/register/doregister
    @Path("/update")  
    // Produces JSON as response
    @Produces("application/json") 
    // Query parameters are parameters: http://localhost/<appln-folder-name>/quadras/update?id=pqrs&quadra=pqrs&lote=abc&empreiteira=xyz
    public String doUpdate(@QueryParam("id") Integer id,@QueryParam("quadra") Integer quadra, @QueryParam("lote") Integer lote, @QueryParam("empreiteira") String empreita){
    	String response = "";
    	Pinturas pintura = new Pinturas();
    	pintura.setId(id);
        pintura.setQuadra(quadra);
        pintura.setLote(lote);
        pintura.setEmpreiteira(empreita);
        pintura.setPintor("");
        pintura.setDtInicial("");
        pintura.setDtFinal("");
        pintura.setTextura("");
        pintura.setPintura("");
        pintura.setLimpeza("");
        pintura.setProblema("");
        pintura.setPorta("");
        String resp = new PinturasBusiness().alterar(pintura);
        response = Utility.constructJSON("register "+resp,true);
        return response;
    }
    

}
