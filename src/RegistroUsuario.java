import java.util.Scanner;
import java.io.*;
public class RegistroUsuario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese su correo electrónico:");
        String correo = scanner.nextLine();

        System.out.println("Ingrese su contraseña:");
        String contrasena = scanner.nextLine();


        Usuario nuevoUsuario = new Usuario(nombre, correo, contrasena);


        if (Usuario.validarCorreo(correo) && Usuario.validarContrasena(contrasena)) {
            System.out.println("Usuario registrado correctamente.");
        } else {
            System.out.println("Error en la información proporcionada. Por favor, inténtelo de nuevo.");
        }


        try {
            FileWriter fileWriter = new FileWriter("usuario.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(nuevoUsuario.toString());
            printWriter.close();
            System.out.println("Usuario registrado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
            e.printStackTrace();
        }

        while (true) {
            System.out.println("¿Desea registrar otro usuario? (Sí/No)");
            String respuesta = scanner.nextLine().toLowerCase();
            if (!respuesta.equals("si")) {
                break;
            }

        }
    }
}
