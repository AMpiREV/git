#include "RSQ.h"
#include <iostream>
using namespace rsq;

void test1()
{
	vector<int> test1 = { 3,-4,7,-8,2,4,-8,-4,8,10 };
	RSQ rsq1(test1);

	cout << "Элементы первого массива: ";
	for (auto const& x : test1)
		cout << x << " ";
	cout << endl;
	cout << "Сумма элементов на промежутке от 3 до 7 равен " << rsq1.get_sum(3, 7) << endl;
	cout << endl;
}
void test2()
{
	vector<int> test2 = { 7,7,-9,3,-10,-9,5,-7,2,4 };
	RSQ rsq2(test2);

	cout << "Элементы второго массива: ";
	for (auto const& x : test2)
		cout << x << " ";
	cout << endl;
	rsq2.update(0, 9, 8);
	cout << "Значения на промежутке от 4 до 6 обновлены на 8" << endl;
	cout << "Сумма элементов на промежутке от 0 до 9 равен " << rsq2.get_sum(0, 9) << endl;
	cout << endl;
}
void test3()
{
	vector<int>   test3 = { 7,-3,-4,-6,5,-6,-2,-7,1,-3 };
	RSQ rsq3(test3);

	cout << "Элементы третьего массива: ";
	for (auto const& x : test3)
		cout << x << " ";
	cout << endl;
	rsq3.update(1, 10);
	cout << "Значение первого эдемента обновлено на 10" << endl;
	cout << "Сумма элементов на промежутке от 0 до 3 равен " << rsq3.get_sum(0, 3) << endl;
	cout << endl;
}
void test4()
{
	vector<int> test4 = { 1,2,3 };
	RSQ rsq4(test4);

	cout << "Элементы четвертого массива: ";
	for (auto const& x : test4)
		cout << x << " ";
	cout << endl;
	rsq4.update(-1, 1, 5);
	cout << "Значения на промежутке от -1 до 1 обновлены на 5" << endl;
	cout << "Сумма элементов на промежутке от -1 до 4 равен " << rsq4.get_sum(-1, 4) << endl;
	cout << endl;
}
void test5()
{
	vector<int>  test5;
	RSQ rsq5(test5);

	cout << "Элементы пятого массива: " << endl;
	rsq5.update(0, 1, 1);
	rsq5.get_sum(0, 1);
}
int main()
{
	setlocale(LC_ALL, "ru");
	test1();
	test2();
	test3();
	test4();
	test5();
	return 0;
}