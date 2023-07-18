package br.com.banco.repositories;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;

import br.com.banco.entities.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {
  List<Transaction> findByAccountId(Long accountId);
  
  List<Transaction> findAll( @Nullable Specification<Transaction> specification);
}
