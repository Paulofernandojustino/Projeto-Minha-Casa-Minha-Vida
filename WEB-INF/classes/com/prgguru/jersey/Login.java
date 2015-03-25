package com.prgguru.jersey;
 
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.droid.Banco;
import br.com.droid.model.Cliente;
import br.com.droid.model.ClienteBusiness;
//Path: http://localhost/<appln-folder-name>/login
@Path("/login")
public class Login {
    // HTTP Get Method
    @GET
    // Path: http://localhost/<appln-folder-name>/login/dologin
    @Path("/dologin")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost/<appln-folder-name>/login/dologin?username=abc&password=xyz
    public String doLogin(@QueryParam("username") String uname, @QueryParam("password") String pwd){
        String response = "";
        if(checkCredentials(uname, pwd)){
            response = Utility.constructJSON("login",true);
        }else{
            response = Utility.constructJSON("login", false, "Incorrect Email or Password");
        }
    return response;        
    }
 
    /**
     * Method to check whether the entered credential is valid
     * 
     * @param uname
     * @param pwd
     * @return
     */
    private boolean checkCredentials(String uname, String pwd){
        System.out.println("Inside checkCredentials");
        boolean result = false;
        if(Utility.isNotNull(uname) && Utility.isNotNull(pwd)){
            try {
                result = DBConnection.checkLogin(uname, pwd);
                //System.out.println("Inside checkCredentials try "+result);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                //System.out.println("Inside checkCredentials catch");
                result = false;
            }
        }else{
            //System.out.println("Inside checkCredentials else");
            result = false;
        }
 
        return result;
    }
    
    @GET
    @Path("/buscarTodos")
    @Produces("application/json")
    public ArrayList<Cliente> selTodos(){
     return new ClienteBusiness().buscarTodos();
    }
    
    
 
}