package oslomet.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KjopController {
    @Autowired
    KjopRepository rep;

    @PostMapping("/lagre")
    public void lagre(Kjop kjop) {
        rep.lagre(kjop);
    }

    @GetMapping("/hentAlle")
    public List<Kjop> hentAlle() {
        return rep.hentAlle();
    }

    @GetMapping("/slettAlle")
    public void slettAlle() {
        rep.slettAlle();
    }

    @GetMapping("/slettEn")
    public void slettEn(int id) {
        rep.slettEn(id);
    }
}
