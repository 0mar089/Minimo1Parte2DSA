package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class User {
    String dni;
    Queue<Order> orders;

    public User(String dni) {
        orders = new LinkedList<>();
        this.dni = dni;
    }

    public void AddOrder(Order o) {
        orders.add(o);
    }

    public String GetDNI() {
        return dni;
    }

    public List<Order> orders() {
        List<Order> l = new ArrayList<>();
        for (Order o : orders) {
            l.add(o);
        }
        return l;
    }
}
