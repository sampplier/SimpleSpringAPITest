package com.example.demo.tarefas.api;

import com.example.demo.tarefas.dto.TarefaDTO;
import com.example.demo.tarefas.facade.TarefasFacede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/tarefas",produces = MediaType.APPLICATION_JSON_VALUE)

public class TarefasAPI {
    @Autowired
    private TarefasFacede tarefasFacede;
    @PostMapping
    @ResponseBody
    public TarefaDTO criar(@RequestBody TarefaDTO tarefaDTO){
        return tarefasFacede.criar(tarefaDTO);
    }
    @PutMapping("/{tarefaId}")
    @ResponseBody
    public TarefaDTO atualizar(@PathVariable("tarefaId") Long tarefaId, @RequestBody TarefaDTO tarefaDTO){
        return tarefasFacede.atualizar(tarefaDTO, tarefaId);
    }
    @GetMapping
    @ResponseBody
    public List<TarefaDTO> getAll(){
        return tarefasFacede.getAll();
    }
    @DeleteMapping("/{tarefaId}")
    @ResponseBody
    public String deletar(@PathVariable("tarefaId") Long tarefaId){
        return tarefasFacede.delete(tarefaId);
    }
}
