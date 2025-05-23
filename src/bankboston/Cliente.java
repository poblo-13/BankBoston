/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston;

/**
 *
 * @author Pablo
 */
public class Cliente {
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private String telefono;
    private Cuenta cuenta;

    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno,
                   String domicilio, String comuna, String telefono, String numeroCuenta) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuenta = new Cuenta(numeroCuenta);
        setRut(rut);
    }

    public boolean setRut(String rut) {
        if (rutValido(rut)) {
            this.rut = rut;
            return true;
        } else {
            System.out.println("RUT inválido. El formato debe ser con puntos y guion. Ejemplo: 12.345.678-9");
            return false;
        }
    }

    public static boolean rutValido(String rut) {
        return rut.matches("^\\d{1,2}\\.\\d{3}\\.\\d{3}-[\\dkK]$");
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void verDatos() {
        System.out.println("DATOS DEL CLIENTE:");
        System.out.println("RUT: " + rut);
        System.out.println("Nombre: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno);
        System.out.println("Domicilio: " + domicilio);
        System.out.println("Comuna: " + comuna);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Cuenta Corriente: " + cuenta.getNumeroCuenta());
    }
}
