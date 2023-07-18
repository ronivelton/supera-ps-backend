package br.com.banco.dtos;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.Data;

@Data
public class TransactionDTO {
  private Long id;
  private Instant transferDate;
  private BigDecimal value;
  private String type;
  private String transferOperatorName;
}
