package br.com.banco.entities;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "transferencia")
public class Transaction{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "data_transferencia", nullable = false)
  private Instant transferDate;
  @Column(name = "valor", nullable = false)
  private BigDecimal value;
  @Column(name = "tipo", nullable = false, length = 15)
  private String type;
  @Column(name = "nome_operador_transacao", length = 50)
  private String transferOperatorName;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "conta_id", referencedColumnName = "id_conta")
  private Account account;
}
