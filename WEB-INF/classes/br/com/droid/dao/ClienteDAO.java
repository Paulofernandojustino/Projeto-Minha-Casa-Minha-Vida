package br.com.droid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.droid.factory.ConnectionFactory;
import br.com.droid.model.Cliente;

public class ClienteDAO extends ConnectionFactory {

    public int verificaCadastrado(String cpf) {

     int id = 0;
     Connection conn = null;
     ResultSet resultSet = null;
     PreparedStatement stmt = null;
     conn = getConnection();
     try {
         stmt = conn
                 .prepareStatement("SELECT ID FROM CLIENTE WHERE CPF = ?");
         stmt.setString(1, cpf);
         resultSet = stmt.executeQuery();
         if (resultSet.next()) {
             id = resultSet.getInt("id");
         }
     } catch (SQLException e) {
         e.printStackTrace();
     } finally {
         closeConnection(conn, stmt, resultSet);
     }
     return id;
    }

    public int inserir(Cliente cliente) {

     Connection conn = null;
     conn = getConnection();
     int sucesso = 0;
     int prodsCadastrados = verificaCadastrado(cliente.getCpf());

     if (prodsCadastrados == 0) {
         PreparedStatement stmt = null;
         try {
             stmt = conn.prepareStatement("INSERT INTO "
                     + "CLIENTE (NOME, CPF, ENDERECO) VALUES(?,?,?)");

             stmt.setString(1, cliente.getNome());
             stmt.setString(2, cliente.getCpf());
             stmt.setString(3, cliente.getEndereco());
             sucesso = stmt.executeUpdate();

             if (sucesso > 0) {
                 System.out.println("CLIENTE INSERIDO!");
             }

         } catch (SQLException e) {
             e.printStackTrace();
             System.out.println("ERRO AO INSERIR CLIENTE!");
         } finally {
             closeConnection(conn, stmt);
         }
     } else {
         System.out.println("ERRO: CLIENTE JA CADASTRADO");
         closeConnection(conn);
     }
     return sucesso;
    }

    public int alterar(Cliente cliente) {

     Connection conn = null;
     conn = getConnection();
     PreparedStatement stmt = null;
     int sucesso = 0;
     try {
         stmt = conn
                 .prepareStatement("UPDATE CLIENTE SET NOME = ?, SET CPF = ?, SET ENDERECO = ? WHERE ID = ?");

         stmt.setString(1, cliente.getNome());
         stmt.setString(2, cliente.getCpf());
         stmt.setString(3, cliente.getEndereco());
         stmt.setInt(4, cliente.getId());
         sucesso = stmt.executeUpdate();
         
         if (sucesso > 0) {
             System.out.println("CLIENTE ALTERADO!");
         } else {
             System.out.println("CLIENTE NÃO EXISTE!");
         }
     } catch (SQLException e) {
         e.printStackTrace();
         System.out.println("ERRO AO ALTERAR CLIENTE!");
     } finally {
         closeConnection(conn, stmt);
     }
     return sucesso;
    }

    public int deletar(int id) {

     Connection conn = null;
     conn = getConnection();
     int excluidos = 0;
     PreparedStatement stmt = null;
     try {
         stmt = conn.prepareStatement("DELETE FROM CLIENTE WHERE ID = ?");
         stmt.setInt(1, id);
         excluidos = stmt.executeUpdate();
         
         if (excluidos > 0) {
             System.out.println("CLIENTE REMOVIDO!");
         } else {
             System.out.println("CLIENTE NÃO EXISTE!");
         }

     } catch (SQLException e) {
         e.printStackTrace();
         System.out.println("ERRO AO DELETAR CLIENTE!");
     } finally {
         closeConnection(conn, stmt);
     }
     return excluidos;
    }

    public Cliente buscar(int id) {

     Connection conn = null;
     ResultSet resultSet = null;
     PreparedStatement stmt = null;
     conn = getConnection();
     Cliente cliente = null;
     try {
         stmt = conn.prepareStatement("SELECT * FROM CLIENTE WHERE ID = ?");
         stmt.setInt(1, id);
         resultSet = stmt.executeQuery();
         while (resultSet.next()) {
             cliente = new Cliente();
             cliente.setId(resultSet.getInt("id"));
             cliente.setNome(resultSet.getString("nome"));
             cliente.setCpf(resultSet.getString("cpf"));
             cliente.setEndereco(resultSet.getString("endereco"));
         }
     } catch (SQLException e) {
         e.printStackTrace();
     } finally {
         closeConnection(conn, stmt, resultSet);
     }
     return cliente;
    }

    public ArrayList<Cliente> buscarTodos() {

     Connection conn = null;
     ResultSet resultSet = null;
     PreparedStatement stmt = null;
     conn = getConnection();
     ArrayList<Cliente> listaClientes = null;

     try {

         stmt = conn.prepareStatement("SELECT * FROM CLIENTE ORDER BY ID");
         resultSet = stmt.executeQuery();
         listaClientes = new ArrayList<Cliente>();

         while (resultSet.next()) {
             Cliente cliente = new Cliente();
             cliente.setId(resultSet.getInt("id"));
             cliente.setNome(resultSet.getString("nome"));
             cliente.setCpf(resultSet.getString("cpf"));
             cliente.setEndereco(resultSet.getString("endereco"));
             listaClientes.add(cliente);
         }

     } catch (SQLException e) {
         e.printStackTrace();
         listaClientes = null;
     } finally {
         closeConnection(conn, stmt, resultSet);
     }
     return listaClientes;
    }
}