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
        String sql = "SELECT * FROM Kjop ORDER BY etternavn DESC;";
        List<Kjop> alleBilletter = db.query(sql, new BeanPropertyRowMapper<>(Kjop.class));
        return alleBilletter;
    }


    public Kjop hentEnBillett(int id) {
        Object[] param = new Object[1];
        param[0] = id;
        String sql = "SELECT * FROM Kjop WHERE id=?";
        Kjop billett = db.queryForObject(sql, param, BeanPropertyRowMapper.newInstance(Kjop.class));
        return billett;
    }
    public void endreBillett(Kjop kjop){
        String sql = "UPDATE Kjop SET film=?,antall=?, fornavn=?, etternavn=?, epost=?, telefon=? WHERE id=?";
        db.update(sql, kjop.getFilm(), kjop.getAntall(), kjop.getFornavn(), kjop.getEtternavn(), kjop.getEpost(), kjop.getTelefon(), kjop.getId());
    }

    public void slettAlle() {
        String sql = "DELETE FROM Kjop;";
        db.update(sql);
    }

    public void slettEn (int id) {
        String sql = "DELETE FROM Kjop WHERE id=?;";
        db.update(sql, id);
    }
}
