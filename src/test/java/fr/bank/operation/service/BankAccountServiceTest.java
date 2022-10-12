package fr.bank.operation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import fr.bank.operation.dto.AccountBankDto;
import fr.bank.operation.dto.AccountBankMapper;
import fr.bank.operation.entities.AccountBank;
import fr.bank.operation.entities.Operation;
import fr.bank.operation.exception.ResourceNotFoundException;
import fr.bank.operation.repository.BankAccountRepository;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountServiceTest {

	
	@Mock 
	private BankAccountRepository accountBankRepository;
	@InjectMocks
	private BankAccountService bankAccountService;
	@Mock
	AccountBankMapper mapper;
	private List<Operation> operations;
	private AccountBank account ;
		
	@Before
	public void setUp() {
		
		account = new AccountBank();
		account.setBalance(new Long(1000));
		account.setId(new Long(1222252));
		 operations = new ArrayList<Operation>();
		 Operation operation = new Operation();
		 operation.setId(1L);
		 operation.setDate(new Date());
		 operation.setAmount(new Long(1245));
		 operation.setAccount(account);
	}
	
	@Test
	public void testtGetAccountByIdOrThrowException() {
		when(accountBankRepository.findById(anyLong())).thenReturn(Optional.empty());
		assertThrows(ResourceNotFoundException.class,
				() -> bankAccountService.getAccount(new Long(121)));
	}
	
	
	@Test
	public void testGetAccountByIdSuccess() {
		when(accountBankRepository.findById(anyLong())).thenReturn(Optional.of(account));
		when(mapper.mapper(any(AccountBank.class))).thenCallRealMethod();
		AccountBankDto dto=bankAccountService.getAccount(new Long(1222252));
		assertEquals(dto.getBalance(), account.getBalance());
		assertEquals(dto.getId(), 1222252);
	}
	
	
	@Test
	public void testtGetListOperationThrowException() {
		when(accountBankRepository.findById(anyLong())).thenReturn(Optional.empty());
		assertThrows(ResourceNotFoundException.class,
				() -> bankAccountService.getListOperation(new Long(121)));
	}
	
	@Test
	public void  testGetListOperationSuccess() {
		when(accountBankRepository.findById(anyLong())).thenReturn(Optional.of(account));
		
		List<Operation> operations= bankAccountService.getListOperation(new Long(1222252));
		assertEquals(operations, account.getOperations());
		
	}
	

}
