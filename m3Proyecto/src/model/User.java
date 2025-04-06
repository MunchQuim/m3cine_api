package model;

import java.util.ArrayList;
import model.Asiento;

public class User {

    private String nombre;
    private String apellidos;
    private String phone;
    private String email;
    private String password;
    private ArrayList<Asiento> compras;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList getCompras() {
        return compras;
    }

    public void setCompras(ArrayList compras) {
        this.compras = compras;
    }
    public void addCompra(Asiento asiento){
        this.compras.add(asiento);
    }
    public User() {
    }

    public User(String nombre, String apellidos, String phone, String email, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.compras = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{");
        sb.append("nombre=").append(nombre);
        sb.append(", apellidos=").append(apellidos);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", compras=").append(compras);
        sb.append('}');
        return sb.toString();
    }

    public String getInfoTickets() {
        StringBuilder infoTickets = new StringBuilder();
        infoTickets.append("\nuser : ").append(nombre).append(" ").append(apellidos);
        for (Asiento compra : compras) {
            infoTickets.append(compra.getTicket());
        }
        infoTickets.append("-------------------\n");
        return infoTickets.toString();
    }


}
