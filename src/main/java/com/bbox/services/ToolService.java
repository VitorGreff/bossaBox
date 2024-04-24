package com.bbox.services;

import com.bbox.domain.Tool;
import com.bbox.repositories.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ToolService {
    @Autowired
    private ToolRepository toolRepository;
    public Tool insertTool(Tool tool) {
        return toolRepository.save(tool);
    }
    public List<Tool> getTools() {
        return toolRepository.findAll();
    }
    public Tool getTool(UUID id){
        return toolRepository.findById(id).orElse(null);
    }
    public List<Tool> getToolsByTag(String tag){
        return toolRepository.findByTag(tag);
    }
    public void deleteTool(UUID id){
        toolRepository.deleteById(id);
    }
}
