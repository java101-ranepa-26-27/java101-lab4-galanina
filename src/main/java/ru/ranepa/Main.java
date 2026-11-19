package ru.ranepa;

public class Main {
    public static void main(String[] args) {
        University university = new University();

        // 1. Анна, Виктор, Борис
        Student anna = university.enroll("Анна");
        university.hire("Виктор", "история");
        university.enroll("Борис");

        // 2. Оценки Анне
        university.grade(anna.getId(), 4);
        university.grade(anna.getId(), 5);
        university.grade(anna.getId(), 3);

        // 3. Печать всех
        System.out.println("--- Список людей ---");
        for (Person p : university.all()) {
            System.out.println(p.report());
        }

        // 4. Оценка Виктору (отказ)
        System.out.println("\n--- Попытка поставить оценку Виктору ---");
        try {
            university.grade(2, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Отказ: " + e.getMessage());
        }

        // 5. Поиск Виктора и Ивана
        System.out.println("\n--- Поиск Виктора ---");
        try {
            Person viktor = university.findByName("Виктор");
            System.out.println("Найден: " + viktor.report());

            university.findByName("Иван");
        } catch (IllegalArgumentException e) {
            System.out.println("Отказ: " + e.getMessage());
        }

        // 6. Средний балл Анны
        System.out.println("\n--- Средний балл Анны ---");
        System.out.println("Средний балл: " + university.average(anna.getId()));
        // TODO: сценарий
        // 1. принять преподавателя
        // 2. поставить Анне оценки
        // 3. напечатать всех одним циклом
        // 4. попробовать оценить преподавателя — отказ
        // 5. найти человека по имени
        // 6. напечатать средний балл
    }
}
