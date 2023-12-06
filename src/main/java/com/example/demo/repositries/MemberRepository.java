package com.example.demo.repositries;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.MemberRegisterForm;

@Repository
public interface MemberRepository extends JpaRepository<MemberRegisterForm, String>{
	Optional<MemberRegisterForm> findById(String id);
	List<MemberRegisterForm> findAll();
}