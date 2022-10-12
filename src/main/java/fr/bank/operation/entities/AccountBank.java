package fr.bank.operation.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * account entity
 */
@Entity
@Table(name = "account")
@Getter @Setter @NoArgsConstructor
public class AccountBank implements Serializable {


	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	
	@Column(name = "balance", nullable = false)
	private Long balance;
	
	@OneToMany(mappedBy = "account")
	private List<Operation> operations= new ArrayList<Operation>();
	
}
