package expensetracker.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import expensetracker.entity.Transaction;
import expensetracker.entity.Transaction.TransactionType;
import expensetracker.service.TransactionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor 

public class TransactionController{
	
	private final TransactionService service;
	
	
	@PostMapping 
	public ResponseEntity<Transaction> add(
			@RequestBody Transaction t
			){
		Transaction savedata = service.addTransaction(t);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(savedata);
	}
	
	@GetMapping
	public ResponseEntity<List<Transaction>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Transaction>> byCategory(@PathVariable String category){
		return ResponseEntity.ok(service.getByCategory(category));
		
	}
	
	@GetMapping("/type/{type}")
	public ResponseEntity<List<Transaction>> bytYpe(@PathVariable TransactionType type){
		return ResponseEntity.ok(service.getByType(type));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
}
