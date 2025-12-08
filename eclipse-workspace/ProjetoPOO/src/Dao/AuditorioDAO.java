package Dao;

import com.google.gson.reflect.TypeToken;
import Model.Auditorio;
import java.util.ArrayList;

public class AuditorioDAO extends DAOJson<Auditorio> {
	public AuditorioDAO() {
		super("pagamento.json", new TypeToken<ArrayList<Auditorio>>(){}.getType());
	}
}
