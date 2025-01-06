package like_book.repositories;

import like_book.models.entities.Mood;
import like_book.models.enums.MoodType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoodRepository extends JpaRepository<Mood,Long> {

    public Mood findByMoodType(MoodType moodType);
}
