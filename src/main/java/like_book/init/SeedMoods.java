package like_book.init;
import like_book.models.entities.Mood;
import like_book.models.enums.MoodType;
import like_book.services.MoodService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedMoods implements CommandLineRunner {
    private final MoodService moodService;

    public SeedMoods(MoodService moodService) {
        this.moodService = moodService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(this.moodService.getAllMoods().isEmpty()){

            Mood happy = new Mood();
            happy.setMoodType(MoodType.HAPPY);
            happy.setDescription("I am soo happy.");

            Mood excited = new Mood();
            excited.setMoodType(MoodType.EXCITED);
            excited.setDescription("I am soo excited.");

            Mood inspired = new Mood();
            inspired.setMoodType(MoodType.INSPIRED);
            inspired.setDescription("I am soo inspired.");

            Mood newJob = new Mood();
            newJob.setMoodType(MoodType.NEW_JOB);
            newJob.setDescription("I am soo newJob.");

            this.moodService.createMood(happy);
            this.moodService.createMood(excited);
            this.moodService.createMood(inspired);
            this.moodService.createMood(newJob);
        }
    }
}
