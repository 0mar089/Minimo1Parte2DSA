package edu.upc.dsa.models;


import java.util.HashMap;
import java.util.Map;

public class Order {

    String dni;
    Map<Integer, String> alimentos;
    User u;

    public Order(String dni) {
        this.dni = dni;
        alimentos = new HashMap<>();
        this.u = new User(dni);
    }

    public void addLP(int i, String s) {
        alimentos.put(i, s);
    }


    public boolean ContainsAlimento(String alimento){

        return alimentos.containsValue(alimento);
    }

    public Integer getSizeAlimento() {
        return alimentos.size();
    }

    public String getDNI(){
        return dni;
    }
}
