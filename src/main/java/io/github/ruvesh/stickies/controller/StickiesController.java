package io.github.ruvesh.stickies.controller;

import io.github.ruvesh.stickies.service.NoteService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StickiesController {

    @Autowired
    NoteService noteService;

    @GetMapping(value = "/")
    public ModelAndView indexPageHandler(Principal principal){
    	String username = principal.getName();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("notes", noteService.getNotesByUser(username));
        modelAndView.addObject("username", username);
        return modelAndView;
    }

    @PostMapping(value = "/")
    public String saveNote(@RequestParam(name = "content") String content, Principal principal){
        noteService.saveNoteByUser(content, principal.getName());
       return "redirect:/";
    }

    @PostMapping(value = "/edit-note")
    public ModelAndView editNoteTemplate(@RequestParam(name = "id") Long id, Principal principal){
    	String username = principal.getName();
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("notes", noteService.getNotesByUser(username));
        modelAndView.addObject("existing_note", noteService.getNoteById(id));
        modelAndView.addObject("username", username);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public String editNote(@RequestParam(name = "id") Long id, @RequestParam(name = "content") String newContent){
        noteService.editNote(id, newContent);
        return "redirect:/";
    }

    @PostMapping(value = "/delete-note")
    public String deleteNote(@RequestParam(name = "id") Long id){
        noteService.deleteNoteById(id);
        return "redirect:/";
    }
}
