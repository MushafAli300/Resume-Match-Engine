package utils;

import utils.JobPosting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    public static List<JobPosting> loadJobs(String filePath) {

        List<JobPosting> jobs = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length >= 4) {

                    int jobId = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String company = parts[2];

                    String[] skillArray = parts[3].split(";");

                    List<String> skills = new ArrayList<>();

                    for (String skill : skillArray) {
                        skills.add(skill.trim());
                    }

                    int experience = Integer.parseInt(parts[4]);
                    String location = parts[5];
                    String description = parts[6];

                    JobPosting job = new JobPosting(
                            jobId,
                            title,
                            company,
                            skills,
                            experience,
                            location,
                            description
                    );

                    jobs.add(job);
                }
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }

        return jobs;
    }
}