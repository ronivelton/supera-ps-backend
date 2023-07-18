package br.com.banco.services;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.banco.dtos.TransactionDTO;
import br.com.banco.entities.Transaction;
import br.com.banco.mappers.TransactionMapper;
import br.com.banco.repositories.TransactionRepository;
import br.com.banco.repositories.specifications.TransferSpecification;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {
  private final TransactionRepository transferRepository;

  @Transactional(readOnly = true)
  public List<TransactionDTO> getTransfers(Long id, Instant startDate, Instant endDate, String transferOperatorName) {
    Specification<Transaction> specification = Specification.where(TransferSpecification.hasAccountId(id));
    
    if (startDate != null || endDate != null) {
      if (startDate == null) startDate = Instant.EPOCH;
      if (endDate == null) endDate = Instant.now();
      specification = specification.and(TransferSpecification.hasTransferDateBetween(startDate, endDate));
    }
    
    if (transferOperatorName != null) {
      specification = specification.and(TransferSpecification.hasTransferOperatorName(transferOperatorName));
    }
    
    List<Transaction> transfers = transferRepository.findAll(specification);
    return TransactionMapper.toDTOList(transfers);
  }
}
