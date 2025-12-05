package Model;

public abstract class Espaco {

    protected int id;
    protected String nome;
    protected int capacidade;
    protected boolean disponivel;
    protected double precoPorHora;

    public Espaco(int id, String nome, int capacidade, boolean disponivel, double precoPorHora) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
        this.disponivel = disponivel;
        this.precoPorHora = precoPorHora;
    }
    
    public Espaco() {
    	
    }
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getCapacidade() {
		return capacidade;
	}



	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}



	public boolean isDisponivel() {
		return disponivel;
	}


	public double getPrecoPorHora() {
		return precoPorHora;
	}



	public void setPrecoPorHora(double precoPorHora) {
		this.precoPorHora = precoPorHora;
	}



	public abstract double calcularCustoReserva(long horas);
	
}
