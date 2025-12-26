@RestController
@RequestMapping("/api/rewards")
public class RewardRuleController {

    private final RewardRuleService service;

    public RewardRuleController(RewardRuleService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public String test() {
        return "Reward rule service working";
    }
}
