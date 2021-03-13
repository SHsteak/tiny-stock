package com.ts.api.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ts.config.BaseDateEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "user")
public class UserEntity extends BaseDateEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "user_id", nullable = false, length = 20)
	private String userId;

	@Column(name = "user_pw", nullable = false, length = 30)
	private String userPw;

	@Column(name = "user_nm", nullable = false, length = 100)
	private String userNm;
}
