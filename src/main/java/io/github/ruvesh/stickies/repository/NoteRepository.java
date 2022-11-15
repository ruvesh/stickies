package io.github.ruvesh.stickies.repository;

import io.github.ruvesh.stickies.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findAllByUserName(String user);

}
