#pragma once
#include <iostream>
#include<vector>
using namespace std;
namespace rsq
{
	class RSQ
	{
	private:
		int n;
		vector<int> t;
		void build(vector<int> a, int v, int tl, int tr);
		int get_sum_LR(int v, int tl, int tr, int l, int r);
		void update_LR(int v, int tl, int tr, int pos, int new_val);
	public:
		void update(int l, int r, int new_val);
		void update(int pos, int new_val);
		RSQ(vector<int> a);
		int get_sum(int l, int r);
	};

}