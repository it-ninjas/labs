class StudentEvaluation {
  constructor(name, averageGrade, evaluation) {
    this.name = name;
    this.averageGrade = averageGrade;
    this.evaluation = evaluation;
  }
}

class Student {
  constructor(name, grades) {
    this.name = name;
    this.grades = grades;
  }
}

const students = [];

async function calcAverage() {
  const studentEvaluations = [];
  students.forEach((student) => {
    const avgGrade =
      student.grades.reduce((partialSum, a) => partialSum + a, 0) /
      student.grades.length;
    let evaluation = "";
    switch (true) {
      case avgGrade === 6.0:
        evaluation = "Sehr Gut";
        break;
      case avgGrade >= 5.0:
        evaluation = "Gut";
        break;
      case avgGrade >= 4.0:
        evaluation = "Befriedigend";
        break;
      case avgGrade >= 3.0:
        evaluation = "Ausreichend";
        break;
      default:
        evaluation = "Mangelhaft";
    }
    studentEvaluations.push(
      new StudentEvaluation(student.name, avgGrade, evaluation)
    );
  });
  return studentEvaluations;
}

function addStudent(name, grades) {
  console.log(isNameValid(name));
  if (doesStudentExist(name) || !isNameValid(name)) {
    console.log("student already exists");
    document.getElementById("nameInput").classList.add("invalid");
    document.getElementById("gradesInput").classList.add("invalid");
    return;
  }
  if (!gradesValid(grades)) {
    console.log("grades are invalid");
    document.getElementById("gradesInput").classList.add("invalid");
    return;
  }
  students.push(new Student(name, grades));
  console.log("Student added:", name, grades);
}

function doesStudentExist(name) {
  return students.some((student) => student.name === name);
}

function isNameValid(name) {
  const regex = new RegExp("w+");
  return regex.test(name);
}

function gradesValid(grades) {
  return grades.every(
    (grade) => typeof grade === "number" && grade >= 1 && grade <= 6
  );
}

async function getStudentWithBestAndWorstAverage() {
  let bestStudent;
  let worstStudent;
  const allStudents = await calcAverage();
  allStudents?.forEach((student) => {
    if (!bestStudent || bestStudent.averageGrade < student.averageGrade) {
      bestStudent = student;
    }
    if (!worstStudent || worstStudent.averageGrade > student.averageGrade) {
      worstStudent = student;
    }
  });
  if (bestStudent && worstStudent) {
    fillOutput([bestStudent, worstStudent], "ol");
  }
}

async function getStudentsSortedByAverage() {
  const allStudents = await calcAverage();
  const sortedStudents = allStudents.sort((studentA, studentB) => {
    return studentA.averageGrade > studentB.averageGrade
      ? -1
      : studentA.averageGrade < studentB.averageGrade
      ? 1
      : 0;
  });
  fillOutput(sortedStudents, "ol");
}

async function getAverage() {
  const averageStudents = await calcAverage();
  fillOutput(averageStudents, "ul");
}

function fillOutput(students, listType) {
  clearOutput();
  const outputElement = document.getElementById("action-output");
  let listElement;
  if (students.length > 0) {
    listElement = document.createElement(listType);
  }
  students.forEach((student) => {
    const studentItem = document.createElement("li");
    studentItem.append(
      document.createTextNode(
        student.name + ": " + student.averageGrade + " - " + student.evaluation
      )
    );
    listElement.appendChild(studentItem);
  });
  if (listElement) {
    outputElement.appendChild(listElement);
  }
}

function clearOutput() {
  document.getElementById("action-output").innerHTML = "";
}

function addDefaults() {
  const names = [
    "Emma",
    "Daniel",
    "Olivia",
    "Liam",
    "Sophia",
    "Noah",
    "Ava",
    "Ethan",
    "Mia",
    "William",
    "Charlotte",
    "Benjamin",
    "Amelia",
    "James",
    "Harper",
    "Samuel",
    "Abigail",
    "Jackson",
    "Emily",
    "Henry",
  ];

  for (let i = 0; i < Math.floor(Math.random() * 20 + 1); i++) {
    const grades = [];
    for (let j = 0; j < Math.floor(Math.random() * 10 + 1); j++) {
      // + 1 to include grade 6, * 4 and / 4 to round to next .25 value
      grades.push(Math.round((Math.random() * 5 + 1) * 4) / 4);
    }
    students.push(new Student(names[Math.round(Math.random() * 19)], grades));
  }
}

function resetInvalid(event) {
  event.target.classList = "";
}

document
  .getElementById("add-student-form")
  .addEventListener("submit", function (event) {
    event.preventDefault();
    const name = document.getElementById("nameInput").value;
    const gradesInput = document.getElementById("gradesInput").value;
    const grades = gradesInput.split(",").map((grade) => parseFloat(grade));
    addStudent(name, grades);
  });
