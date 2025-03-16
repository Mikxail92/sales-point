package edme.sales_point.controller;

import edme.sales_point.dto.TerminalDto;
import edme.sales_point.service.TerminalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-point/terminals")
@RequiredArgsConstructor
public class TerminalController {

    private final TerminalService terminalService;

    @GetMapping
    public ResponseEntity<List<TerminalDto>> getAllTerminals() {
        return ResponseEntity.ok(terminalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TerminalDto> getTerminalById(@PathVariable Long id) {
        return ResponseEntity.ok(terminalService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TerminalDto> createTerminal(@RequestBody TerminalDto terminalDto) {
        return ResponseEntity.ok(terminalService.save(terminalDto));
    }

    @PutMapping("/{id}")
    public TerminalDto updateTerminal(@PathVariable Long id, @RequestBody TerminalDto terminalDto) {
        return terminalService.update(id, terminalDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTerminal(@PathVariable Long id) {
        terminalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
