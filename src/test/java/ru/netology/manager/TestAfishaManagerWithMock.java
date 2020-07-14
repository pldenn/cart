package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerMockTest {

    @Mock
    private AfishaRepository repository = new AfishaRepository();
    @InjectMocks
    private AfishaManager manager = new AfishaManager(repository);
    private Film first = new Film(1, "Бладшот", "боевик");
    private Film second = new Film(2, "Вперед", "мультфильм");
    private Film third = new Film(3, "Отель Белград ", "комедия");
    private Film fourth = new Film(4, "Русалочка", "мультфильм");
    private Film fifth = new Film(5, "Вверх", "мультфильм");
    private Film sixth = new Film(6, "Чудаки", "комедия");
    private Film seventh = new Film(7, "Крепкий орешек", "боевик");
    private Film eighth = new Film(8, "Тачки", "мультфильм");
    private Film ninth = new Film(9, "Тупой и еще тупее", "комедия");
    private Film tenth = new Film(10, "Час пик", "комедия");
    private Film eleventh = new Film(11, "Час пик 2", "комедия");


    @Test
    public void shouldGetLastAddedWhenLengthAtTheBorder() {

        //настройка заглушки
        Film[] returned = new Film[]{first, second}; // определяем что будем возвращать
        doReturn(returned).when(repository).findAll(); //создание мока (что и когда будем возвращать)

        AfishaManager manager = new AfishaManager(repository, 2);

        Film[] expected = new Film[]{second, first};
        Film[] actual = manager.getAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetLastAddedWhenLengthOverDefault() {

        //настройка заглушки
        Film[] returned = new Film[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh}; // определяем что будем возвращать
        doReturn(returned).when(repository).findAll(); //создание мока (что и когда будем возвращать)

        AfishaManager manager = new AfishaManager(repository, 11);

        Film[] expected = new Film[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetEmptyWhenLengthZero() {

        //настройка заглушки
        Film[] returned = new Film[]{}; // определяем что будем возвращать
        doReturn(returned).when(repository).findAll(); //создание мока (что и когда будем возвращать)

        AfishaManager manager = new AfishaManager(repository, 0);

        Film[] expected = new Film[]{};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetEmptyWhenLengthMinus() {

        //настройка заглушки
        Film[] returned = new Film[]{}; // определяем что будем возвращать
        doReturn(returned).when(repository).findAll(); //создание мока (что и когда будем возвращать)

        AfishaManager manager = new AfishaManager(repository, -1);

        Film[] expected = new Film[]{};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

}
