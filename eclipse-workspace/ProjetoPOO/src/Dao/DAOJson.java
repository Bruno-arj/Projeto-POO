package Dao;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class DAOJson<T> implements Persistencia<T> {

    private File arquivo;
    private Type tipoLista;

    // Gson correto, com adapters
    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .setPrettyPrinting()
            .create();

    public DAOJson(String nomeArquivo, Type tipoLista) {
        this.arquivo = new File("data/" + nomeArquivo);
        this.tipoLista = tipoLista;

        if (!arquivo.exists()) {
            try {
                arquivo.getParentFile().mkdirs();
                arquivo.createNewFile();
                salvarLista(new ArrayList<>());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected List<T> carregarLista() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            List<T> lista = gson.fromJson(br, tipoLista);
            return (lista != null) ? lista : new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    protected void salvarLista(List<T> lista) {
        try (FileWriter fw = new FileWriter(arquivo)) {
            gson.toJson(lista, fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvar(T obj) {
        List<T> lista = carregarLista();
        lista.add(obj);
        salvarLista(lista);
    }

    public T buscar(int id) {
        List<T> lista = carregarLista();
        for (T obj : lista) {
            try {
                int objId = (int) obj.getClass().getMethod("getId").invoke(obj);
                if (objId == id) return obj;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<T> listar() {
        return carregarLista();
    }

    public void remover(int id) {
        List<T> lista = carregarLista();
        lista.removeIf(obj -> {
            try {
                int objId = (int) obj.getClass().getMethod("getId").invoke(obj);
                return objId == id;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        });
        salvarLista(lista);
    }

    public void editar(T objAtualizado) {
        List<T> lista = carregarLista();

        try {
            int idAtualizado = (int) objAtualizado.getClass().getMethod("getId").invoke(objAtualizado);

            for (int i = 0; i < lista.size(); i++) {
                T item = lista.get(i);
                int idItem = (int) item.getClass().getMethod("getId").invoke(item);

                if (idItem == idAtualizado) {
                    lista.set(i, objAtualizado);
                    salvarLista(lista);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
