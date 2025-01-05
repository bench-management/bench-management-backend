package BenchManagementTool.BMT.lib;

public class Utils {
    public enum Skill {
        JAVA, SPRING_BOOT, ANGULAR, REACT, MONGODB, MYSQL, OTHER
    }

    public enum Location {
        MUMBAI, BANGALORE, CHENNAI, HYDERABAD, GURGAON, NCR, OTHER
    }

    public enum Status {
        RESIGNED, SABBATICAL, UNDER_EVALUATION, ONBOARDING_IN_PROGRESS, ONBOARDED, INTERVIEW_IN_PROGRESS
    }

    public enum InterviewStatus {
        SCHEDULED,
        ONGOING,
        REJECTED,
        SELECTED
    }
}
