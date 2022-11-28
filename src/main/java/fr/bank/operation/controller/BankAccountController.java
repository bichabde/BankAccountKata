package fr.bank.operation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.bank.operation.dto.AccountBankDto;
import fr.bank.operation.dto.ClientDto;
import fr.bank.operation.entities.Operation;
import fr.bank.operation.exception.ResourceNotFoundException;
import fr.bank.operation.service.BankAccountService;
import fr.bank.operation.service.OperationService;

@RestController
@RequestMapping("/accounts/")
public class BankAccountController {

	@Autowired
	BankAccountService bankAccountService;



	@GetMapping(path="{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public AccountBankDto getAccount(@PathVariable("id") Long idAccount ) throws ResourceNotFoundException{
		System.out.println(idAccount);
		return bankAccountService.getAccount(idAccount);
	}
	
	
	@GetMapping("{idAccount}/operations")
	public List<Operation>  getListOperations(@PathVariable long idAccount) throws ResourceNotFoundException{
		 return bankAccountService.getListOperation(idAccount);
	}
	@GetMapping("clients/{id}")
	public ClientDto  geClient(@PathVariable("id") long id) throws ResourceNotFoundException{
		 return bankAccountService.getClient(id);
	}
}
