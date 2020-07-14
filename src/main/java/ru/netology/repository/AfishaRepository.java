package ru.netology.repository;

import ru.netology.domain.Film;

public class AfishaRepository {
    private Film[] films = new Film[0];

    public void save(Film film) {
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Film[] findAll() {
        return films;
    }

    public Film findById(int id) {
        Film filmById = new Film();
        for (Film film : films) {
            if (film.getId() == id) {
                filmById = film;
            }
        }
        return filmById;
    }

    public Film[] removeById(int id) {
        int length = films.length - 1;
        Film[] tmp = new Film[length];
        int index = 0;
        for (Film film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
        return films;
    }

    public Film[] removeAll() {
        return films = new Film[0];
    }
}
