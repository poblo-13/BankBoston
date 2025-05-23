public class Cuenta {
    
    private String numeroCuenta;
    private int saldo;

    public Cuenta(String numeroCuenta) {
        if (numeroCuenta == null || !numeroCuenta.matches("\\d{9}")) {
            throw new IllegalArgumentException("Número de cuenta debe tener exactamente 9 dígitos.");
        }
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
