package expensetracker.repository;

import java.time.LocalDate;
import expensetracker.entity.Transaction.TransactionType;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import expensetracker.entity.Transaction;

public interface TransactionRepo
extends JpaRepository<Transaction, Long>
{
	
	List<Transaction> findByType(TransactionType type);
	List<Transaction> findByCategory(String category);
	List<Transaction> findByCreatedAtBetween(LocalDate start, LocalDate end);
	
}