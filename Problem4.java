import java.util.*;

class AnalyticsStore {
    public void storeActions(Queue<ActionEnum> q) {
        for (ActionEnum action : q) {
            System.out.print(action + " ");
        }
        System.out.println();
    }
}

enum ActionEnum {
    feature1Button, feature2Button, feature3Button
}

class Analytics {
    private final AnalyticsStore store;
    private final int K;
    private final Queue<ActionEnum> buffer;
    private int totalLogged = 0;
    private final Map<ActionEnum, Integer> frequencyMap;

    public Analytics(AnalyticsStore analyticsStore, int K) {
        this.store = analyticsStore;
        this.K = K;
        this.buffer = new LinkedList<>();
        this.frequencyMap = new HashMap<>();
    }

    public void registerAction(ActionEnum action) {
        buffer.add(action);
        frequencyMap.put(action, frequencyMap.getOrDefault(action, 0) + 1);
        totalLogged++;

        if (buffer.size() == K) {
            store.storeActions(new LinkedList<>(buffer));
            buffer.clear();
        }
    }

    public int getNumberOfActionRegisteredButNotSentToAnalyticsStore() {
        return buffer.size();
    }

    public int getTotalNumberOfLoggedActions() {
        return totalLogged;
    }

    public List<ActionEnum> getMostFrequentlyUsedActions() {
        int maxFreq = Collections.max(frequencyMap.values());

        List<ActionEnum> mostFrequent = new ArrayList<>();
        for (Map.Entry<ActionEnum, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                mostFrequent.add(entry.getKey());
            }
        }
        return mostFrequent;
    }
}
