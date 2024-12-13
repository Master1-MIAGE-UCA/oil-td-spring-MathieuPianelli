package unica.M1.Miage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiceService {

    private final Dice dice;
    private final DiceRollLogRepository repository;

    @Autowired
    public DiceService(Dice dice, DiceRollLogRepository repository) {
        this.dice = dice;
        this.repository = repository;
    }

    public List<Integer> rollDices(int count) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(dice.roll(6));
        }
        saveLog(count, results);
        return results;
    }

    public List<DiceRollLog> getAllLogs() {
        return repository.findAll();
    }


    private void saveLog(int diceCount, List<Integer> results) {
        DiceRollLog log = new DiceRollLog(diceCount, results, LocalDateTime.now());
        repository.save(log);
    }
}