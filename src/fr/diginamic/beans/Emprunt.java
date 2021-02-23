package fr.diginamic.beans;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Emprunt {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "date_debut")
	private LocalDate dateDebut;
	@Column(name = "date_fin")
	private LocalDate dateFin;
	@Column(name = "delai")
	private int delaiMax;
	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;
	@ManyToMany
	@JoinTable(name = "compo", joinColumns = @JoinColumn(name = "id_emp", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_liv", referencedColumnName = "id"))
	private List<Livre> livres;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public int getDelaiMax() {
		return delaiMax;
	}

	public void setDelaiMax(int delaiMax) {
		this.delaiMax = delaiMax;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emprunt [id=");
		builder.append(id);
		builder.append(", dateDebut=");
		builder.append(dateDebut);
		builder.append(", dateFin=");
		builder.append(dateFin);
		builder.append(", delaiMax=");
		builder.append(delaiMax);
		builder.append("]");
		return builder.toString();
	}

}
