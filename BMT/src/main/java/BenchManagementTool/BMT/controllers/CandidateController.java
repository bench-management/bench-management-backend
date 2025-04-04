package BenchManagementTool.BMT.controllers;
import org.springframework.http.HttpStatus;
import BenchManagementTool.BMT.dto.*;
import BenchManagementTool.BMT.services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import org.springframework.http.HttpHeaders;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private ExportService exportService;

    @Autowired
    private DarwinService darwinService;

    @GetMapping
    public List<CandidateDTO> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @GetMapping("/{id}")
    public CandidateDTO getCandidateById(@PathVariable String id) {
        return candidateService.getCandidateById(id);
    }

    @PostMapping
    public CandidateDTO addCandidate(@Valid @RequestBody CandidateDTO dto) {
        return candidateService.addCandidate(dto);
    }

    @PostMapping("/add")
    public void addCandidate() {
        darwinService.getCandidateDataAndSaveToMongo();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidateDTO> updateCandidate(@PathVariable String id, @Valid @RequestBody CandidateDTO dto) {
        return ResponseEntity.ok(candidateService.updateCandidate(id, dto));
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable String id) {
        candidateService.deleteCandidate(id);
    }

    @GetMapping("/search")
    public List<CandidateDTO> searchCandidate(@RequestParam String searchTerm) {
        return candidateService.searchCandidates(searchTerm);
    }
    @GetMapping("/export")
    public ResponseEntity<byte[]> exportCandidates() throws IOException {
        // Fetch the candidate data
        List<CandidateDTO> candidates = candidateService.getAllCandidates();

        // Generate the Excel file content
        byte[] excelData = exportService.exportCandidatesToExcel(candidates);

        // Set headers to indicate file download
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"candidates.xlsx\"");
        headers.setContentLength(excelData.length);

        // Return the file content as a response
        return new ResponseEntity<>(excelData, headers, HttpStatus.OK);
    }

    @PatchMapping("/{id}/remarks")
    public ResponseEntity<CandidateDTO> updateRemarks(@PathVariable String id, @RequestBody RemarksRequest remarks) {
        System.out.println("received: " + id + " -> " + remarks);
        CandidateDTO updatedCandidate = candidateService.updateRemarks(id, remarks.getRemarks());
        return ResponseEntity.ok(updatedCandidate);
    }



    @GetMapping("/historical-bench-count")
    public Map<YearMonth, Long> getHistoricalBenchCount() {
        return candidateService.getHistoricalMonthWiseBenchCount();
    }

}

class RemarksRequest {
    private List<String> remarks;

    // Getter for remarks
    public List<String> getRemarks() {
        return remarks;
    }

    // Setter for remarks
    public void setRemarks(List<String> remarks) {
        this.remarks = remarks;
    }
}

