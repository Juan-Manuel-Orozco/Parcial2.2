package org.example;
import java.io.*;
import java.util.*;
public class MaletinCRUD {
    private List<Maletin> maletines;
    private String filePath;

    public MaletinCRUD(String filePath) {
        this.filePath = filePath;
        this.maletines = new ArrayList<>();
        cargarDatos();
    }

    public void insertar(Maletin maletin) {
        maletines.add(maletin);
        guardarDatos();
    }

    public void eliminar(String id) {
        maletines.removeIf(maletin -> maletin.getId().equals(id));
        guardarDatos();
    }

    public void actualizar(Maletin maletinActualizado) {
        for (int i = 0; i < maletines.size(); i++) {
            if (maletines.get(i).getId().equals(maletinActualizado.getId())) {
                maletines.set(i, maletinActualizado);
                guardarDatos();
                break;
            }
        }
    }

    public Maletin consultar(String id) {
        for (Maletin maletin : maletines) {
            if (maletin.getId().equals(id)) {
                return maletin;
            }
        }
        return null;
    }

    private void cargarDatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            maletines = (List<Maletin>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(maletines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
