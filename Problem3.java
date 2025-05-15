import java.util.*;

public class Problem3 {
    public List<List<String>> extractErrorLogs(List<List<String>> logs){
        List<List<String>> tasks = new ArrayList<>();

        for(List<String>log:logs){
            String taskStatus = log.get(2);
            if(taskStatus.equals("ERROR")||taskStatus.equals("CRITICAL")){
                tasks.add(log);
            }
        }

        tasks.sort((log1, log2)->{
            String a = log1.get(0)+" "+log1.get(1);
            String b = log2.get(0)+" "+log2.get(1);

            return a.compareTo(b);
        });

        return tasks;
    }
}
