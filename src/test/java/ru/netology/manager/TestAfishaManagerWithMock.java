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
import  static  org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TestAfishaManagerWithMock {
    @Mock
    private AfishaRepository repository = new AfishaRepository();
    @InjectMocks
    private AfishaManager manager = new AfishaManager(repository,3);
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

    @BeforeEach
    public void setUp(){
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        //настройка заглушки
        Film[] returned = new Film[]{second, third}; // определяем что будем возвращать
        doReturn(returned).when(repository).findAll(); //создание мока (что и когда будем возвращать)
        doNothing().when(repository).removeById(idToRemove);  //создание мока (что и когда будем возвращать)

        manager.removeById(idToRemove);
        Film[] expected = new Film[]{third, second};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void should() {

        //настройка заглушки
        Film[] returned = new Film[]{second, third}; // определяем что будем возвращать
        doReturn(returned).when(repository).findAll(); //создание мока (что и когда будем возвращать)

        Film[] expected = new Film[]{third, second};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

    }



}
