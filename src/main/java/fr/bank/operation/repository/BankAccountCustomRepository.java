package fr.bank.operation.repository;

import fr.bank.operation.dto.ClientDto;

public interface BankAccountCustomRepository {
	
	
	ClientDto getClient(long id);

}
