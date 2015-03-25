package br.com.droid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.droid.factory.ConnectionFactory;

import br.com.droid.model.Pinturas;

public class PinturasDAO extends ConnectionFactory{
	
	public int inserir(Pinturas pinturas) {
		Connection conn = null;
	    conn = getConnection();
	    int sucesso = 0;
	    
	    PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO "
                    + "pinturas (quadra, lote, empreiteira, pintor, dtInicial, dtFinal, textura," +
                    "pintura, porta, limpeza, problema) " 
            		+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            
            stmt.setInt(1, pinturas.getQuadra());
            stmt.setInt(2, pinturas.getLote());
            stmt.setString(3, pinturas.getEmpreiteira());
            stmt.setString(4, pinturas.getPintor());
            stmt.setString(5, pinturas.getDtInicial());
            stmt.setString(6, pinturas.getDtFinal());
            stmt.setString(7, pinturas.getTextura());
            stmt.setString(8, pinturas.getPintura());
            stmt.setString(9, pinturas.getPorta());
            stmt.setString(10, pinturas.getLimpeza());
            stmt.setString(11, pinturas.getProblema());
            
            System.out.println(stmt.toString());
            sucesso = stmt.executeUpdate();

            if (sucesso > 0) {
                System.out.println("Quadra INSERIDO!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERRO AO INSERIR QUADRA!");
        } finally {
            closeConnection(conn, stmt);
        }
	    
        return sucesso;
		
	}
	
	public int alterar(Pinturas pinturas) {

	     Connection conn = null;
	     conn = getConnection();
	     PreparedStatement stmt = null;
	     int sucesso = 0;
	     try {
	    	 
	         stmt = conn.prepareStatement("UPDATE pinturas " +
	         		"SET quadra=?, lote=?, empreiteira=?, pintor=?, dtInicial=?, dtFinal=?, textura=?," +
                    "pintura=?, porta=?, limpeza=?, problema=? WHERE _ID = ?");

	         stmt.setInt(1, pinturas.getQuadra());
             stmt.setInt(2, pinturas.getLote());
             stmt.setString(3, pinturas.getEmpreiteira());
             stmt.setString(4, pinturas.getPintor());
             stmt.setString(5, pinturas.getDtInicial());
             stmt.setString(6, pinturas.getDtFinal());
             stmt.setString(7, pinturas.getTextura());
             stmt.setString(8, pinturas.getPintura());
             stmt.setString(9, pinturas.getPorta());
             stmt.setString(10, pinturas.getLimpeza());
             stmt.setString(11, pinturas.getProblema());
	         stmt.setInt(12, pinturas.getId());
	         sucesso = stmt.executeUpdate();
	         
	         if (sucesso > 0) {
	             System.out.println("QUADRA ALTERADO!");
	         } else {
	             System.out.println("QUADRA NÃO EXISTE!");
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	         System.out.println("ERRO AO ALTERAR QUADRA!");
	     } finally {
	         closeConnection(conn, stmt);
	     }
	     return sucesso;
    }
	public Pinturas buscar(int id) {

	     Connection conn = null;
	     ResultSet resultSet = null;
	     PreparedStatement stmt = null;
	     conn = getConnection();
	     Pinturas pintura = null;
	     try {
	         stmt = conn.prepareStatement("SELECT * FROM PINTURAS WHERE ID = ?");
	         stmt.setInt(1, id);
	         resultSet = stmt.executeQuery();
	         while (resultSet.next()) {
	             pintura = new Pinturas();
	             pintura.setId(resultSet.getInt("id"));
	             pintura.setQuadra(resultSet.getInt("quadra"));
	             pintura.setLote(resultSet.getInt("lote"));
	             pintura.setEmpreiteira(resultSet.getString("empreiteira"));
	             pintura.setPintor(resultSet.getString("pintor"));
	             pintura.setDtInicial(resultSet.getString("dtInicial"));
	             pintura.setDtFinal(resultSet.getString("dtFinal"));
	             pintura.setTextura(resultSet.getString("textura"));
	             pintura.setPintura(resultSet.getString("pintura"));
	             pintura.setPorta(resultSet.getString("porta"));
	             pintura.setLimpeza(resultSet.getString("limpeza"));
	             pintura.setProblema(resultSet.getString("empreiteira"));
	             
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
	         closeConnection(conn, stmt, resultSet);
	     }
	     return pintura;
    }
	
	public ArrayList<Pinturas> buscarTodos() {

	     Connection conn = null;
	     ResultSet resultSet = null;
	     PreparedStatement stmt = null;
	     conn = getConnection();
	     ArrayList<Pinturas> listaPinturas = null;

	     try {

	         stmt = conn.prepareStatement("SELECT * FROM PINTURAS ORDER BY QUADRA, LOTE");
	         resultSet = stmt.executeQuery();
	         listaPinturas = new ArrayList<Pinturas>();

	         while (resultSet.next()) {
	        	 Pinturas pintura = new Pinturas();
	             pintura.setId(resultSet.getInt("_id"));
	             pintura.setQuadra(resultSet.getInt("quadra"));
	             pintura.setLote(resultSet.getInt("lote"));
	             pintura.setEmpreiteira(resultSet.getString("empreiteira"));
	             pintura.setPintor(resultSet.getString("pintor"));
	             pintura.setDtInicial(resultSet.getString("dtInicial"));
	             pintura.setDtFinal(resultSet.getString("dtFinal"));
	             pintura.setTextura(resultSet.getString("textura"));
	             pintura.setPintura(resultSet.getString("pintura"));
	             pintura.setPorta(resultSet.getString("porta"));
	             pintura.setLimpeza(resultSet.getString("limpeza"));
	             pintura.setProblema(resultSet.getString("problema"));
	             listaPinturas.add(pintura);
	         }

	     } catch (SQLException e) {
	         e.printStackTrace();
	         listaPinturas = null;
	     } finally {
	         closeConnection(conn, stmt, resultSet);
	     }
	     return listaPinturas;
    }
	

	     

}
