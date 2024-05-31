import unittest
from main import *
from unittest.mock import patch
from io import StringIO

class TestParkingSystem(unittest.TestCase):

    def setUp(self):
        self.car1 = Auto()
        self.place1 = Parking()
        self.autoAndPlace = AutoAndPlace()
        self.manager = Manager()
        self.guard = Guard()
        self.payment = Payment()

    def test_validationCar(self):
        self.assertTrue(validationCar('toyota'))
        self.assertFalse(validationCar('ferrari'))

    def test_validationColor(self):
        self.assertTrue(validationColor('синий'))
        self.assertFalse(validationColor('зеленый'))

    def test_validationPlace(self):
        self.assertTrue(validationPlace(5, self.place1))
        self.place1.removePlace(5)
        self.assertFalse(validationPlace(5, self.place1))
        self.assertFalse(validationPlace(20, self.place1))
        self.assertFalse(validationPlace(0, self.place1))

    def test_auto_action(self):
        with patch('sys.stdout', new=StringIO()) as fake_out:
            self.car1.action('синий', 'bmw')
            self.assertEqual(fake_out.getvalue().strip(), "Приехал синий bmw")

    def test_auto_addCar(self):
        with patch('sys.stdout', new=StringIO()) as fake_out:
            self.car1.addCar('bmw', 'синий')
            self.assertEqual(self.car1.cars, ['bmw синий'])
            self.assertIn("['bmw синий']", fake_out.getvalue().strip())

    def test_parking_removePlace(self):
        self.place1.removePlace(3)
        self.assertNotIn(3, self.place1.places)

    def test_autoAndPlace_attachTo(self):
        result = self.autoAndPlace.attachTo('bmw', 'синий', 5)
        self.assertEqual(result, {5: 'bmw синий'})
        self.assertIn(5, self.autoAndPlace.d)
        self.assertEqual(self.autoAndPlace.d[5], 'bmw синий')

    def test_manager_washing(self):
        with patch('sys.stdout', new=StringIO()) as fake_out:
            self.manager.washing()
            self.assertEqual(fake_out.getvalue().strip(), "Машина помыта")

    def test_manager_charging(self):
        with patch('sys.stdout', new=StringIO()) as fake_out:
            self.manager.charging()
            self.assertEqual(fake_out.getvalue().strip(), "Машина заряжена")

    def test_guard_inspection(self):
        with patch('sys.stdout', new=StringIO()) as fake_out:
            self.guard.inspection()
            self.assertEqual(fake_out.getvalue().strip(), "Охранник осматривается, всё на месте")

    def test_payment_process(self):
        with patch('sys.stdout', new=StringIO()) as fake_out:
            result = self.payment.processPayment(100)
            self.assertTrue(result)
            self.assertEqual(fake_out.getvalue().strip(), "Оплата в размере 100 рублей прошла успешно")


if __name__ == '__main__':
    unittest.main()
