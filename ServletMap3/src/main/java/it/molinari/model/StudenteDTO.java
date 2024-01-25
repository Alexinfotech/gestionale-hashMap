package it.molinari.model;

public class StudenteDTO extends UtenteDTO {
	private String corsoDiStudi;
	private String classe;
	private String ruolo;

	public String getCorsoDiStudi() {
		return corsoDiStudi;
		
	}

	public void setCorsoDiStudi(String corsoDiStudi) {
		this.corsoDiStudi = corsoDiStudi;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;

	}

	@Override
	public String toString() {
		// Utilizza il toString() della classe padre e aggiunge i dettagli del corso di
		// studi
		return "StudenteDTO [" + super.toString() + ", Corso di Studi: " + corsoDiStudi + ", Classe: " + classe +  "]";
	}

}