package edu.ar.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static edu.ar.data.Conexion.close;
import static edu.ar.data.Conexion.getConexion;

import edu.ar.model.Pelicula;

public class PeliculaDAO {


  private static final String SQL_SELECT = "SELECT * FROM movie";


  public static List<Pelicula> obtener() {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Pelicula pelicula = null;
    List<Pelicula> peliculas = new ArrayList<>();

    try {
      conn = getConexion();
      ps = conn.prepareStatement(SQL_SELECT);
      rs = ps.executeQuery();

      //Itero los resultados del ResultSet
      while(rs.next()){
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String descripcion = rs.getString("descripcion");
        String genero = rs.getString("genero");
        int calificacion = rs.getInt("calificacion");
        int anio = rs.getInt("anio");
        byte estrellas = rs.getByte("estrellas");
        String director = rs.getString("director");

        pelicula = new Pelicula(id, nombre, descripcion, genero, calificacion, anio, estrellas, director);

        //agregar la pelicula en nuestro listado de pelis
        peliculas.add(pelicula);

      }
    } catch (Exception e) {
      e.printStackTrace(System.out);
    } finally {
      try {
        close(rs);
        close(ps);
        close(conn);
      } catch(Exception e) {
        e.printStackTrace(System.out);
      }
    }
    return peliculas;
  }

}
