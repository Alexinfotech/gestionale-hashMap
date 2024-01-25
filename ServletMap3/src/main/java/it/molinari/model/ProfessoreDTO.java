package it.molinari.model;

public class ProfessoreDTO extends UtenteDTO {
	private String materia;
	private String ruolo;

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
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
		return "ProfessoreDTO [" + super.toString() + ", Materia: " + materia +  ", Ruolo: " + ruolo + "]";
	}

}