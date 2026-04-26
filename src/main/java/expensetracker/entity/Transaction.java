package expensetracker.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data

public class Transaction{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Positive
	private double amount;
	
	@NotBlank
	private String category;
	
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	
	private String description;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	public enum TransactionType{
		INCOME,EXPENSE
	}
	
	
}