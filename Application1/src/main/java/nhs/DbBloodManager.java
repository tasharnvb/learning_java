package nhs;

import session.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Collection;

/**
 * Created by Academy07 on 08/08/2016.
 */
public class DbBloodManager implements IBloodManager {
    @Override
    public int addBloodTest(BloodTest bloodTest) {
        int id = 0;
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(bloodTest);// persists a transient instance
        id = bloodTest.getId();
        em.getTransaction().commit();// updates the database from the persistence context
        em.close();
        return id;
    }

    @Override
    public void addPatient(Patient patient) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(patient);// persists a transient instance
        em.getTransaction().commit();// updates the database from the persistence context
        em.close();
    }

    @Override
    public Collection<Patient> selectAllPatients() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        String jpql = "select p from Patient p";
        TypedQuery<Patient> query = em.createQuery(jpql, Patient.class);
        Collection<Patient> patients = query.getResultList();
        em.close();
        return patients;

    }

    @Override
    public Collection<String> search(int level, int days) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        String jpql = "select b.patient.name from BloodTest b where b.redCellCount < :level and b.testDate > :date";
        TypedQuery<String> query = em.createQuery(jpql, String.class);
        query.setParameter("level", level);
        query.setParameter("date", LocalDate.now().minusDays(days));
        Collection<String> patients = query.getResultList();
        em.close();
        return patients;
    }

    @Override
    public Patient selectPatientByNhsNumber(String nhsNumber) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Patient patient = em.find(Patient.class, nhsNumber);
        em.close();
        return patient;

    }
}
