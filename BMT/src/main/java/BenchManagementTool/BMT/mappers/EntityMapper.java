package BenchManagementTool.BMT.mappers;

import BenchManagementTool.BMT.dto.*;
import BenchManagementTool.BMT.lib.InterviewSummary;
import BenchManagementTool.BMT.lib.Utils;
import BenchManagementTool.BMT.models.*;

import java.util.List;
import java.util.stream.Collectors;

public class EntityMapper {
    public static CandidateDTO toCandidateDTO(Candidate candidate) {
        return CandidateDTO.builder()
                .id(candidate.getId())
                .empId(candidate.getEmpId())
                .name(candidate.getName())
                .skill(candidate.getSkill())
                .pastExperience(candidate.getPastExperience())
                .baseLocation(candidate.getBaseLocation())
                .currentLocation(candidate.getCurrentLocation())
                .status(candidate.getStatus())
                .accoliteDoj(candidate.getAccoliteDoj())
                .onBench(candidate.isOnBench())
                .benchStartDate(candidate.getBenchStartDate())
                .clientId(candidate.getClient() != null ? candidate.getClient().getId() : null)
                .tentativeOnboardingDate(candidate.getTentativeOnboardingDate())
                .remarks(candidate.getRemarks())
                .mentorship(candidate.getMentorship())
                .thLink(candidate.getThLink())
                .lwdInAccolite(candidate.getLwdInAccolite())
                .projectType(candidate.getProjectType())
                .projectAllocationStatus(candidate.getProjectAllocationStatus())
                .selectionDate(candidate.getSelectionDate())
                .onboardingDate(candidate.getOnboardingDate())
                .interviewIds(candidate.getInterviewIds())
                .build();
    }

    public static Candidate toCandidate(CandidateDTO dto, Client client) {
        return Candidate.builder()
                .id(dto.getId())
                .empId(dto.getEmpId())
                .name(dto.getName())
                .skill(dto.getSkill())
                .pastExperience(dto.getPastExperience())
                .baseLocation(dto.getBaseLocation())
                .currentLocation(dto.getCurrentLocation())
                .status(dto.getStatus())
                .accoliteDoj(dto.getAccoliteDoj())
                .onBench(dto.isOnBench())
                .benchStartDate(dto.getBenchStartDate())
                .client(client)
                .tentativeOnboardingDate(dto.getTentativeOnboardingDate())
                .remarks(dto.getRemarks())
                .mentorship(dto.getMentorship())
                .thLink(dto.getThLink())
                .lwdInAccolite(dto.getLwdInAccolite())
                .projectType(dto.getProjectType())
                .projectAllocationStatus(dto.getProjectAllocationStatus())
                .selectionDate(dto.getSelectionDate())
                .onboardingDate(dto.getOnboardingDate())
                .interviewIds(dto.getInterviewIds())
                .build();
    }

    public static ClientDTO toClientDTO(Client client) {
        return ClientDTO.builder()
                .id(client.getId())
                .clientId(client.getClientId())
                .clientName(client.getClientName())
                .location(client.getLocation())
                .businessUnit(client.getBusinessUnit())
                .build();
    }

    public static Client toClient(ClientDTO dto) {
        return Client.builder()
                .id(dto.getId())
                .clientId(dto.getClientId())
                .clientName(dto.getClientName())
                .location(dto.getLocation())
                .businessUnit(dto.getBusinessUnit())
                .build();
    }

    public static InterviewDTO toInterviewDTO(Interview interview) {
        return InterviewDTO.builder()
                .id(interview.getId())
                .clientId(interview.getClient() != null ? interview.getClient().getId() : null)
                .candidateId(interview.getCandidate() != null ? interview.getCandidate().getId() : null)
                .interviewerName(interview.getInterviewerName())
                .interviewStatus(interview.getInterviewStatus())
                .interviewDate(interview.getInterviewDate())
                .project(interview.getProject())
                .clientRequirement(interview.getClientRequirement())
                .accoliteHiringManager(interview.getAccoliteHiringManager())
                .clientHiringManager(interview.getClientHiringManager())
                .department(interview.getDepartment())
                .comments(interview.getComments())
                .build();
    }

    public static Interview toInterview(InterviewDTO dto, Client client, Candidate candidate) {
        return Interview.builder()
                .id(dto.getId())
                .client(client)
                .candidate(candidate)
                .interviewerName(dto.getInterviewerName())
                .interviewStatus(dto.getInterviewStatus())
                .interviewDate(dto.getInterviewDate())
                .project(dto.getProject())
                .clientRequirement(dto.getClientRequirement())
                .accoliteHiringManager(dto.getAccoliteHiringManager())
                .clientHiringManager(dto.getClientHiringManager())
                .department(dto.getDepartment())
                .comments(dto.getComments())
                .build();
    }
}