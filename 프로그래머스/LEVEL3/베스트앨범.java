import java.util.*;

//plays 우선순위 정렬
class PlaysComparator implements Comparator<Plays> {
    @Override
    public int compare(Plays o1, Plays o2) {
        return o1.plays - o2.plays;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // int[] answer = {};
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Map<String,Genre> genresMap=new HashMap();
        
        for(int i = 0; i < genres.length; i++) {
            Plays newPlays = new Plays(i,plays[i]);
            if(!genresMap.containsKey(genres[i])) {
                genresMap.put(genres[i],new Genre(genres[i], newPlays));
            } else {
                Genre genre = genresMap.get(genres[i]);
                genre.addGenre(newPlays);
                genresMap.put(genres[i],genre);
            }
        }
        
        List<String> keySet = new ArrayList<>(genresMap.keySet());
        
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return genresMap.get(o2).getTotalPlays()-genresMap.get(o1).getTotalPlays();
            }
        });
        
        for (String key : keySet) {
            PriorityQueue<Plays> priorityQueue = genresMap.get(key).getPlayQueue();
            for(int i = 0; i < 2; i++) {
                if(priorityQueue.isEmpty()){
                    break;
                }
                answer.add(priorityQueue.poll().index);
            }
        }
        
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

class Genre {
    private String genre;
    private int totalPlays;
    PriorityQueue<Plays> priorityQueue = new PriorityQueue<>();
    
    public Genre(String genre, Plays plays) {
        this.genre = genre;
        this.totalPlays = plays.plays;
        this.priorityQueue.offer(plays);
    }
    
    public void addGenre(Plays plays) {
        this.totalPlays += plays.plays;
        this.priorityQueue.offer(plays);
    }
    
    public int getTotalPlays() {
        return totalPlays;
    }
    
    public PriorityQueue<Plays> getPlayQueue() {
        return priorityQueue;
    }
}


class Plays implements Comparable<Plays> {
    int index;
    int plays;
    
    public Plays(int index, int plays) {
        this.index = index;
        this.plays = plays;
    }
    
    @Override
    public int compareTo(Plays plays) {
        return plays.plays - this.plays;
    }
}