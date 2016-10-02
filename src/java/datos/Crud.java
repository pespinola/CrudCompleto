/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author Pathy
 */
public class Crud extends Conexion {
    
    private ResultSet rs;
    
    public Crud(){
        getConexion();
    }
    
    public boolean agregar(String nombre, int edad){
        try{
            String sql = "Insert into usuario (nombre, edad) values ('"+nombre+"', '"+edad+"')";
            st.executeUpdate(sql);
            return true;
        }catch(SQLException ex){
            System.out.println("Error al agregar "+ex.getMessage());
            return false;
        }
    }
    
     public ArrayList<Usuario> listarUsuarios(){
           
            ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
            
            try{
                String sql = "Select * from usuario order by id";
                rs = st.executeQuery(sql);
                while(rs.next()){
                    listaUsuario.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getInt(3)));
                }
                return listaUsuario;
            }catch(SQLException ex){
                System.out.println("Error al listar usuarios "+ex.getMessage());
            }
            return listaUsuario;
        }
     
       public ArrayList<Usuario> listarUsuariosPorId(int id){
           
            ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
            
            try{
                String sql = "Select * from usuario where id = '"+id+"' ";
                rs = st.executeQuery(sql);
                while(rs.next()){
                    listaUsuario.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getInt(3)));
                }
                return listaUsuario;
            }catch(SQLException ex){
                System.out.println("Error al listar usuarios "+ex.getMessage());
            }
            return listaUsuario;
        }
        
        public boolean editarUsuario(Usuario usu){
            try{
                String sql = "Update usuario set nombre = '"+usu.getNombre()+"', edad = '"+usu.getEdad()+"' where id = '"+usu.getId()+"'";
                st.executeUpdate(sql);
                return true;
            }catch(SQLException ex){
                System.out.println("Error al editar "+ex.getMessage());
                return false;
            }
        }
        
           
        public boolean eliminarUsuario(int id){
            try{
                String sql = "Delete from usuario where id = '"+id+"' ";
                st.executeUpdate(sql); //para insert, delete, update se usa executeUpdate. Para consultar executeQuery
                return true;
            }catch(SQLException ex){
                System.out.println("Error al eliminar "+ex.getMessage());
                return false;
            }
        }
}
