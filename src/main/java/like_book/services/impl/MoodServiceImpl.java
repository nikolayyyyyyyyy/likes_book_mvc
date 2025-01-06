package like_book.services.impl;
import jakarta.transaction.Transactional;
import like_book.models.entities.Mood;
import like_book.models.enums.MoodType;
import like_book.repositories.MoodRepository;
import like_book.services.MoodService;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class MoodServiceImpl implements MoodService {
    private final MoodRepository moodRepository;

    public MoodServiceImpl(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void createMood(Mood mood) {
        this.moodRepository.save(mood);
    }

    @Override
    public Set<Mood> getAllMoods() {
        if(this.moodRepository.findAll().isEmpty()){
            return new HashSet<>();
        }
        return new HashSet<>(this.moodRepository.findAll());
    }

    @Override
    public Mood getByMoodType(MoodType moodType) {
        return this.moodRepository.findByMoodType(moodType);
    }
}
