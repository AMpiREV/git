## Модель Автостоянки Вариант 78

### Описание

#### Цель:  

- Изучить основные возможности языка Python для разработки программных систем с интерфейсом командной строки (CLI) 
- Разработать программную систему на языке Python согласно описанию предметной области

#### Задачи: 

- Разработать программную систему по Предметной области: организация парковки транспортных средств. 
- Реализовать операции:
    1. операция выбора места для парковки
    2. операция оплаты парковки
    3. Операция предоставления дополнительных услуг
    4. операция контроля за сохранностью автомобилей
    5. операция управления движением на стоянке

- Реализовать ключевые сущности:
    1. автомобили
    2. парковочные места
    3. тарифы
    4. охрана
    5. управляющий
    6. оплата


### Релизация

 - ##### Автомобили

Cущность автомобиля состоит из следующих полей:

- Марка
- Цвет

##### Фрагмент кода:
```python
class Auto:
    def __init__(self):
        self.mark = None
        self.color = None
```

- ##### Парковка

Парковка состоит из:

 - парковочные места(площадки)

##### Фрагмент кода:
```python
class Parking:
    def __init__(self):
        self.places = list(range(1, 16))
```

- ##### Тарифы

Класс Tariff используется как класс родитель к классу Manager

##### Фрагмент кода:
```class Tariff:
    def washing(self):
        print("Машина помыта")

    def charging(self):
        print("Машина заряжена")
```

- ##### Охрана

Сущность используется для вывода смс о том что на стоянке всё впорядке

##### Фрагмент кода:
```python
class Guard:
    def inspection(self):
        print("Охранник осматривается, всё на месте")
```

- ##### Управляющий

Manager наследуется от класса Tariff:

##### Фрагмент кода:
```python
class Manager(Tariff):
    def message(self, tariffNumber):
        print("Отлично")
```

- ##### Оплата

  Payment используется для оплаты стоянки

  ##### Фрагмент кода:
  ```python
  class Payment:
    def processPayment(self, amount):
        print(f"Оплата в размере {amount} рублей прошла успешно")
        return True
  ```

__операция выбора места для парковки__

```python
placeIsValid = False
            print(place1.places)
            while not placeIsValid:
                try:
                    place = int(input("Выберите место на стоянке от 1 до 15: "))
                    placeIsValid = validationPlace(place, place1)
                except ValueError:
                    print("Введите числовое значение.")

            place1.removePlace(place)
            print(autoAndPlace.attachTo(mark, color, place))
```

__операция оплаты парковки__

```python
payment_amount = 100  # Example payment amount
        if payment.processPayment(payment_amount):
            car1.action(color, mark)
            car1.addCar(mark, color)
```

__Операция предоставления дополнительных услуг__

```python
            try:
                tariffNumber = int(input(
                    "Выберите услугу\n1)Помыть машину\n2)Зарядить машину\nЧтобы ничего не выбрать наберите что угодно: "))
                manager.message(tariffNumber)
                if tariffNumber == 1:
                    manager.washing()
                elif tariffNumber == 2:
                    manager.charging()
            except ValueError:
                print("Введите числовое значение.")
```

__операция контроля за сохранностью автомобилей__

```python
guard.inspection()
```

__операция управления движением на стоянке__

```python
clearing = input("Нажмите 1 чтобы почистить стоянку, или введите другое чтобы пропустить это: ")
            if clearing == "1":
                while True:
                    try:
                        placeToRemove = int(
                            input("Какое парковочное место освободить, или введите 0 чтобы не освобождать: "))
                    except ValueError:
                        print("Введите числовое значение.")
                        continue
                    if placeToRemove == 0:
                        break
                    if placeToRemove in place1.places:
                        print("Оно свободно")
                    else:
                        place1.places.insert(0, placeToRemove)
                        del autoAndPlace.d[placeToRemove]

            if not place1.places:
                print("Парковка заполнена, у вас отличная парковка, пора расширяться!")
                break
```

- ##### Валидаторы

При вводе автомобилей и парковочного места программа должна проверить, существование таких обьектов как:
 - Марка
 - Цвет
 - Парковочное место


##### Фрагмент кода:
```python
def validationCar(mark):
    marks = ['toyota', 'bmw', 'mersedes', 'lada', 'opel', 'mazda']
    if mark in marks:
        print("Валидация прошла успешно")
        return True
    print("Валидация не успешна")
    return False


def validationColor(color):
    colors = ['синий', 'черный', 'белый', 'серебристый']
    if color in colors:
        print("Валидация прошла успешно")
        return True
    print("Валидация не успешна")
    return False


def validationPlace(place, parking):
    if 1 <= place <= 15:
        if place not in parking.places:
            print("Место занято")
            return False
        return True
    print("Нет такого парковочного места")
    return False
```

__Пример__

Код который выполняет валидацию автомобиля

```python
isValid1 = False
while not isValid1:
  mark = input("Введите авто: ")
  isValid1 = validationCar(mark)

isValid2 = False
while not isValid2:
  color = input("Введите цвет: ")
  isValid2 = validationColor(color)
```

- #### Исключения

```python
try:
  place = int(input("Выберите место на стоянке от 1 до 15: "))
  placeIsValid = validationPlace(place, place1)
except ValueError:
  print("Введите числовое значение.")


try:
  placeToRemove = int(input("Какое парковочное место освободить, или введите 0 чтобы не освобождать: "))
except ValueError:
  print("Введите числовое значение.")
  continue
```
