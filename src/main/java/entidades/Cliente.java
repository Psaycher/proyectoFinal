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
    private String activo;
    private String nombre;
    private String apellido;
    private String dni;
    private String fecha_de_nacimiento;
    private String telefono;
    private String domicilio;
    private String localidad;
    private String cp;
    private String email;
    private String password;
    private String password2;
    private String rol;
    

    public Cliente(String id_usuario, String activo, String nombre, String apellido, String dni, String fecha_de_nacimiento,
            String telefono, String domicilio, String localidad, String cp, String email, String password,
            String password2, String rol) {
        this.id_usuario = id_usuario;
        this.activo = activo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.localidad = localidad;
        this.cp = cp;
        this.email = email;
        this.password = password;
        this.password2 = password2;
        this.rol = rol;
    }
}