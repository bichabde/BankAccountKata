package fr.bank.operation.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "operation")
@Getter @Setter @NoArgsConstructor
public class Operation implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false, length = 13)
	private Date date;
	
	@Enumerated(EnumType.STRING)
    private OperationType type;
	
	@Column(name = "amount", nullable = false)
	private Long amount;
	
	@JsonIgnore
	  @ManyToOne
      @JoinColumn(name = "idAccount")
      private AccountBank account;
}
