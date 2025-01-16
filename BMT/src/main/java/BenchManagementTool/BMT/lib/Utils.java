package BenchManagementTool.BMT.lib;

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
        QA_AUTOMATION
    }

    public enum Location {
        MUMBAI, BANGALORE, CHENNAI, HYDERABAD, GURGAON, NCR, OTHER
    }

    public enum Status {
        RESIGNED, SABBATICAL, UNDER_EVALUATION, ONBOARDING_IN_PROGRESS, ONBOARDED, INTERVIEW_IN_PROGRESS, ON_HOLD
    }

    public enum InterviewStatus {
        SCHEDULED,
        ONGOING,
        REJECTED,
        SELECTED
    }
}
