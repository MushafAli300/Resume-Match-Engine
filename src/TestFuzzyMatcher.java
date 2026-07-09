import matching.FuzzyMatcher;

import java.util.Arrays;
import java.util.List;

public class TestFuzzyMatcher {

    public static void main(String[] args) {

        System.out.println("Edit Distance:");
        System.out.println(
                FuzzyMatcher.editDistance("Pyhton", "Python")
        );

        System.out.println();

        System.out.println("Similarity Test:");
        System.out.println(
                FuzzyMatcher.isSimilar("Pyhton", "Python")
        );

        List<String> skills = Arrays.asList(
                "Java",
                "Python",
                "Spring Boot",
                "MySQL",
                "Docker"
        );

        System.out.println();

        System.out.println("Closest Skill:");
        System.out.println(
                FuzzyMatcher.findClosestSkill("Pyhton", skills)
        );
    }
}