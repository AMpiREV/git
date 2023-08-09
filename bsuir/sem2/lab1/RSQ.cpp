#include "RSQ.h"
using namespace rsq;
void RSQ::build(vector<int> a, int v, int tl, int tr) {
	if (tl == tr)
		t[v] = a[tl];
	else {
		int tm = (tl + tr) / 2;
		build(a, v * 2, tl, tm);
		build(a, v * 2 + 1, tm + 1, tr);
		t[v] = t[v * 2]+ t[v * 2 + 1];
	}
}
RSQ::RSQ(vector<int> a)
{
	n = a.size();
	if (n == 0)
		return;
	t.assign(4 * n, 0);
	build(a, 1, 0, n - 1);

}
int RSQ::get_sum_LR(int v, int tl, int tr, int l, int r) {
	if (r > n - 1) {
		cout << "Правая граница промежутка больше размера (правая граница приравнена за конец массива)" << endl;
		r = n - 1;
	}
	if (l < 0) {
		cout << "Левая граница промежутка меньше 0 (левая граница приравнена началу)" << endl;
		l = 0;
	}
	if (l > r)
		return 0;
	if (l == tl && r == tr)
		return t[v];
	int tm = (tl + tr) / 2;
	return get_sum_LR(v * 2, tl, tm, l, min(r, tm)) + get_sum_LR(v * 2 + 1, tm + 1, tr, max(l, tm + 1), r);
}
int RSQ::get_sum(int l, int r)
{
	if (n == 0)
	{
		cout << "В массиве нет элементов" << endl;
		return 0;
	}
	return get_sum_LR(1, 0, n - 1, l, r);
}
void RSQ::update_LR(int v, int tl, int tr, int pos, int new_val) {

	if (tl == tr)
		t[v] = new_val;
	else {
		int tm = (tl + tr) / 2;
		if (pos <= tm)
			update_LR(v * 2, tl, tm, pos, new_val);
		else
			update_LR(v * 2 + 1, tm + 1, tr, pos, new_val);
		t[v] = t[v * 2]+ t[v * 2 + 1];
	}
}
void RSQ::update(int l, int r, int new_val)
{
	if (n == 0)
	{
		cout << "В массиве нет элементов" << endl;
		return;
	}
	if (r > n - 1) {
		cout << "Правая граница промежутка больше размера (правая граница приравнена за конец массива)" << endl;
		r = n - 1;
	}
	if (l < 0) {
		cout << "Левая граница промежутка меньше 0 (левая граница приравнена началу)" << endl;
		l = 0;
	}
	if (l > r)
		return;
	for (int i = l; i <= r; i++)
	{
		update_LR(1, 0, n - 1, i, new_val);
	}
}
void RSQ::update(int pos, int new_val)
{
	if (n == 0)
	{
		cout << "В массиве нет элементов" << endl;
		return;
	}
	if (pos > n - 1 || pos < 0)
	{
		cout << "Номер элемента не находится в промежутке (поменяется 0-ой элемент)" << endl;
		pos = 0;
	}
	update_LR(1, 0, n - 1, pos, new_val);
}