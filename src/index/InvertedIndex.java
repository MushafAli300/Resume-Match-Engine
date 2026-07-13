package index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class InvertedIndex {

    private HashMap<String, ArrayList<String>> index;

    public InvertedIndex() {
        index = new HashMap<>();
    }

    public void addPosting(String skill, String jobId) {
        skill = skill.toLowerCase();

        if (!index.containsKey(skill)) {
            index.put(skill, new ArrayList<>());
        }

        index.get(skill).add(jobId);
    }

    public ArrayList<String> getPostings(String skill) {
        skill = skill.toLowerCase();
        return index.getOrDefault(skill, new ArrayList<>());
    }

    public Set<String> getAllSkills() {
        return index.keySet();
    }

    public void printIndex() {
        for (String skill : index.keySet()) {
            System.out.println(skill + " -> " + index.get(skill));
        }
    }
}