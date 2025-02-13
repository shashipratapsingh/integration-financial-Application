package com.IFA.controller;

import com.IFA.entity.CompanyProfile;
import com.IFA.service.CompanyProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/companyProfile")
public class CompanyProfileController {

    private final CompanyProfileService companyProfileService;

    public CompanyProfileController(CompanyProfileService companyProfileService) {
        this.companyProfileService = companyProfileService;
    }

    // ✅ Create Company Profile
    @PreAuthorize("hasAuthority('ROLE_Admin')")
    @PostMapping("/")
    public ResponseEntity<CompanyProfile> createCompanyProfile(@RequestBody CompanyProfile companyProfile) {
        return ResponseEntity.ok(companyProfileService.createCompanyProfile(companyProfile));
    }

    // ✅ Get All Company Profiles
    @PreAuthorize("hasAnyAuthority('ROLE_Admin')")
    @GetMapping("/")
    public ResponseEntity<List<CompanyProfile>> getAllCompanyProfiles() {
        return ResponseEntity.ok(companyProfileService.getAllCompanyProfiles());
    }

    // ✅ Get Company Profile by GSTN
    @PreAuthorize("hasAnyAuthority('ROLE_Admin')")
    @GetMapping("/{gstnNo}")
    public ResponseEntity<Optional<CompanyProfile>> getCompanyProfileByGstn(@PathVariable String gstnNo) {
        return ResponseEntity.ok(companyProfileService.getCompanyProfileByGstn(gstnNo));
    }

    // ✅ Update Company Profile
    @PreAuthorize("hasAuthority('ROLE_Admin')")
    @PutMapping("/{gstnNo}")
    public ResponseEntity<CompanyProfile> updateCompanyProfile(
            @PathVariable String gstnNo,
            @RequestBody CompanyProfile updatedCompanyProfile) {
        return ResponseEntity.ok(companyProfileService.updateCompanyProfile(gstnNo, updatedCompanyProfile));
    }

    // ✅ Delete Company Profile
    @PreAuthorize("hasAuthority('ROLE_Admin')")
    @DeleteMapping("/{gstnNo}")
    public ResponseEntity<String> deleteCompanyProfile(@PathVariable String gstnNo) {
        companyProfileService.deleteCompanyProfile(gstnNo);
        return ResponseEntity.ok("Company Profile Deleted Successfully");
    }
}
