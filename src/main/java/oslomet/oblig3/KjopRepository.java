package oslomet.oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KjopRepository {

    @Autowired
    private JdbcTemplate db;

    public void lagre(Kjop kjop) {
        String sql = "INSERT INTO Kjop (film, antall, fornavn, etternavn, epost, telefon) VALUES (?, ?, ?, ?, ?, ?);";
        db.update(sql, kjop.getFilm(), kjop.getAntall(), kjop.getFornavn(), kjop.getEtternavn(), kjop.getEpost(), kjop.getTelefon());
    }

    public List<Kjop> hentAlle() {
        String sql = "SELECT * FROM Kjop;";
        List<Kjop> alleBilletter = db.query(sql, new BeanPropertyRowMapper<>(Kjop.class));
        return alleBilletter;
    }

    public void slettAlle() {
        String sql = "DELETE * FROM Kjop;";
        db.update(sql);
    }

    public void slettEn (int id) {
        String sql = "DELETE FROM Kjop WHERE id=?;";
        db.update(sql, id);
    }
}
