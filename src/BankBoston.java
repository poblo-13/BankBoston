import java.util.Scanner;

public class BankBoston {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cliente cliente = null;
        int opcion;

        do {
            System.out.println("\n=== MENÚ - BANK BOSTON ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver datos de cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Girar");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Registro de Cliente ---");
                    String rut;
                    boolean rutValido;

                    do {
                        System.out.print("RUT (ej: 12.345.678-9): ");
                        rut = sc.nextLine();
                        rutValido = Cliente.rutValido(rut);
                        if (!rutValido) {
                            System.out.println("RUT inválido. El formato debe ser con puntos y guion y longitud 11 a 12.");
                        }
                    } while (!rutValido);

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Apellido Paterno: ");
                    String apPaterno = sc.nextLine();
                    System.out.print("Apellido Materno: ");
                    String apMaterno = sc.nextLine();
                    System.out.print("Domicilio: ");
                    String domicilio = sc.nextLine();
                    System.out.print("Comuna: ");
                    String comuna = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();

                    String numCuenta = "";
                    boolean cuentaValida = false;
                    do {
                        System.out.print("Número de Cuenta (9 dígitos): ");
                        numCuenta = sc.nextLine();
                        try {
                            new Cuenta(numCuenta);
                            cuentaValida = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (!cuentaValida);

                    cliente = new Cliente(rut, nombre, apPaterno, apMaterno, domicilio, comuna, telefono, numCuenta);
                    System.out.println("Cliente registrado exitosamente.");
                    break;

                case 2:
                    if (cliente != null) {
                        cliente.verDatos();
                    } else {
                        System.out.println("No hay cliente registrado.");
                    }
                    break;

                case 3:
                    if (cliente != null) {
                        System.out.print("Monto a depositar: ");
                        int monto = sc.nextInt();
                        cliente.getCuenta().depositar(monto);
                    } else {
                        System.out.println("No hay cliente registrado.");
                    }
                    break;

                case 4:
                    if (cliente != null) {
                        System.out.print("Monto a girar: ");
                        int monto = sc.nextInt();
                        cliente.getCuenta().girar(monto);
                    } else {
                        System.out.println("No hay cliente registrado.");
                    }
                    break;

                case 5:
                    if (cliente != null) {
                        cliente.getCuenta().consultarSaldo();
                    } else {
                        System.out.println("No hay cliente registrado.");
                    }
                    break;

                case 6:
                    System.out.println("Gracias por usar Bank Boston.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}
