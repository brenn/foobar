package no.bouvet.gitskole;

import no.bouvet.gitskole.ssb.SsbGateway;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    @GetMapping("/fylke")
    public String index(@RequestParam String navn, Model model) {
        model.addAttribute("fylke", navn);
        model.addAttribute("kode", SsbGateway.fylkesKode(navn));
        return "index";
    }


}
