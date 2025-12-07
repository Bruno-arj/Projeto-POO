package Dao;

import com.google.gson.reflect.TypeToken;
import Model.Espaco;
import java.util.ArrayList;

public class EspacoDAO extends DAOJson<Espaco> {
    public EspacoDAO() {
        super("espaco.json", new TypeToken<ArrayList<Espaco>>(){}.getType());
    }
}

