package fr.bank.operation.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bank.operation.dto.AccountBankDto;
import fr.bank.operation.dto.AccountBankMapper;
import fr.bank.operation.dto.ClientDto;
import fr.bank.operation.entities.AccountBank;
import fr.bank.operation.entities.Operation;
import fr.bank.operation.exception.ResourceNotFoundException;
import fr.bank.operation.repository.BankAccountRepository;

@Service
public class BankAccountService {

	@Autowired
	BankAccountRepository accountBankRepository;
	
	@Autowired
	AccountBankMapper mapper;
	

	public AccountBankDto getAccount(long id) throws ResourceNotFoundException {
		Optional<AccountBank> optionalAccount =accountBankRepository.findById(id);
		if(!optionalAccount.isPresent()) {
			throw new ResourceNotFoundException("account not found "+id);
		}
		return this.mapper.mapper(optionalAccount.get());
	}


	public List<Operation> getListOperation(long id) {
		Optional<AccountBank> optionalAccount =accountBankRepository.findById(id);
		if(!optionalAccount.isPresent()) {
			throw new ResourceNotFoundException("account not found "+id);
		}
		return optionalAccount.get().getOperations();
	}


	public ClientDto getClient(long idClient) {
		// TODO Auto-generated method stubclien
		
		ClientDto client = accountBankRepository.getClient(idClient);
		return client;
	}

}
