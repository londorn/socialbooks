package com.template.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.template.socialbooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long> {

}
