package Dao;

import com.google.gson.reflect.TypeToken;
import Model.ReservaCabineIndividual;
import java.util.ArrayList;

public class ReservaCabineIndividualDAO extends DAOJson<ReservaCabineIndividual> {
    public ReservaCabineIndividualDAO() {
        super("reservas.json", new TypeToken<ArrayList<ReservaCabineIndividual>>(){}.getType());
    }
}

