package Hospital.model.service;

import Hospital.model.entity.Patient;
import Hospital.model.repository.PatientDA;

import java.util.List;

public class PatientService {

    private PatientService() {
    }

    private static PatientService service = new PatientService();

    public static PatientService getInstance() {
        return service;
    }

    public void save(Patient person) throws Exception {
        try (PatientDA personDA = new PatientDA()) {
            person.setId((int) (person.getId() - (person.getId() * 10) / 100));
            personDA.insert(person);
        }

    }

    public void update(Patient person) throws Exception {
        try (PatientDA personDA = new PatientDA()) {
            personDA.update(person);
        }
    }

    public void remove(String family) throws Exception {
        try (PatientDA personDA = new PatientDA()) {
            personDA.delete(family);
        }
    }

    public List<Patient> findAll() throws Exception {
        try (PatientDA personDA = new PatientDA()) {
            return personDA.selectAll();
        }
    }

    public Patient findOneByFamily(String family) throws Exception {
        try (PatientDA personDA = new PatientDA()) {
            return personDA.selectOne(family);
        }
    }
}
