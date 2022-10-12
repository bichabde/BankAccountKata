package fr.bank.operation.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.ArgumentMatchers.any;

import fr.bank.operation.entities.AccountBank;
import fr.bank.operation.entities.Operation;
import fr.bank.operation.entities.OperationType;
import fr.bank.operation.exception.ResourceNotFoundException;
import fr.bank.operation.repository.BankAccountRepository;
import fr.bank.operation.repository.OperationRepository;



@RunWith(MockitoJUnitRunner.class)
public class OperationServiceTest {

	
	@InjectMocks
	BankAccountService bankAccountService;
	@InjectMocks
	OperationService operationService;
	
	@Mock 
	BankAccountRepository accountBankRepository;
	@Mock
	OperationRepository operationRepository;
	
	private AccountBank account;
	private Operation operation;
	
	
	
	@Before
	public void setUp() {
		account = new AccountBank();
		account.setBalance(new Long(200));
		account.setId(1L);
		operation = new Operation();
		operation.setAccount(account);
		operation.setDate(new Date());
		operation.setId(2L);
		operation.setType(OperationType.DEPOSIT);
	}
	
	@Test
	public void testtDepositeThrowException() {
		when(accountBankRepository.findById(anyLong())).thenReturn(Optional.empty());
		assertThrows(ResourceNotFoundException.class,
				() -> operationService.deposit(1L,new Long(1000)));
	}
	
	@Test
	public void testDepositeSuccess() {
		when(accountBankRepository.findById(anyLong())).thenReturn(Optional.of(account));
		long actualMontant = account.getBalance();
		when(operationRepository.save(any(Operation.class))).thenReturn(operation);
		Operation operationResult = operationService.deposit(1L,new Long(1000));
		
		assertEquals(operationResult.getAmount(), 1000);
		assertEquals(operationResult.getType(), OperationType.DEPOSIT);
		assertEquals(operationResult.getAccount().getBalance(), actualMontant+1000);
		
		
		
	}
	
	@Test
	public void testtWithDrawalThrowException() {
		when(accountBankRepository.findById(anyLong())).thenReturn(Optional.empty());
		assertThrows(ResourceNotFoundException.class,
				() -> operationService.withdrawal(1L,new Long(1000)));
	}
	
	@Test
	public void testwithdrawalSuccess() {
		when(accountBankRepository.findById(anyLong())).thenReturn(Optional.of(account));
		long actualMontant = account.getBalance();
		when(operationRepository.save(any(Operation.class))).thenReturn(operation);
		Operation operationResult = operationService.withdrawal(1L,new Long(1000));
		
		assertEquals(operationResult.getAmount(), -1000);
		assertEquals(operationResult.getType(), OperationType.WITHDRAWAL);
		assertEquals(operationResult.getAccount().getBalance(), actualMontant-1000);
		
		
		
	}
	@Test
	public void testCreateOperationThrowException() {
	}
	
	@Test
	public void testCreateOperationDepositSuccess() {
		
	}
	
	@Test
	public void testCreateOperationWithDrawalSuccess() {
		
	}
	
	@Test
	public void testCreateOperationDepositThrowException() {
	}
	@Test
	public void testCreateOperationWithDrawalThrowException() {
	}
}
