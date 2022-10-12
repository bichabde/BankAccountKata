package fr.bank.operation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.bank.operation.entities.AccountBank;

@Repository
public interface BankAccountRepository extends CrudRepository<AccountBank,Long > ,BankAccountCustomRepository{
	
	

}
