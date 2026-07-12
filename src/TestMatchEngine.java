import matching.MatchEngine;
import matching.JobMatch;
import utils.JobPosting;

import java.util.*;

public class TestMatchEngine {

    public static void main(String[] args) {

        List<String> resume = Arrays.asList(
                "Java",
                "Spring Boot",
                "Git",
                "MySQL"
        );

        List<JobPosting> jobs = new ArrayList<>();

        jobs.add(new JobPosting(
                1,
                "Java Developer",
                "Systems Ltd",
                Arrays.asList(
                        "Java",
                        "Spring Boot",
                        "Git",
                        "Docker"
                ),
                2,
                "Islamabad",
                "Backend Developer"
        ));

        jobs.add(new JobPosting(
                2,
                "Python Developer",
                "Tech House",
                Arrays.asList(
                        "Python",
                        "Django",
                        "Git"
                ),
                1,
                "Lahore",
                "Python Backend"
        ));

        jobs.add(new JobPosting(
                3,
                "Backend Engineer",
                "ABC Software",
                Arrays.asList(
                        "Java",
                        "MySQL",
                        "REST API",
                        "Git"
                ),
                3,
                "Remote",
                "Java Backend"
        ));

        MatchEngine engine = new MatchEngine();

        List<JobMatch> results =
                engine.getTopMatches(resume, jobs, 5);

        for (JobMatch job : results) {

            System.out.println("--------------------------------");

            System.out.println(job);

            System.out.println("--------------------------------");
        }
    }
}