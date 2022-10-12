package fr.bank.operation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.bank.operation.dto.AccountBankDto;
import fr.bank.operation.dto.Montant;
import fr.bank.operation.entities.Operation;
import fr.bank.operation.exception.ResourceNotFoundException;
import fr.bank.operation.service.OperationService;

@RestController
@RequestMapping("/operation/")
public class OperationController {

	@Autowired
	OperationService operationService;
	
	
	@PutMapping(value="{idAccount}/deposit")
	public Operation deposit(@PathVariable long idAccount,@RequestBody Montant montant) throws ResourceNotFoundException {
		return operationService.deposit(idAccount,montant.getMontant());
	}
	
	@PutMapping(value="{idAccount}/withdrawal")
	public Operation withdrawal(@PathVariable long idAccount,@RequestBody Montant montant) throws ResourceNotFoundException {
		return operationService.withdrawal(idAccount,montant.getMontant());
	}
	
}
