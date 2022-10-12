package fr.bank.operation.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bank.operation.dto.AccountBankDto;
import fr.bank.operation.dto.AccountBankMapper;
import fr.bank.operation.entities.AccountBank;
import fr.bank.operation.entities.Operation;
import fr.bank.operation.entities.OperationType;
import fr.bank.operation.exception.ResourceNotFoundException;
import fr.bank.operation.repository.BankAccountRepository;
import fr.bank.operation.repository.OperationRepository;

@Service
public class OperationService {

	
	@Autowired
	BankAccountRepository accountBankRepository;
	@Autowired
	OperationRepository OperationRepository;
	
	@Autowired
	AccountBankMapper mapper;
	
	
	public Operation deposit(long idAccount, long montant) throws ResourceNotFoundException {
		Optional<AccountBank> optionalAccount =accountBankRepository.findById(idAccount);
		if(!optionalAccount.isPresent()) {
			throw new ResourceNotFoundException("account not found "+idAccount);
		}
		AccountBank account=  optionalAccount.get();
		
		Operation operation = new Operation();
		operation.setAmount(montant);
		operation.setDate(new Date());
		operation.setType(OperationType.DEPOSIT);
		long newMontant= account.getBalance()+montant;
		account.setBalance(newMontant);
		operation.setAccount(account);
		OperationRepository.save(operation);
		return operation;
	}

	public Operation withdrawal(long idAccount, long montant) throws ResourceNotFoundException {
		Optional<AccountBank> optionalAccount =accountBankRepository.findById(idAccount);
		if(!optionalAccount.isPresent()) {
			throw new ResourceNotFoundException("account not found "+idAccount);
		}
		AccountBank account=  optionalAccount.get();
		
		Operation operation = new Operation();
		operation.setAmount(-montant);
		operation.setDate(new Date());
		operation.setType(OperationType.WITHDRAWAL);
		long newMontant= account.getBalance()-montant;
		account.setBalance(newMontant);
		operation.setAccount(account);
		OperationRepository.save(operation);
		return operation;
	}
}
