package BenchManagementTool.BMT.services;

import BenchManagementTool.BMT.Repo.MentorRepository;
import BenchManagementTool.BMT.dto.MentorDTO;
import BenchManagementTool.BMT.mappers.EntityMapper;
import BenchManagementTool.BMT.models.Mentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentorService {
    @Autowired
    public MentorRepository mentorRepository;
    public MentorDTO registerMentor(MentorDTO mentorDTO) {
        Mentor mentor = EntityMapper.toMentor(mentorDTO);
        mentor = mentorRepository.save(mentor);
        return EntityMapper.toMentorDTO(mentor);
    }

    public List<MentorDTO> getAllMentors() {
        return mentorRepository.findAll().stream()
                .map(EntityMapper::toMentorDTO)
                .collect(Collectors.toList());
    }
}
