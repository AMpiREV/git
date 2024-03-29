# Второй семестр

Презентация с обзором семестра доступна [по ссылке](https://docs.google.com/presentation/d/1AKePXznb2sNazWdSLmO3xTAawSMM562xTAHo-bURnFo/edit?usp=sharing). Там же указаны сроки выполнения работ.

Все материалы для выполнения работ доступны [по ссылке](https://drive.google.com/drive/folders/1J3JfipKGQDhuQWhVdWZrQm62_Fdn7K8E?usp=share_link).

Перед началом выполнения работ не забудьте актуализировать свою ветку на удалённом репозитории. Инструкция приведена в конце документа.

## Требования для успешного выполнения работ

### ЛР
В [lab1](./lab1/) и [lab2](./lab2/) ожидается исходные файлы с кодом, тесты, и документация соответствующих работ. 

Требования к коду работы:
- В вашей лабе должны присутствовать [структуры данных](https://www.w3schools.com/cpp/cpp_structs.asp). Если умеете в ООП -- делайте [классы](https://www.w3schools.com/cpp/cpp_classes.asp). 
- [Запрещено использовать глобальные переменные](https://stackoverflow.com/questions/484635/are-global-variables-bad). 
- Реализация в .срр файлах, декларация -- в .hpp. Подробнее с header-файлами можно ознакомиться [по ссылке](https://learn.microsoft.com/en-us/cpp/cpp/header-files-cpp?view=msvc-170). 
- Код должен быть [хорошо декомпозирован](https://www.learning.com/blog/decomposition-in-computational-thinking/). 
- Следите за [именованием элементов кода](https://www.geeksforgeeks.org/naming-convention-in-c/).

README-файл должен содержать:
- цель;
- задачу;
- список используемых понятий с указанием источников;
- описание алгоритмов с указанием источников;
- результаты тестирования (изображения входных и выходных данных, с кратким описанием);
- вывод.


### ПЗ
Для успешного выполнения необходимо ознакомится с лекцией ["Введение в SC-код"](https://youtu.be/kNulTEIEQyg). Вспомагательные материалы для формализации доступны [по ссылке]( https://drive.google.com/drive/folders/1YcFCikH9WaXeDmWPGPtRTk34FsCmLkVl?usp=sharing). Подробнее вся информация доступна в [Стандарте OSTIS](https://drive.google.com/file/d/1iOB-XHD1Fu6KBANWJZLJJ4nT7aZzOw-G/view?usp=share_link).

Полученные gwf-файлы должны быть загружены на удалённый репозиторий. В результате ожидается README-файл, с указанием варианта задания, фрагментами формализованного текста и комментариями. 


### РР
Полученные gwf-файлы должны быть загружены на удалённый репозиторий. В результате ожидается отчёт в виде README-файла.

Требования к структуре отчёта.
- Титульный лист (ФИО преподавателя, название предмета, тема). Титульник не нумеруется. 
- Содержание.
- Введение (цели и задачи).
- Список ключевых понятий (определения, формализация понятия в виде SCg-кода или SCn-кода). 
- Алгоритм. Расписан максимально подробно по шагам.
- Тестовые примеры.
- Заключение.
- Список использованных источников, оформленный в соответствии с [требованиями ВАК](https://vak.gov.by/be/bibliographicDescription).


### Практика
В [practice](./practice/) ожидается результат практики в виде формализованного текста. 
- Шаблон для практики доступен [по ссылке](https://www.overleaf.com/read/zdxvwzgnwbzw). 
- Мануал по установке Стандарта OSTIS из исходников доступен [по ссылке](https://docs.google.com/document/d/167ZeRKsdFtGN3R4tvT6svBQLF9YFaPZvjNHZcSAyZ1U/edit?usp=sharing). 
- Уже собранный Стандарт OSTIS на момент 09.12.2022 доступен [по ссылке](https://drive.google.com/file/d/1iOB-XHD1Fu6KBANWJZLJJ4nT7aZzOw-G/view?usp=share_link). 
- Опубликованная версия 2021 года также доступна [по ссылке](https://libeldoc.bsuir.by/handle/123456789/45813).


## Актуализация ветки на удалённом репозитории

Работа с репозиторием осуществляется через персональные ветки, они должны быть уже доступны на удалённом репозитории. 

Для начала работ необходимо актуализировать свою ветку, т.е. подтянуть все изменения из main-ветки. Рассмотрим пример актуализации ветки [Абушкевич_А_А](https://github.com/iit-22170x/RPIIS/tree/%D0%90%D0%B1%D1%83%D1%88%D0%BA%D0%B5%D0%B2%D0%B8%D1%87_%D0%90_%D0%90):
- Клонируем репозиторий:
```
git clone https://github.com/iit-22170x/RPIIS.git
cd RPIIS/
git status

 # On branch main
 # Your branch is up to date with 'origin/main'.

 # nothing to commit, working tree clean
```
- переходим на свою ветку:
```
git checkout Абушкевич_А_А
 # Branch 'Абушкевич_А_А' set up to track remote branch 'Абушкевич_А_А' from 'origin'.
 # Switched to a new branch 'Абушкевич_А_А'
```
- делаем rebase, т.е. перемещаем начало нашей ветки на последний коммит main-ветки:
```
git rebase main
 # Successfully rebased and updated refs/heads/Абушкевич_А_А.
```
- обновляем свою ветку на удалённом репозитории, применяем изменения:
```
git push -f
```
В результате ветка на удалённом репозитории должна выглядеть примерно следующим образом: 
![результат актуализации ветки](img/rebase_result.png)
