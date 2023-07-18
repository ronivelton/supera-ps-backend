package br.com.banco.mappers;

import java.util.List;
import java.util.stream.Collectors;

import br.com.banco.dtos.TransactionDTO;
import br.com.banco.entities.Transaction;

public class TransactionMapper {
  public static TransactionDTO toDTO(Transaction transfer) {
    TransactionDTO dto = new TransactionDTO();
    dto.setId(transfer.getId());
    dto.setTransferDate(transfer.getTransferDate());
    dto.setValue(transfer.getValue());
    dto.setType(transfer.getType());
    dto.setTransferOperatorName(transfer.getTransferOperatorName());

    return dto;
  }

  public static List<TransactionDTO> toDTOList(List<Transaction> transfers) {
    return transfers.stream().map(TransactionMapper::toDTO).collect(Collectors.toList());
  }
}
