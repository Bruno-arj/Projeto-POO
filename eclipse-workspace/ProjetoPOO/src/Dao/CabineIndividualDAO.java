package Dao;

import com.google.gson.reflect.TypeToken;
import Model.CabineIndividual;
import java.util.ArrayList;

public class CabineIndividualDAO extends DAOJson<CabineIndividual> {
	public CabineIndividualDAO() {
		super("cabine.json", new TypeToken<ArrayList<CabineIndividual>>(){}.getType());
	}
}