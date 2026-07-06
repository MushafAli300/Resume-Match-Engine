package utils;

import java.util.List;

public class JobPosting {

    private int jobId;
    private String title;
    private String company;
    private List<String> requiredSkills;
    private int experienceRequired;
    private String location;
    private String description;

    // Constructor
    public JobPosting(int jobId, String title, String company,
                      List<String> requiredSkills,
                      int experienceRequired,
                      String location,
                      String description) {

        this.jobId = jobId;
        this.title = title;
        this.company = company;
        this.requiredSkills = requiredSkills;
        this.experienceRequired = experienceRequired;
        this.location = location;
        this.description = description;
    }

    // Getters
    public int getJobId() {
        return jobId;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public int getExperienceRequired() {
        return experienceRequired;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setRequiredSkills(List<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public void setExperienceRequired(int experienceRequired) {
        this.experienceRequired = experienceRequired;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "JobPosting{" +
                "jobId=" + jobId +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", requiredSkills=" + requiredSkills +
                ", experienceRequired=" + experienceRequired +
                ", location='" + location + '\'' +
                '}';
    }
}