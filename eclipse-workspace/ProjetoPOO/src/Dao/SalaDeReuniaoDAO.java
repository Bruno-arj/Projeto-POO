package Dao;

import com.google.gson.reflect.TypeToken;
import Model.SalaDeReuniao;
import java.util.ArrayList;

public class SalaDeReuniaoDAO extends DAOJson<SalaDeReuniao> {
	public SalaDeReuniaoDAO() {
		super("pagamento.json", new TypeToken<ArrayList<SalaDeReuniao>>(){}.getType());
	}
}
