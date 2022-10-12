package fr.bank.operation.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client")
@Getter @Setter @NoArgsConstructor
public class Client {
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	
	@Column(name = "nom", nullable = false)
	private String nom;
	

	@Column(name = "prenom", nullable = false)
	private String prenom;
	

	@Column(name = "adresse", nullable = false)
	private String adresse;
	

	@Column(name = "agence", nullable = false)
	private String agence;
	

	@Column(name = "id_account", nullable = false)
	
	private Long idAccount;
	

}
