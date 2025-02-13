package com.IFA.service;

import com.IFA.entity.CompanyProfile;
import com.IFA.repository.CompanyProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyProfileService {

    private final CompanyProfileRepository companyProfileRepository;

    public CompanyProfileService(CompanyProfileRepository companyProfileRepository) {
        this.companyProfileRepository = companyProfileRepository;
    }

    public CompanyProfile createCompanyProfile(CompanyProfile companyProfile) {
        return companyProfileRepository.save(companyProfile);
    }

    public List<CompanyProfile> getAllCompanyProfiles() {
        return companyProfileRepository.findAll();
    }

    public Optional<CompanyProfile> getCompanyProfileByGstn(String gstnNo) {
        return companyProfileRepository.findById(gstnNo);
    }

    public CompanyProfile updateCompanyProfile(String gstnNo, CompanyProfile updatedCompanyProfile) {
        return companyProfileRepository.findById(gstnNo)
                .map(existingProfile -> {
                    existingProfile.setCompanyName(updatedCompanyProfile.getCompanyName());
                    existingProfile.setCompanyAddress(updatedCompanyProfile.getCompanyAddress());
                    existingProfile.setCompanyEmail(updatedCompanyProfile.getCompanyEmail());
                    existingProfile.setCompanyPhone(updatedCompanyProfile.getCompanyPhone());
                    existingProfile.setCompanyWebsite(updatedCompanyProfile.getCompanyWebsite());
                    existingProfile.setBusinessType(updatedCompanyProfile.getBusinessType());
                    existingProfile.setCompanyLogo(updatedCompanyProfile.getCompanyLogo());
                    existingProfile.setCompanyDescription(updatedCompanyProfile.getCompanyDescription());
                    existingProfile.setCompanyIndustry(updatedCompanyProfile.getCompanyIndustry());
                    existingProfile.setCompanyCountry(updatedCompanyProfile.getCompanyCountry());
                    existingProfile.setCompanyState(updatedCompanyProfile.getCompanyState());
                    existingProfile.setCompanyCity(updatedCompanyProfile.getCompanyCity());
                    existingProfile.setCompanyPinCode(updatedCompanyProfile.getCompanyPinCode());
                    existingProfile.setBalanceSheet(updatedCompanyProfile.getBalanceSheet());
                    return companyProfileRepository.save(existingProfile);
                })
                .orElseThrow(() -> new RuntimeException("Company Profile not found for GSTN: " + gstnNo));
    }

    public void deleteCompanyProfile(String gstnNo) {
        companyProfileRepository.deleteById(gstnNo);
    }
}
