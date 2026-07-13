package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ResumeParser {

    private static final List<String> SKILLS_DICTIONARY = Arrays.asList(
            "java",
            "python",
            "javascript",
            "html",
            "css",
            "react",
            "sql",
            "mysql",
            "git",
            "docker",
            "spring",
            "c++",
            "c",
            "php"
    );

    public ArrayList<String> parse(String rawText) {

        ArrayList<String> skills = new ArrayList<>();

        rawText = rawText.toLowerCase();

        for (String skill : SKILLS_DICTIONARY) {

            if (rawText.contains(skill.toLowerCase())) {

                skills.add(skill);

            }

        }

        return normalizeSkills(skills);

    }

    private ArrayList<String> normalizeSkills(ArrayList<String> skills) {

        Set<String> uniqueSkills = new LinkedHashSet<>();

        for (String skill : skills) {

            uniqueSkills.add(skill.trim().toLowerCase());

        }

        return new ArrayList<>(uniqueSkills);

    }

}