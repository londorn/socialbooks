package com.template.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.template.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{

}
