package fr.bank.operation.entities;

public enum OperationType {
	
	DEPOSIT("deposit"),
	WITHDRAWAL("withdrawal");
	String operation;
	private OperationType(String operation) {
		
		this.operation= operation;
	}

}
