package entidades;

import java.sql.Date;
import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Setter
@Getter
@NoArgsConstructor
public class Cliente {

    
    private String id_usuario;
    private Boolean activo;
    private String nombre;
    private String apellido;
    private String dni;

    // private Date fecha_de_nacimiento;
    

    public Cliente(String id_usuario, Boolean activo, String nombre, String apellido, String dni) {
        this.id_usuario = id_usuario;
        this.activo = activo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
      }

  
 
    // Puedes añadir más atributos y métodos según las necesidades del Cliente
}