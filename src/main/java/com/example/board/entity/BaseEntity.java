package com.example.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

// 시간 정보를 다루는 클래스
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {
	@CreationTimestamp
	@Column(updatable = false)	// 수정시 관여 안하겠다
	private LocalDateTime createdTime;

	@UpdateTimestamp
	@Column(insertable = false)	// 입력시 관여 안하겠다
	private LocalDateTime updatedTime;
}
