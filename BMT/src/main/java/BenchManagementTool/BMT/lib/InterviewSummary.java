package BenchManagementTool.BMT.lib;

import java.util.Date;
import lombok.*;

@Setter
@Getter
public class InterviewSummary {
    private String interviewId;
    private String interviewerName;
    private Date date;

    public InterviewSummary(String interviewId, String interviewerName, Date date) {
        this.interviewId = interviewId;
        this.interviewerName = interviewerName;
        this.date = date;
    }
}
