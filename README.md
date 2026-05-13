# Hospital Appointment Management System

## Project Title
Hospital Appointment Management System

---

## Team Members

| Roll Number | Name | Role |
|---|---|---|
| AM.SC.U4AIE25049 | Deepak Prathap | System Design & UML Modelling |
| AM.SC.U4AIE25040 | Amal Sankar | Java Implementation & Testing |
| AM.SC.U4AIE25068 | Ithihas Suresh | Documentation & Use-Case Design |
| AM.SC.U4AIE25046 | B.Harisankar | Project Integration & Repository Management |

---

## Problem Description

In many hospitals, appointments are still booked manually, which often leads to scheduling conflicts, long waiting times, and inefficient management of patient records.

This Hospital Appointment Management System is designed using Object-Oriented Programming concepts in Java to simplify and automate hospital appointment handling. The system allows:

- Patients to book, view, and cancel appointments
- Doctors to manage schedules and confirm appointments
- Receptionists to organize bookings
- Storage of medical records digitally

The project demonstrates key OOP principles such as:
- Abstraction
- Encapsulation
- Inheritance
- Polymorphism

---

## Features

- Add multiple doctors
- Add multiple patients
- View doctor schedules
- Book appointments
- Detect appointment conflicts
- Cancel appointments
- Add medical records
- Generate appointment reports

---

## Tools and Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Git & GitHub
- UML Diagrams
- VS Code / IntelliJ IDEA / Eclipse

---

## Project Structure

```text
CaseStudy/
│
├── Main.java
├── Person.java
├── Patient.java
├── Doctor.java
├── Receptionist.java
├── Appointment.java
├── Schedule.java
├── MedicalRecord.java
└── HospitalSystem.java
```

---

## How to Run the Code

### Prerequisites

- Java JDK 8 or above installed
- Any Java IDE or terminal

### Steps

1. Clone the repository

```bash
git clone https://github.com/Harisankar005/22AIE111_CaseStudy_3
```

2. Open the project folder

3. Compile all Java files

```bash
javac CaseStudy/*.java
```

4. Run the program

```bash
java CaseStudy.Main
```

---

## Sample Input / Output

### Sample Menu

```text
================================
 HOSPITAL MANAGEMENT SYSTEM
================================

1. Add Doctor
2. Add Patient
3. View Doctors
4. Book Appointment
5. View Patient Appointments
6. Cancel Appointment
7. Add Medical Record
8. Generate Report
9. Exit
```

---

### Sample Input

```text
Enter choice: 1

Enter Doctor ID: 101
Enter Doctor Name: Arun
Enter Contact Number: 9876543210
Enter Specialization: Cardiologist

Enter number of slots: 2

Enter slot 1: 10:00 AM
Enter slot 2: 11:00 AM
```

---

### Sample Output

```text
Slot added: 10:00 AM
Slot added: 11:00 AM
Doctor added successfully.
```

---

### Appointment Booking Example

#### Input

```text
Enter Doctor ID: 101
Enter Patient ID: 201
Enter slot to book: 10:00 AM
```

#### Output

```text
Doctor confirmed appointment.
Appointment added successfully.
Appointment created.
```

---

## OOP Concepts Used

### Abstraction
- `Person` class is declared as an abstract class.

### Inheritance
- `Patient`, `Doctor`, and `Receptionist` inherit from `Person`.

### Encapsulation
- Class attributes are declared private and accessed using methods.

### Polymorphism
- Method overriding is used for `displayRole()`.

---

## UML Diagrams Included

- Class Diagram
- Use-Case Diagram
- Sequence Diagram

---

## Academic Information

**Course:** 22AIE111 Object Oriented Programming in Java  
**Department:** Computer Science and Engineering  
**Institution:** Amrita School of Computing, Amritapuri Campus

---

## References

- Java Documentation: https://docs.oracle.com/javase/tutorial/
- UML Basics: https://www.uml.org/
