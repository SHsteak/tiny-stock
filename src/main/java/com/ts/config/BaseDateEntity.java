package com.ts.config;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseDateEntity {
	/* 아래 컬럼은 모든 Table에 자동으로 create, insert, update */

	@CreatedDate
	@Column(name = "reg_date")
	private LocalDateTime regDate;

	@LastModifiedDate
	@Column(name = "mod_date")
	private LocalDateTime modDate;
}
