package ru.netology.manager;

import ru.netology.domain.PurchaseItem;

public class CartManager {
  private PurchaseItem[] items = new PurchaseItem[0]; //объявляем новый массив объектов items в котором 0 объектов

  public void add(PurchaseItem item) {
    // создаём переменную со значением длинны массива +1 т.к. в Java нельзя изменить размер массива, а мы собираемся
    // добавить 1 объект
    int length = items.length + 1;
    // объявляем и создаем новый массив с размером, который посчитали выше
    PurchaseItem[] tmp = new PurchaseItem[length];
    // itar + tab
    // копируем поэлементно
    // for (int i = 0; i < items.length; i++) {
    //   tmp[i] = items[i];
    // }
    System.arraycopy(items, 0, tmp, 0, items.length);
    // кладём последним наш элемент
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    items = tmp;
  }

  public PurchaseItem[] getAll() {
    PurchaseItem[] result = new PurchaseItem[items.length];
    // перебираем массив в прямом порядке
    // но кладём в результаты в обратном
    for (int i = 0; i < result.length; i++) {
      int index = items.length - i - 1;
      result[i] = items[index];
    }
    return result;
  }

  // наивная реализация
  public void removeById(int id) {
    int length = items.length - 1;
    PurchaseItem[] tmp = new PurchaseItem[length];
    int index = 0;
    for (PurchaseItem item : items) {
      if (item.getId() != id) {
        tmp[index] = item;
        index++;
      }
    }
    // меняем наши элементы
    items = tmp;
  }
}
