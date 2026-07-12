package matching;

import utils.JobPosting;

import java.util.*;

public class MatchEngine {

    // Match resume against all jobs
    public List<JobMatch> getTopMatches(List<String> resumeSkills,
                                        List<JobPosting> jobs,
                                        int topK) {

        PriorityQueue<JobMatch> pq =
                new PriorityQueue<>(
                        Comparator.comparingDouble(JobMatch::getScore).reversed()
                );

        for (JobPosting job : jobs) {

            List<String> matched = new ArrayList<>();
            List<String> missing = new ArrayList<>();

            int matchedCount = 0;

            for (String required : job.getRequiredSkills()) {

                boolean found = false;

                for (String resume : resumeSkills) {

                    if (resume.equalsIgnoreCase(required)
                            || FuzzyMatcher.isSimilar(resume, required)) {

                        matched.add(required);
                        matchedCount++;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    missing.add(required);
                }
            }

            double score =
                    (double) matchedCount
                            / job.getRequiredSkills().size()
                            * 100;

            pq.add(
                    new JobMatch(
                            job,
                            score,
                            matched,
                            missing
                    )
            );
        }

        List<JobMatch> result = new ArrayList<>();

        while (!pq.isEmpty() && result.size() < topK) {
            result.add(pq.poll());
        }

        return result;
    }
}