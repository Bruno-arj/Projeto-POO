package Dao;

import java.util.List;

public interface Persistencia<T> {
    
	void salvar(T obj);
    
	T buscar(int id);
    
	List<T> listar();
    
	void remover(int id);
}
