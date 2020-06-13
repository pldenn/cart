package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;

@AllArgsConstructor
@NoArgsConstructor

public class FilmManager {
    private Film[] films = new Film[0];
    int currentLength = 10;
    int newLength;

    public FilmManager(int newLength) {
        this.newLength = newLength;
    }

    public void add(Film film) {
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Film[] getAll() {
        if (newLength > currentLength) {
            newLength = currentLength;
        }
        if (newLength < 0) {
            newLength = 0;
        }
        if (films.length < newLength) {
            newLength = films.length;
        }

        Film[] result = new Film[newLength];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}
