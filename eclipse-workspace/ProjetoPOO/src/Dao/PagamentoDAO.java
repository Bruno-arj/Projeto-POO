package Dao;

import com.google.gson.reflect.TypeToken;
import Model.Pagamento;
import java.util.ArrayList;

public class PagamentoDAO extends DAOJson<Pagamento> {
	public PagamentoDAO() {
		super("pagamento.json", new TypeToken<ArrayList<Pagamento>>(){}.getType());
	}
}
