package br.com.banco.repositories.specifications;

import java.time.Instant;

import org.springframework.data.jpa.domain.Specification;

import br.com.banco.entities.Transaction;

public class TransferSpecification {
  public static Specification<Transaction> hasAccountId(Long id) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("account").get("id"), id);
  }
  
  public static Specification<Transaction> hasTransferOperatorName(String transferOperatorName) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("transferOperatorName"), transferOperatorName);
  }
  
  public static Specification<Transaction> hasTransferDateBetween(Instant startDate, Instant endDate) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("transferDate"), startDate, endDate);
  }
}
