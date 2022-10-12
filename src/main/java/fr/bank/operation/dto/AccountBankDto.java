package fr.bank.operation.dto;


import java.util.List;

import fr.bank.operation.entities.Operation;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountBankDto {

	
	private Long id;
	private Long balance;
	private List<Operation> listOperations;
}

