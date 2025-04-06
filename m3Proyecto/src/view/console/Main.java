package view.console;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.*;
import exceptions.*;

public class Main {

    static Scanner keyboard = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Film> films = new ArrayList<>();
    static ArrayList<Session> sessions = new ArrayList<>();
    static ArrayList<SesionDiaria> calendario = new ArrayList<>();
    static ArrayList<Room> rooms = new ArrayList<>();
    static User sesionUsuario;
    static int intentos = 3;

    public static void main(String[] args) {
        keyboard.useDelimiter("\n");
        String opcionStr;

        do {
            System.out.println("1- Dar de alta Usuarios ");//hecho
            System.out.println("2- Anadir una Pelicula");//modificar
            System.out.println("3- Crear Sala"); //hecho
            System.out.println("4- Crear Sesion"); // hecho
            System.out.println("5- Ver todas las Peliculas");//hecho
            System.out.println("6- Ver todas las Sesiones");//hecho
            System.out.println("7- Ver todas las Salas"); //hecho
            System.out.println("8- Comprar Pelicula");// iniciar sesion con mail y contraseña // que al buscar un dia se creen la sesionDiaria para ese dia y los asientos para la sesionDiaria.-Quim
            System.out.println("9- Ver Usuarios");//hecho
            System.out.println("10- Ver Compras por Usuario");//hecho
            System.out.println("11- Borrar Usuario");//hecho
            System.out.println("0- Salir");//hecho
            opcionStr = keyboard.next();

            switch (opcionStr) {
                case "0":
                    System.out.println("Chao!");
                    break;
                case "1":
                    darAltaUsuarios();
                    break;
                case "2":
                    anadirPelicula();
                    break;
                case "3":
                    crearSala();
                    break;
                case "4":
                    crearSesion(); //faltaria evitar solapamiento de sesiones
                    break;
                case "5":
                    verTodasPeliculas();
                    break;
                case "6":
                    verTodasSesiones();
                    break;
                case "7":
                    verTodasSalas();
                    break;
                case "8": //softblock en caso de no haber asientos libres
                    try {
                        if (iniciarSesion()) {

                            comprarPelicula();

                        }

                    } catch (SinUsuariosException e) {
                        System.out.println(e.getMessage());
                    } catch (DemasiadosIntentosException e) {
                        System.out.println(e.getMessage());
                    } catch (SinAsientosDisponiblesException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Ha habido algun error");
                    }

                    break;

                case "9":
                    verUsuarios();
                    break;
                case "10":
                    verComprasPorUsuario(); // funciona, pero no se ve bien
                    break;
                case "11":
                    borrarUsuario();
                    break;
                default:
                    System.out.println("Opcion Incorrecta!");
            }
        } while (!opcionStr.equals("0"));
    }

    public static String validarStringNoVacio(String campo) {
        String input;
        do {
            System.out.println("Ingrese " + campo + ":");
            input = keyboard.next();
            if (input == null || input.trim().isEmpty()) {
                System.out.println("El " + campo + " no puede estar vacio. Por favor, intentalo de nuevo.");
            }
        } while (input == null || input.trim().isEmpty());
        return input.trim();
    }

    public static String validarTelefono() {
        String phone;
        boolean isValid;

        do {
            System.out.println("Ingrese telefono:");
            phone = keyboard.next();

            if (phone.length() == 9 && phone.matches("\\d+")) {
                isValid = true;
            } else {
                isValid = false;
                System.out.println("Telefono no valido. Introduce un numero de 9 digitos:");
            }
        } while (!isValid);

        return phone.trim();
    }

    public static String validarEmail() {
        String email;
        boolean isValid;
        do {
            System.out.println("Ingrese email:");
            email = keyboard.next();
            isValid = esCorreo(email) && !isEmailUsed(email);
            if (!isValid) {
                System.out.println("Correo no valido o ya en uso. Introduce un correo electronico valido:");
            }
        } while (!isValid);

        return email.trim();
    }

    public static boolean esCorreo(String correo) {
        // Expresión regular para validar un correo electrónico
        String expresionRegular = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Compilamos la expresión regular
        Pattern pattern = Pattern.compile(expresionRegular);

        // Verificamos si el correo cumple con la expresión regular
        Matcher matcher = pattern.matcher(correo);

        // Retornamos el resultado de la validación
        return matcher.matches();
    }

    public static boolean isEmailUsed(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTitleUsed(String title) {
        for (Film film : films) {
            if (film.getNombre().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public static boolean login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password)) {
                    sesionUsuario = user;
                    return true;
                }
            }
        }
        return false;
    }

    public static void darAltaUsuarios() {
        String nombre = validarStringNoVacio("nombre");
        String apellidos = validarStringNoVacio("apellidos");
        String phone = validarTelefono();
        String email = validarEmail();
        String password = validarStringNoVacio("contrasena");

        User user = new User(nombre, apellidos, phone, email, password);
        users.add(user);
        System.out.println("Usuario agregado exitosamente!");
    }

    public static int validarDuracion() {
        int duration = -1;
        String strDuration;
        while (duration <= 0) {

            System.out.println("Ingrese la duracion de la pelicula: ");
            strDuration = keyboard.next();
            if (isNumericBetween(20, 180, strDuration)) {
                duration = Integer.parseInt(strDuration);
            } else {
                System.out.println("Entrada invalida. Por favor, ingrese un numero entre 20 y 180 minutos.");
            }
        }
        return duration;
    }

    public static void anadirPelicula() {
        String title;
        do {
            title = validarStringNoVacio("Titulo Pelicula");
            if (isTitleUsed(title)) {
                System.out.println("Titulo ya en uso.");
            }
        } while (isTitleUsed(title));

        int duration = validarDuracion();

        Film film = new Film(title, duration);
        films.add(film);

        System.out.println("Pelicula agregada exitosamente!");
    }
    public static void verUsuarios() {
        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Lista de Usuarios:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    public static void verTodasPeliculas() {
        if (films.isEmpty()) {
            System.out.println("No hay peliculas registradas.");
        } else {
            System.out.println("Lista de Peliculas:");
            for (Film film : films) {
                System.out.println(film);
            }
        }
    }

    public static void borrarUsuario() {
        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Ingrese el email del usuario a borrar:");
            String email = keyboard.next();
            User userToRemove = null;

            for (User user : users) {
                if (user.getEmail().equals(email)) {
                    userToRemove = user;

                    break;
                }
            }

            if (userToRemove != null) {

                ArrayList<Asiento> listaCompras = userToRemove.getCompras();
                if (listaCompras != null) {
                    for (Asiento compra : listaCompras) {
                        compra.setEstaOcupado(false);
                    }
                }
                if (userToRemove == sesionUsuario) {
                    sesionUsuario = null;
                }

                users.remove(userToRemove);

                System.out.println("Usuario borrado exitosamente!");
            } else {
                System.out.println("Usuario no encontrado.");
            }
        }
    }

    public static void crearSesion() {
        if (rooms.isEmpty() || films.isEmpty()) {
            System.out.println("Faltan salas o peliculas por crear");
        } else {
            Film pelicula = validarPelicula();
            LocalTime horaInicio = validarLocalTime();
            Room sala = validarSala(); //continuar

            Session sesion = new Session(pelicula, horaInicio, sala);
            sessions.add(sesion);
            System.out.println("Sesion agregada exitosamente!");
        }

    }

    public static void verTodasSesiones() {
        if (sessions.isEmpty()) {
            System.out.println("No hay sesiones registradas.");
        } else {
            System.out.println("Lista de Sesiones:");

            for (Session sesion : sessions) {
                System.out.println(sesion.toString());
            }
        }

    }

//    public static int validarAsientos(String tipoAsiento) {
//        int numAsientos = 0;
//        boolean isValid = false;
//    public static int validarNumeroAsientos(String tipoAsiento, int maxAsientos) {
//        int numAsientos = -1;
//        String strAsientos;
//        while (numAsientos < 0 || numAsientos > maxAsientos) {
//            //solicitar al usuario que ingrese el num de asientos
//            System.out.println("Ingrese " + tipoAsiento + " (Maximo " + maxAsientos + "): ");
//            strAsientos = keyboard.next();
//            // verificar si la entrada es un numero positivo
//            if (isNumericPositive(strAsientos)) {
//                numAsientos = Integer.parseInt(strAsientos);
//                //validar que el numero de asientos no exceda el maximo permitido
//                if (numAsientos > maxAsientos) {
//                    System.out.println("Entrada invalida. El número de asientos no puede exceder de " + maxAsientos + ".");
//                }
//            } else {
//                System.out.println("Entrada invalida. Por favor, ingrese un número entero positivo.");
//            }
//        }
//        return numAsientos;
//    }
    public static void verComprasPorUsuario() {
        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Compras por usuarios:");
            for (User user : users) {
                System.out.println(user.getInfoTickets());
            }
        }

    }

    public static boolean isRoomNumberUsed(String numSala) {
        for (Room room : rooms) {
            if (room.getNumSala().equals(numSala)) {
                return true;
            }
        }
        return false;
    }

    public static boolean iniciarSesion() throws DemasiadosIntentosException, SinUsuariosException {
        // si hay sesion iniciada
        //preguntar si quieres comprar una pelicula con el usuario X (email)
        // si sí, nada, si no, borra la sesion;
        //si no hay sesion iniciada
        // con que usuario quieres iniciar sesion (email)
        // inserte la contraseña
        // si es correcta, no entra en el bucle y guarda la sesion en sesion usuario
        // si no es correcta, contraseña no correcta, quiere seguir intentandolo?
        // si si, continua
        // si no, sale al menu

        if (users.isEmpty()) {
            throw new SinUsuariosException("Sin usuarios registrados");
        } else {
            if (sesionUsuario != null) {
                String respuesta = "";
                do {
                    System.out.println("Has iniciado sesion con " + sesionUsuario.getEmail());
                    System.out.println("Quieres comprar una pelicula con este usuario? s/n");
                    respuesta = keyboard.next().toLowerCase();
                } while (!respuesta.equals("s") && !respuesta.equals("n"));

                if (respuesta.equals("n")) {
                    sesionUsuario = null;
                }
            }
            if (sesionUsuario == null) {
                String email = "";
                String respuesta = "";
                String password = "";
                boolean buclePedirCorreo = true;
                boolean buclePedirContrasena = true;
                if (intentos <= 0) {
                    throw new DemasiadosIntentosException("Demasiados intentos, sesion bloqueada");
                }
                do {
                    System.out.println("Vamos a iniciar tu sesion");
                    System.out.println("Necesito tu correo electronico");
                    email = keyboard.next();
                    if (!isEmailUsed(email)) {
                        do {
                            System.out.println("Correo desconocido, quieres volverlo a intentar? s/n");
                            respuesta = keyboard.next().toLowerCase();
                        } while (!respuesta.equals("s") && !respuesta.equals("n"));
                        if (respuesta.equals("n")) {
                            System.out.println("saliendo..");
                            return false;
                        }
                    } else {
                        buclePedirCorreo = false;
                    }
                } while (buclePedirCorreo);
                do {
                    System.out.println("Necesito tu contraseña");
                    password = keyboard.next();
                    if (!login(email, password)) {
                        do {
                            System.out.println("contraseña erronea, quieres volverlo a intentar? s/n");
                            intentos--;
                            if (intentos <= 0) {
                                throw new DemasiadosIntentosException("Demasiados intentos, Cuenta bloqueada");
                            }
                            respuesta = keyboard.next().toLowerCase();
                        } while (!respuesta.equals("s") && !respuesta.equals("n"));
                        if (respuesta.equals("n")) {
                            System.out.println("saliendo..");
                            return false;
                        }

                    } else {
                        System.out.println("Sesion iniciada como " + sesionUsuario.getEmail());
                        intentos = 3;
                        buclePedirContrasena = false;
                    }
                } while (buclePedirContrasena);
            }
            return true;
        }

    }

    public static void comprarPelicula() throws SinAsientosDisponiblesException {
        if (films.isEmpty() || users.isEmpty() || sessions.isEmpty()) {
            System.out.println("faltan datos, revisa que existan peliculas, sesiones y usuarios");
        } else {

            String pelicula;
            Film miPelicula; //importante
            do {
                verTodasPeliculas();
                System.out.println("Qué pelicula quieres ver?");
                pelicula = keyboard.next();
                miPelicula = obtenerPelicula(pelicula);
            } while (miPelicula == null);

            //escoger la pelicula
            System.out.println("para esta pelicula tenemos estas sesiones");

            ArrayList<Session> mySesiones = obtenerSesiones(miPelicula);
            String eleccion;
            int index;
            do {
                index = 0;
                for (Session session : mySesiones) {
                    index++;
                    System.out.println(index + ") " + session.getHoraInicio());
                }
                System.out.println("Cual desea escoger");

                eleccion = keyboard.next();
                if (!isNumericBetween(1, index, eleccion)) {
                    System.out.println("escriba un índice válido");
                }
            } while (!isNumericBetween(1, index, eleccion));
            Session mySession = mySesiones.get(index - 1);//importante 

            String dia;
            do {
                System.out.println("Que dia quiere ver la pelicula? dd/mm/aaaa");
                dia = keyboard.next();

                if (!isDate(dia)) {
                    System.out.println("escriba una fecha valida");
                }
            } while (!isDate(dia));
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate myDia = LocalDate.parse(dia, format);
            SesionDiaria mySesionDiaria = recogeSesionDiaria(myDia, mySession); //importante
            if (mySesionDiaria == null) {
                // crear sesionDiaria
                crearSesionDiaria(mySession, myDia);
                mySesionDiaria = recogeSesionDiaria(myDia, mySession);
            }
            ArrayList<Asiento> listaTodosAsientos = new ArrayList<>();
            for (Asiento asiento : mySesionDiaria.getAsientosNormales()) {
                if (!asiento.getEstaOcupado()) {
                    listaTodosAsientos.add(asiento);
                }
            }

            for (Asiento asiento : mySesionDiaria.getAsientosVip()) {
                if (!asiento.getEstaOcupado()) {
                    listaTodosAsientos.add(asiento);
                }
            }

            for (Asiento asiento : mySesionDiaria.getAsientosAdaptados()) {
                if (!asiento.getEstaOcupado()) {
                    listaTodosAsientos.add(asiento);
                }
            }
            if (listaTodosAsientos.isEmpty()) {
                throw new SinAsientosDisponiblesException("no hay asientos disponibles de este tipo");
            }
            // se procede a la compra del asiento

            String indexAsientoStr;
            int indexAsiento;
            ArrayList<Integer> disponibles = new ArrayList<>();
            ArrayList<Asiento> listaAsientos = new ArrayList<>();
            String tipoAsiento;
            do { //hay un softLock en el que si no quedan disponibles para ese dia, no te permite salir de aqui.
                indexAsiento = -1;

                tipoAsiento = eleccionAsiento();
                switch (tipoAsiento) {
                    case "1":
                        listaAsientos = mySesionDiaria.getAsientosNormales();
                        break;
                    case "2":
                        listaAsientos = mySesionDiaria.getAsientosVip();
                        break;
                    case "3":
                        listaAsientos = mySesionDiaria.getAsientosAdaptados();
                        break;
                    default:
                        break;
                }

                for (Asiento asiento : listaAsientos) {
                    if (!asiento.getEstaOcupado()) {
                        disponibles.add(asiento.getIndex());
                    }
                }

                if (!disponibles.isEmpty()) {
                    System.out.println("Estos son los asientos disponibles");
                    for (int indice : disponibles) {
                        System.out.println(indice + " ");
                    }
                    System.out.println("Que asiento desea?");
                    indexAsientoStr = keyboard.next();
                    if (isNumericPositive(indexAsientoStr)) {
                        indexAsiento = Integer.parseInt(indexAsientoStr);
                        if (!disponibles.contains(indexAsiento)) {
                            System.out.println("numero de asiento incorrecto");
                        }
                    }

                }

            } while (!disponibles.contains(indexAsiento) && !tipoAsiento.equals("0"));

            for (Asiento asiento : listaAsientos) {
                if (asiento.getIndex() == indexAsiento) {
                    asiento.setEstaOcupado(true);
                    sesionUsuario.addCompra(asiento);
                    System.out.println("compra finalizada");
                }
            }

        }

    }

    public static String eleccionAsiento() {
        String tipoAsiento;
        do {
            System.out.println("Que tipo de asiento desea");
            System.out.println("1) Normal, 2) Vip, 3) adaptado");
            tipoAsiento = keyboard.next();
            if (!isNumericBetween(1, 3, tipoAsiento)) {
                System.out.println("Porfavor, inserte un valor de tipo correcto");
            }
        } while (!isNumericBetween(0, 3, tipoAsiento));
        return tipoAsiento;
    }

    public static SesionDiaria recogeSesionDiaria(LocalDate myDia, Session mySession) {
        for (SesionDiaria sesionDiaria : calendario) {
            if (sesionDiaria.getDia().isEqual(myDia) && sesionDiaria.getSesion() == mySession) {
                return sesionDiaria;
            }
        }
        return null;
    }

    public static ArrayList obtenerSesiones(Film pelicula) {
        ArrayList<Session> mySesiones = new ArrayList<>();
        for (Session session : sessions) {
            if (session.getPelicula() == pelicula) {
                mySesiones.add(session);
            }
        }
        return mySesiones;
    }

    public static Film obtenerPelicula(String nombre) {
        for (Film film : films) {
            if (film.getNombre().equals(nombre)) {
                return film;
            }
        }
        return null;
    }

    public static void crearSesionDiaria(Session sesion, LocalDate dia) {
        System.out.println("creando sesionDiaria nueva");
        //se crea un arraylist de Asientos llamado asientosNormales;
        //se crea un arraylist de Asientos llamado asientosVip;
        //se crea un arraylist de Asientos llamado asientosAdaptados;

        //a traves de la sesion, vamos a la sala asignada, y la sala asignada, tiene el numero de asientos de cada tipo
        // se hacen 3 bucles for de la longitud del numero de asientos y por cada uno de ellos crea un asiento, con (enum TipoAsientosEnum,....
        //....indice del bucle+1, false, el objeto sala asignado a la sesion.) que se añaden al array.
        // y ya;
        ArrayList<Asiento> asientosNormales = new ArrayList<>();
        ArrayList<Asiento> asientosVip = new ArrayList<>();
        ArrayList<Asiento> asientosAdaptados = new ArrayList<>();

        Room sala = sesion.getSala();

        for (int i = 0; i < sala.getNumAsientos(); i++) {
            asientosNormales.add(new Asiento(TipoAsientosEnum.Normal, i + 1, false, sala));
        }

        for (int i = 0; i < sala.getNumAsientosVip(); i++) {
            asientosVip.add(new Asiento(TipoAsientosEnum.Vip, i + 1, false, sala));
        }

        for (int i = 0; i < sala.getNumAsientosAdaptados(); i++) {
            asientosAdaptados.add(new Asiento(TipoAsientosEnum.Adaptado, i + 1, false, sala));
        }

        SesionDiaria sesionDiaria = new SesionDiaria(dia, sesion, asientosNormales, asientosVip, asientosAdaptados);
        calendario.add(sesionDiaria);
    }

    public static int validarAsientos(String tipoAsiento) {
        int numAsientos;
        do {
            System.out.println("Numero de asientos " + tipoAsiento + " (Maximo 50): ");
            numAsientos = keyboard.nextInt();
        } while (!isNumericBetween(0, 50, String.valueOf(numAsientos)));
        return numAsientos;
    }

    public static void crearSala() {
        String numSala;
        do {
            numSala = validarStringNoVacio("Numero de Sala");
            if (isRoomNumberUsed(numSala)) {
                System.out.println("Error: El numero de sala ya esta en uso. Por favor, elige otro numero.");
            }
        } while (isRoomNumberUsed(numSala));

        int numAsientos = validarAsientos("normales");
        int numAsientosVip = validarAsientos("VIP");
        int numAsientosAdaptados = validarAsientos("adaptados");

        Room room = new Room(numSala, numAsientos, numAsientosVip, numAsientosAdaptados);
        rooms.add(room);
        System.out.println("Sala creada exitosamente!");

    }

    public static void verTodasSalas() {
        if (rooms.isEmpty()) {
            System.out.println("No hay salas registradas.");
        } else {
            System.out.println("Lista de Salas:");
            for (Room room : rooms) {
                System.out.println(room);
            }
        }
    }

    public static Room validarSala() { //devuelve una sala validada
        System.out.println("Estas son todas nuestras salas");
        verTodasSalas();
        String numSala;
        Room sala = null;
        do {
            System.out.println("Que numero de sala vas a usar");
            numSala = keyboard.next();
            for (Room room : rooms) {
                if (room.getNumSala().equals(numSala)) {
                    sala = room;
                }
            }
        } while (sala == null);
        return sala;
    }

    public static Film validarPelicula() { // falla
        String input;
        Film pelicula = null;
        do {
            verTodasPeliculas();
            input = validarStringNoVacio("nombre de la pelicula");
            for (Film film : films) {
                if (film.getNombre().equals(input)) {
                    pelicula = film;
                }
            }
            if (pelicula == null) {
                System.out.println("Inserte una pelicula correcta");
            }
        } while (pelicula == null);

        return pelicula;
    }

    public static LocalTime validarLocalTime() { // falta validacion de solapamiento
        String strHora = null;
        String strMinutos = null;
        System.out.println("Voy a necesitar la hora y los minutos en la cual se inicia la pelicula");
        do {
            System.out.println("Cual es la hora");
            strHora = keyboard.next();
        } while (!isNumericBetween(8, 20, strHora));
        do {
            System.out.println("cuales son los minutos");
            strMinutos = keyboard.next();
        } while (!isNumericBetween(0, 59, strMinutos));
        int hora = Integer.parseInt(strHora);
        int minuto = Integer.parseInt(strMinutos);
        LocalTime localtime = LocalTime.of(hora, minuto);
        return localtime;
    }

    public static boolean isDate(String pDate) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate myDate = LocalDate.parse(pDate, format);
            return myDate.isAfter(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }

    }

    public static boolean isNumericPositive(String str) {
        int num;
        try {
            num = Integer.parseInt(str);

        } catch (NumberFormatException nfe) {
            return false;
        }

        return num > 0;
    }

    public static boolean isNumericBetween(int a, int b, String str) {
        int num;
        try {
            num = Integer.parseInt(str);

        } catch (NumberFormatException nfe) {
            return false;
        }

        return (num >= a && num <= b);
    }

}
