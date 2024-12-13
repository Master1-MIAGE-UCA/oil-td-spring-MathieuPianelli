package unica.M1.Miage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DiceController {

    private final Dice dice;
    private final DiceRollLogRepository repository;
    private final DiceService diceService;

    @Autowired
    public DiceController(Dice dice, DiceRollLogRepository repository, DiceService diceService) {
        this.dice = dice;
        this.repository = repository;
        this.diceService = diceService;
    }

    @GetMapping("/rollDice")
    public int rollSingleDice() {
        int result = dice.roll(6);
        saveLog(1, List.of(result));
        return result;
    }

    @GetMapping("/rollDices/{count}")
    public List<Integer> rollMultipleDices(@PathVariable int count) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(dice.roll(6));
        }
        saveLog(count, results);
        return results;
    }

    @GetMapping("/diceLogs")
    public List<DiceRollLog> getDiceLogs() {
        return diceService.getAllLogs();
    }

    private void saveLog(int diceCount, List<Integer> results) {
        DiceRollLog log = new DiceRollLog(diceCount, results, LocalDateTime.now());
        repository.save(log);
    }
}
