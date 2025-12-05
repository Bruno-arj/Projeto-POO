package Dao;

import com.google.gson.reflect.TypeToken;
import Model.Reserva;
import java.util.ArrayList;

public class ReservaDAO extends DAOJson<Reserva> {
    public ReservaDAO() {
        super("reservas.json", new TypeToken<ArrayList<Reserva>>(){}.getType());
    }
}

