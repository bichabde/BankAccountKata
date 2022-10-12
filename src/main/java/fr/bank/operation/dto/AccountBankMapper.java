package fr.bank.operation.dto;

import org.springframework.stereotype.Component;

import fr.bank.operation.entities.AccountBank;

@Component
public class AccountBankMapper {
	
	public AccountBankDto mapper(AccountBank account) {
		
		AccountBankDto dto = new AccountBankDto();
		dto.setId(account.getId());
		dto.setBalance(account.getBalance());
		dto.setListOperations(account.getOperations());
		
		return dto;
	}

}
