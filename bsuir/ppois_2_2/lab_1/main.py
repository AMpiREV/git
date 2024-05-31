class AutoAndPlace:
    def __init__(self):
        self.d = {}

    def attachTo(self, mark, color, place):
        self.d[place] = mark + " " + color
        return self.d


class Auto:
    def __init__(self):
        self.mark = None
        self.color = None
        self.colors = ['синий', 'черный', 'белый', 'серебристый']
        self.marks = ['toyota', 'bmw', 'mersedes', 'lada', 'opel', 'mazda']
        self.cars = []

    def action(self, color, mark):
        self.color = color
        self.mark = mark
        print("Приехал", self.color, self.mark)

    def addCar(self, mark, color):
        self.cars.append(mark + " " + color)
        print(self.cars)


class Parking:
    def __init__(self):
        self.places = list(range(1, 16))

    def removePlace(self, place):
        self.places.remove(place)
        print(self.places)


class Tariff:
    def washing(self):
        print("Машина помыта")

    def charging(self):
        print("Машина заряжена")


class Guard:
    def inspection(self):
        print("Охранник осматривается, всё на месте")


class Manager(Tariff):
    def message(self, tariffNumber):
        print("Отлично")


class Payment:
    def processPayment(self, amount):
        print(f"Оплата в размере {amount} рублей прошла успешно")
        return True


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


def main():
    leave = False
    car1 = Auto()
    place1 = Parking()
    autoAndPlace = AutoAndPlace()
    manager = Manager()
    guard = Guard()
    payment = Payment()

    while not leave:
        isValid1 = False
        while not isValid1:
            mark = input("Введите авто: ")
            isValid1 = validationCar(mark)

        isValid2 = False
        while not isValid2:
            color = input("Введите цвет: ")
            isValid2 = validationColor(color)

        # Process payment after successful validation
        payment_amount = 100  # Example payment amount
        if payment.processPayment(payment_amount):
            car1.action(color, mark)
            car1.addCar(mark, color)

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

            guard.inspection()

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

            exit_choice = input("Выберите\n1)Продолжить(наберите 1)\n2)Выйти (наберите что угодно): ")
            if exit_choice != "1":
                leave = True


if __name__ == "__main__":
    main()
