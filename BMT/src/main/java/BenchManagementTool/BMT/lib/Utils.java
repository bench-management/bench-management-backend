package BenchManagementTool.BMT.lib;

import BenchManagementTool.BMT.serde.BaseLocationDeserializer;
import BenchManagementTool.BMT.serde.SkillDeserializer;
import BenchManagementTool.BMT.serde.StatusDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {
    public enum Skill {
        JAVA,
        SPRING_BOOT,
        ANGULAR,
        REACT,
        MONGODB,
        MYSQL,
        PYTHON,
        FULLSTACK,
        QA,
        DB,
        ANGULAR_REACT,
        POWER_APP,
        POWER_BI,
        LEAD_APPLICATION_SUPPORT_ENGINEER,
        DATA_SCIENTIST,
        ORACLE_DBA,
        L2_SUPPORT,
        MAINFRAME,
        NONE,
        QA_AUTOMATION;

        public static Skill fromString(String value) {
            try {
                return Skill.valueOf(value.toUpperCase());
            } catch (Exception e) {
                System.out.println(e);
                return NONE;
            }
        }
    }

    public enum Location {
        MUMBAI, BANGALORE, CHENNAI, HYDERABAD, GURGAON, NCR, OTHER;
        public static Location fromString(String value) {
            try {
                return Location.valueOf(value.toUpperCase());
            } catch (Exception e) {
                System.out.println(e);
                return OTHER;
            }
        }
    }

    public enum Status {
        RESIGNED, SABBATICAL, UNDER_EVALUATION, ONBOARDING_IN_PROGRESS, ONBOARDED, INTERVIEW_IN_PROGRESS, ON_HOLD;
        public static Status fromString(String value) {
            try {
                return Status.valueOf(value.toUpperCase());
            } catch (Exception e) {
                System.out.println(e);
                return UNDER_EVALUATION;
            }
        }

    }

    public enum InterviewStatus {
        SCHEDULED,
        ONGOING,
        REJECTED,
        SELECTED;
        public static InterviewStatus fromString(String value) {
            try {
                return InterviewStatus.valueOf(value.toUpperCase());
            } catch (IllegalArgumentException | NullPointerException e) {
                return ONGOING;
            }
        }
    }

    public static String getTodaysDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return today.format(formatter);
    }

    public static ObjectMapper getObjectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Utils.Status.class, new StatusDeserializer());
        module.addDeserializer(Utils.Location.class, new BaseLocationDeserializer());
        module.addDeserializer(Utils.Skill.class, new SkillDeserializer());
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        mapper.registerModule(javaTimeModule);
        mapper.registerModule(module);
        return mapper;
    }
}
