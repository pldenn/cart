package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {

    private AfishaRepository repository = new AfishaRepository();
    private AfishaManager manager = new AfishaManager(repository);
    private Film first = new Film(1, "Бладшот", "боевик");
    private Film second = new Film(2, "Вперед", "мультфильм");
    private Film third = new Film(3, "Отель Белград ", "комедия");

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    void shouldSave() {
        Film[] expected = new Film[]{third, second, first};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        Film[] expected = new Film[]{first, second, third};
        Film[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        Film actual = repository.findById(2);
        assertEquals(second,actual);
    }

    @Test
    void removeById() {
        Film[] expected = new Film[]{first, third};
        Film[] actual = repository.removeById(2);
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeAll() {
        Film[] expected = new Film[]{};
        Film[] actual = repository.removeAll();
        assertArrayEquals(expected, actual);
    }
}
