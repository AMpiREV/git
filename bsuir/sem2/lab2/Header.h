#pragma once
#include <iostream>
#include <vector>
#include <string>
using namespace std;
vector<vector<string>> generatePowerSet(vector<string>& nums) {
    int n = nums.size();
    int powerSetSize = pow(2, n); //размер булеана 
    vector<vector<string>> powerSet(powerSetSize);
    for (int i = 0; i < powerSetSize; i++) {
        for (int j = 0; j < n; j++) {
            if ((i & (1 << j)) != 0) {
                powerSet[i].push_back(nums[j]); // проверяет бит каждого числа 
            }
        }
    }
    return powerSet;
}