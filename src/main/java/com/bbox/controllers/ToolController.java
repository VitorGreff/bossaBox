package com.bbox.controllers;

import com.bbox.domain.Tool;
import com.bbox.services.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/tools")
public class ToolController {
    @Autowired
    private ToolService toolService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Tool>> getTools(@RequestParam(required = false) String tag) {
        if (tag != null) {
            List<Tool> tools = toolService.getToolsByTag(tag);
            if (tools.isEmpty())
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(tools);
            return ResponseEntity.status(HttpStatus.OK).body(tools);
        }
        List<Tool> tools = toolService.getTools();
        if (tools.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(tools);
        return ResponseEntity.ok().body(tools);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Tool> createTool(@RequestBody Tool tool) {
        Tool t = toolService.insertTool(tool);
        return ResponseEntity.status(HttpStatus.CREATED).body(t);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteTool(@PathVariable UUID id) {
        Tool tool = toolService.getTool(id);
        if (tool == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        toolService.deleteTool(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
