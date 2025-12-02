package Dao;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public abstract class DAOJson<T> implements Persistencia<T> {

    private File arquivo;
    private Gson gson = new Gson();
    private Type tipoLista;

    public DAOJson(String nomeArquivo, Type tipoLista) {
        this.arquivo = new File("data/" + nomeArquivo);
        this.tipoLista = tipoLista;

        // cria arquivo se não existir
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
}
