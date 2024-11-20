package student.StudentsManagementSystem.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import student.StudentsManagementSystem.entity.Student;

import java.util.List;

@Service
public class StudentManagement {

    @PersistenceContext
    private EntityManager entityManager;

    // 查詢所有學生
    public List<Student> getAllStudents() {
        String jpql = "SELECT s FROM Student s";
        return entityManager.createQuery(jpql, Student.class).getResultList();
    }

    // 保存學生
    @Transactional
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    // 更新學生
    @Transactional
    public void updateStudent(Long id, double chinese, double english, double math) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            student.setChinese(chinese);
            student.setEnglish(english);
            student.setMath(math);
            entityManager.merge(student);
        }
    }

    @Transactional
    public void updateAverageScore(Long id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            student.setAverageScore();
            entityManager.merge(student);
        }
    }

}
