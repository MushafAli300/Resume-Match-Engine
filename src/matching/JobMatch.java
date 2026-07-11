package matching;

import utils.JobPosting;
import java.util.List;

public class JobMatch {

    private JobPosting job;
    private double score;
    private List<String> matchedSkills;
    private List<String> missingSkills;

    public JobMatch(JobPosting job, double score,
                    List<String> matchedSkills,
                    List<String> missingSkills) {
        this.job = job;
        this.score = score;
        this.matchedSkills = matchedSkills;
        this.missingSkills = missingSkills;
    }

    public JobPosting getJob() {
        return job;
    }

    public double getScore() {
        return score;
    }

    public List<String> getMatchedSkills() {
        return matchedSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    @Override
    public String toString() {
        return "Company: " + job.getCompany() +
                "\nTitle: " + job.getTitle() +
                "\nScore: " + score + "%" +
                "\nMatched Skills: " + matchedSkills +
                "\nMissing Skills: " + missingSkills;
    }
}