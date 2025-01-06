package like_book.services;

import like_book.models.entities.Mood;
import like_book.models.enums.MoodType;

import java.util.Set;

public interface MoodService {

    public void createMood(Mood mood);
    public Set<Mood> getAllMoods();
    public Mood getByMoodType(MoodType moodType);
}
