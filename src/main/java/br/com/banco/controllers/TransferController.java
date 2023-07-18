package br.com.banco.controllers;

import java.time.Instant;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.dtos.TransactionDTO;
import br.com.banco.services.TransactionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/transactions")
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class TransferController {
  private final TransactionService transferService;

  @GetMapping("/accounts/{id}")
  public ResponseEntity<List<TransactionDTO>> getTransfers(
    @PathVariable Long id,
    @RequestParam(required = false) Instant startDate,
    @RequestParam(required = false) Instant endDate,
    @RequestParam(required = false) String transferOperatorName
    ) {

      List<TransactionDTO> transfers = transferService.getTransfers(id, startDate, endDate, transferOperatorName);
      return ResponseEntity.ok(transfers);
      
  }
}
