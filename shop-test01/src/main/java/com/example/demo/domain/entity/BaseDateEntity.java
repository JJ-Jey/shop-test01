package com.example.demo.domain.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

//@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseDateEntity {
	
	//@CreatedDate
	@CreationTimestamp
	@Column(columnDefinition = "timestamp(6) null")
	private LocalDateTime createdDate;

	//@LastModifiedDate
	@UpdateTimestamp
	@Column(columnDefinition = "timestamp(6) null")
	private LocalDateTime updatedDate;
}