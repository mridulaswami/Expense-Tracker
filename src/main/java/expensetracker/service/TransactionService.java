package expensetracker.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.stereotype.Service;

import expensetracker.entity.Transaction;
import expensetracker.entity.Transaction.TransactionType;
import expensetracker.repository.TransactionRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class TransactionService{
	
	private final TransactionRepo repo;
	
	public Transaction addTransaction(Transaction t) {
		
		if(t.getCreatedAt()==null) {
			t.setCreatedAt(LocalDateTime.now());
		}
		
		return repo.save(t);
		
	}
	
	public List<Transaction> getAll(){
		
		return repo.findAll();
	}
	
	public List<Transaction> getByCategory(String category){
		return repo.findByCategory(category.toUpperCase());
	}
	
	public List<Transaction> getByType(TransactionType type){
		return repo.findByType(type);
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
	
}