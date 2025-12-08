package Dao;

import com.google.gson.reflect.TypeToken;
import Model.ReservaAuditorio;
import java.util.ArrayList;

public class ReservaAuditorioDAO extends DAOJson<ReservaAuditorio> {
    public ReservaAuditorioDAO() {
        super("reservas.json", new TypeToken<ArrayList<ReservaAuditorio>>(){}.getType());
    }
}

