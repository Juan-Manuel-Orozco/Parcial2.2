package org.example;

import java.io.Serializable;
import java.io.*;
import java.util.*;

public class Maletin implements Serializable {
    private String id;
    private String tipo;

    public Maletin(String id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}