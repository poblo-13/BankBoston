/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston;

/**
 *
 * @author Pablo
 */
public class Cuenta {
    private String numeroCuenta;
    private int saldo;

    public Cuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void depositar(int monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("El monto a depositar debe ser mayor que 0.");
        }
    }

    public void girar(int monto) {
        if (monto <= 0) {
            System.out.println("El monto a girar debe ser mayor que 0.");
        } else if (monto > saldo) {
            System.out.println("Fondos insuficientes. Saldo actual: $" + saldo);
        } else {
            saldo -= monto;
            System.out.println("Giro exitoso. Nuevo saldo: $" + saldo);
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo actual: $" + saldo);
    }
}
