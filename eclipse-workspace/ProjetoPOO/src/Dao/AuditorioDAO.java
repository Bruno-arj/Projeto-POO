package Dao;

import com.google.gson.reflect.TypeToken;
import Model.Auditorio;
import java.util.ArrayList;

public class AuditorioDAO extends DAOJson<Auditorio> {
	public AuditorioDAO() {
		super("auditorio.json", new TypeToken<ArrayList<Auditorio>>(){}.getType());
	}
}
