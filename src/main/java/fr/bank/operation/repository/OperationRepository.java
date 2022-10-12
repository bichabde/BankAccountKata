package fr.bank.operation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.bank.operation.entities.Operation;

@Repository
public interface  OperationRepository  extends CrudRepository<Operation, Long>{

}
