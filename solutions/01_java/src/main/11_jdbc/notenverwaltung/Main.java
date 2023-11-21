package notenverwaltung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Connection dbConnection;

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mariadb://localhost:3306/grades";
        String username = "root";
        String password = "admin";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // set global dbConnection to remove unnecessary parameter
            dbConnection = connection;
            prepareDb();
            clearDb();

            // add new subject
            int newSubjectId = addSubject("Mathematik");
            Subject subject = getSubjectById(newSubjectId);
            // add grades to new subject
            addGrade(subject.getSubject_id(), 5.5d);
            addGrade(subject.getSubject_id(), 2.25d);
            addGrade(subject.getSubject_id(), 4.75d);

            System.out.println("All grades for " + subject.getName());
            for (Grade grade : getAllGrades()) {
                System.out.println(grade);
                System.out.println();
            }

            // add grade to update
            int updateGradeId = addGrade(subject.getSubject_id(), 3.0d);
            Grade updatedGrade = getGradeById(updateGradeId);
            System.out.println("Before update:");
            System.out.println(updatedGrade);
            updatedGrade.setGrade(4.5d);
            updatedGrade.setDate(LocalDate.now().plusWeeks(2));
            updateGrade(updatedGrade);
            System.out.println("After update:");
            System.out.println(getGradeById(updateGradeId));
            System.out.println();
            System.out.println("The average grade for the subject " + subject.getName() + " is " + getAverageGrade(subject.getSubject_id()));

            int additionalSubjectId = addSubject("Sports");

            System.out.println();
            System.out.println("All subjects:");
            for (Subject sub : getAllSubjects()) {
                System.out.println(sub);
                System.out.println();
            }
            System.out.println();

            removeSubject(additionalSubjectId);

            System.out.println("All subjects after delete:");
            for (Subject sub : getAllSubjects()) {
                System.out.println(sub);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void prepareDb() throws SQLException {
        String createGradesQuery = "CREATE TABLE IF NOT EXISTS grade(" +
                "grade_id INT NOT NULL AUTO_INCREMENT," +
                "grade DOUBLE NOT NULL," +
                "date DATETIME NOT NULL," +
                "PRIMARY KEY (grade_id));";
        String createSubjectQuery = "CREATE TABLE IF NOT EXISTS school_subject (" +
                "subject_id INT NOT NULL AUTO_INCREMENT," +
                "name VARCHAR(100) NOT NULL," +
                "PRIMARY KEY (subject_id))";
        String createSubjectGradeQuery = "CREATE TABLE IF NOT EXISTS school_subject_grade (" +
                "grade_id INT," +
                "subject_id INT," +
                "FOREIGN KEY (subject_id) REFERENCES school_subject (subject_id)," +
                "FOREIGN KEY (grade_id) REFERENCES grade (grade_id))";
        Statement statement = dbConnection.createStatement();
        statement.addBatch(createGradesQuery);
        statement.addBatch(createSubjectQuery);
        statement.addBatch(createSubjectGradeQuery);
        statement.executeBatch();
    }


    private static int addGrade(int subjectId, double grade) throws SQLException {
        String query = "INSERT INTO grade(grade, date) VALUES (?, ?);";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
        preparedStatement.setObject(1, grade);
        preparedStatement.setObject(2, LocalDate.now());
        preparedStatement.executeUpdate();

        String getQuery = "SELECT max(grade_id) FROM grade";
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(getQuery);

        int gradeId = -1;
        while (resultSet.next()) {
            gradeId = resultSet.getInt(1);
        }

        addSubjectGrade(subjectId, gradeId);

        return gradeId;
    }

    private static Grade getGradeById(int gradeId) throws SQLException {
        String query = "SELECT * FROM grade WHERE grade_id = ?";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
        preparedStatement.setObject(1, gradeId);
        ResultSet resultSet = preparedStatement.executeQuery();

        Grade foundGrade = new Grade();
        while (resultSet.next()) {
            foundGrade.setGrade_id(resultSet.getInt(1));
            foundGrade.setGrade(resultSet.getDouble(2));
            foundGrade.setDate(resultSet.getDate(3).toLocalDate());
        }

        return foundGrade;
    }

    private static void updateGrade(Grade updatedGrade) throws SQLException {
        String query = "UPDATE grade " +
                "   SET grade = ?," +
                "   date = ?" +
                "   WHERE grade_id = ?;";
        PreparedStatement statement = dbConnection.prepareStatement(query);
        statement.setObject(1, updatedGrade.getGrade());
        statement.setObject(2, updatedGrade.getDate());
        statement.setObject(3, updatedGrade.getGrade_id());
        statement.executeUpdate();
    }

    private static void removeGrade(int gradeId) throws SQLException {
        String deleteSubjectGrade = "DELETE FROM school_subject_grade WHERE grade_id = " + gradeId + ";";
        Statement statementSubjectGrade = dbConnection.createStatement();
        statementSubjectGrade.executeQuery(deleteSubjectGrade);

        String deleteGradeQuery = "DELETE FROM grade WHERE grade_id = " + gradeId + ";";
        Statement statementGrade = dbConnection.createStatement();
        statementGrade.executeQuery(deleteGradeQuery);
    }

    private static List<Grade> getAllGrades() throws SQLException {
        String query = "SELECT * FROM grade;";
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        List<Grade> grades = new ArrayList<>();
        while (resultSet.next()) {
            grades.add(new Grade(resultSet.getInt(1),
                    resultSet.getDouble(2),
                    resultSet.getDate(3).toLocalDate()));
        }
        return grades;
    }

    private static List<Grade> getGradesFromSubject(int subjectId) throws SQLException {
        String query = "SELECT g.* FROM school_subject AS ss" +
                " JOIN school_subject_grade ssg on ss.subject_id = ssg.subject_id" +
                " JOIN grade g on g.grade_id = ssg.grade_id" +
                " WHERE ss.subject_id = ?;";
        PreparedStatement statement = dbConnection.prepareStatement(query);
        statement.setObject(1, subjectId);
        ResultSet resultSet = statement.executeQuery();

        List<Grade> grades = new ArrayList<>();
        while (resultSet.next()) {
            grades.add(new Grade(resultSet.getInt(1),
                    resultSet.getDouble(2),
                    resultSet.getDate(3).toLocalDate()));
        }
        return grades;
    }

    private static int addSubject(String subjectName) throws SQLException {
        String query = "INSERT INTO school_subject(name) VALUES (?);";
        String getQuery = "SELECT max(subject_id) as subject_id from school_subject;";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
        preparedStatement.setObject(1, subjectName);
        preparedStatement.executeUpdate();

        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(getQuery);

        int createdSubjectId = -1;
        while (resultSet.next()) {
            createdSubjectId = resultSet.getInt(1);
        }
        return createdSubjectId;
    }

    private static void removeSubject(int subjectId) throws SQLException {
        List<Grade> gradesToDelete = getGradesFromSubject(subjectId);
        for (Grade grade : gradesToDelete) {
            removeGrade(grade.getGrade_id());
        }

        String query = "DELETE FROM school_subject WHERE subject_id = " + subjectId + ";";
        Statement statement = dbConnection.createStatement();
        statement.executeQuery(query);
    }

    private static List<Subject> getAllSubjects() throws SQLException {
        String query = "SELECT * FROM school_subject;";
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Subject> subjects = new ArrayList<>();
        while (resultSet.next()) {
            subjects.add(new Subject(resultSet.getInt(1), resultSet.getString(2)));
        }
        return subjects;
    }

    private static Subject getSubjectById(int subjectId) throws SQLException {
        String query = "SELECT * FROM SCHOOL_SUBJECT WHERE subject_id = " + subjectId + ";";
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        Subject resultSubject = new Subject();

        while (resultSet.next()) {
            resultSubject.setSubject_id(resultSet.getInt(1));
            resultSubject.setName(resultSet.getString(2));
        }

        return resultSubject;
    }

    private static double getAverageGrade(int subjectId) throws SQLException {
        String getGrades = "SELECT g.grade FROM school_subject AS ss" +
                "    JOIN grades.school_subject_grade ssg on ss.subject_id = ssg.subject_id" +
                "    JOIN grades.grade g on g.grade_id = ssg.grade_id" +
                "    WHERE ss.subject_id = ?;";
        PreparedStatement statement = dbConnection.prepareStatement(getGrades);
        statement.setObject(1, subjectId);
        ResultSet resultSet = statement.executeQuery();

        int i = 0;
        double gradesSum = 0d;
        while (resultSet.next()) {
            gradesSum += resultSet.getDouble(1);
            i++;
        }
        return roundOrFloor(gradesSum / i);
    }

    private static void addSubjectGrade(int subjectId, int gradeId) throws SQLException {
        // Check if the subject_id exists in the school_subject table
        String checkSubjectQuery = "SELECT COUNT(*) FROM school_subject WHERE subject_id = ?";
        PreparedStatement checkStatement = dbConnection.prepareStatement(checkSubjectQuery);
        checkStatement.setObject(1, subjectId);
        ResultSet subjectResult = checkStatement.executeQuery();

        if (subjectResult.next() && subjectResult.getInt(1) > 0) {
            // Subject exists, proceed with the insert
            String query = "INSERT INTO school_subject_grade (subject_id, grade_id) VALUES (?, ?)";
            PreparedStatement statement = dbConnection.prepareStatement(query);
            statement.setObject(1, subjectId);
            statement.setObject(2, gradeId);
            statement.executeUpdate();
        } else {
            // Handle the case where the subject_id does not exist
            System.err.println("Error: Invalid subject_id.");
        }
    }


    private static double roundOrFloor(double value) {
        double roundedValue = Math.round(value * 4d) / 4d;

        double flooredValue = Math.floor(value * 4d) / 4d;

        double diffRounded = Math.abs(value - roundedValue);
        double diffFloored = Math.abs(value - flooredValue);

        return (diffRounded <= diffFloored) ? roundedValue : flooredValue;
    }

    private static void clearDb() throws SQLException {
        String deleteSubjectGrade = "DELETE FROM school_subject_grade WHERE 1=1;";
        String deleteSubject = "DELETE FROM school_subject WHERE 1=1;";
        String deleteGrade = "DELETE FROM grade WHERE 1=1;";
        Statement statement = dbConnection.createStatement();
        statement.execute(deleteSubjectGrade);
        statement.execute(deleteSubject);
        statement.execute(deleteGrade);
    }
}
