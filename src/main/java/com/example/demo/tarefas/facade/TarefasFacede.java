package com.example.demo.tarefas.facade;

import com.example.demo.tarefas.dto.TarefaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TarefasFacede {
    private static final Map<Long, TarefaDTO> tarefas = new HashMap<>();
    public TarefaDTO criar(TarefaDTO tarefaDTO) {
        long proximoId = tarefas.keySet().size() + 1L;
        tarefaDTO.setId(proximoId);
        tarefas.put(proximoId, tarefaDTO);
        return tarefaDTO;
    }
    public TarefaDTO atualizar (TarefaDTO tarefaDTO,Long tarefaId ){
        tarefas.put(tarefaId, tarefaDTO);
        return tarefaDTO;
    }
    public TarefaDTO getById(Long tarefaId){
        return tarefas.get(tarefaId);
    }
    public List<TarefaDTO> getAll(){
        return new ArrayList<>(tarefas.values());
    }
    public String delete(Long tarefaId){
        tarefas.remove(tarefaId);
        return "FOI DE F";
    }
}
