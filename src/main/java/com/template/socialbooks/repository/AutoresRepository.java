package com.template.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.template.socialbooks.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long>{

}
