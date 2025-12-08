package Dao;

import com.google.gson.reflect.TypeToken;
import Model.ReservaSalaDeReuniao;
import java.util.ArrayList;

public class ReservaSalaDeReuniaoDAO extends DAOJson<ReservaSalaDeReuniao> {
    public ReservaSalaDeReuniaoDAO() {
        super("reservas.json", new TypeToken<ArrayList<ReservaSalaDeReuniao>>(){}.getType());
    }
}