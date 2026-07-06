import utils.JobPosting;
import java.util.Arrays;

public class TestJobPosting {

    public static void main(String[] args) {

        JobPosting job = new JobPosting(
                101,
                "Java Developer",
                "Systems Ltd",
                Arrays.asList("Java", "Spring Boot", "MySQL", "Git"),
                2,
                "Islamabad",
                "Backend Java Developer"
        );

        System.out.println(job);
    }
}