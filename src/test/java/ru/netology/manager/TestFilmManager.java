package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestFilmManager {

    private FilmManager manager;
    private Film first = new Film(1, 1, "Бладшот", "боевик");
    private Film second = new Film(2, 2, "Вперед", "мультфильм");
    private Film third = new Film(3, 3, "Отель Белград ", "комедия");
    private Film fourth = new Film(4, 4, "Русалочка", "мультфильм");
    private Film fifth = new Film(5, 5, "Вверх", "мультфильм");
    private Film sixth = new Film(6, 6, "Чудаки", "комедия");
    private Film seventh = new Film(7, 7, "Крепкий орешек", "боевик");
    private Film eighth = new Film(8, 8, "Тачки", "мультфильм");
    private Film ninth = new Film(9, 9, "Тупой и еще тупее", "комедия");
    private Film tenth = new Film(10, 10, "Час пик", "комедия");
    private Film eleventh = new Film(11, 11, "Час пик 2", "комедия");

    @Test
    void ShouldShowOnlyLast10WhenAddedMore() {

        manager = new FilmManager(10);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        Film[] expected = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void ShouldShowOnlyLast10WhenInRequestMore() {

        manager = new FilmManager(11);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        Film[] expected = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void ShouldShowOnlyLast5WhenAdded10() {

        manager = new FilmManager(5);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Film[] expected = new Film[]{tenth, ninth, eighth, seventh, sixth};

        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void ShouldShowOnlyLast4WhenAdded4InRequest5() {

        manager = new FilmManager(5);

        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Film[] expected = new Film[]{tenth, ninth, eighth, seventh};

        assertArrayEquals(expected, manager.getAll());
    }

    @Test
    void shouldMinusEmpty() {

        manager = new FilmManager(-2);

        Film[] expected = new Film[]{};

        assertArrayEquals(expected, manager.getAll());
    }
}