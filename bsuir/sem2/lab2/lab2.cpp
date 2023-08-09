#include "Header.h"
int Test1();
int Test2();
int Test3();
int Test4();
int Test5();
int Test_executing();
int main()
{
    setlocale(LC_ALL, "Russian");
    Test_executing();
    return 0;
}
int Test_executing() {
    Test1();
    Test2();
    Test3();
    Test4();
    Test5();
    return 0;
}
int Test1() {
    vector<string> nums = { "1", "2", "3", };
    vector<vector<string>> powerSet = generatePowerSet(nums);
    cout << "Num 1:" << '\n';
    for (int i = 0; i < powerSet.size(); i++) {
        cout << "{";
        for (int j = 0; j < powerSet[i].size(); j++) {
            cout << powerSet[i][j];
            if (j != powerSet[i].size() - 1) {
                cout << ", ";
            }
        }
        cout << "}" << endl;
    }
    return 0;
}
int Test2() {
    vector<string> nums = { "A", "B", "C", };
    vector<vector<string>> powerSet = generatePowerSet(nums);
    cout << "Num 2:" << '\n';
    for (int i = 0; i < powerSet.size(); i++) {
        cout << "{";
        for (int j = 0; j < powerSet[i].size(); j++) {
            cout << powerSet[i][j];
            if (j != powerSet[i].size() - 1) {
                cout << ", ";
            }
        }
        cout << "}" << endl;
    }
    return 0;
}
int Test3() {
    vector<string> nums = { "1", "{}", "A" };
    vector<vector<string>> powerSet = generatePowerSet(nums);
    cout << "Num 3:" << '\n';
    for (int i = 0; i < powerSet.size(); i++) {
        cout << "{";
        for (int j = 0; j < powerSet[i].size(); j++) {
            cout << powerSet[i][j];
            if (j != powerSet[i].size() - 1) {
                cout << ", ";
            }
        }
        cout << "}" << endl;
    }
    return 0;
}
int Test4() {
    vector<string> nums = { "1", "A","{2,3,4}" };
    vector<vector<string>> powerSet = generatePowerSet(nums);
    cout << "Num 4:" << '\n';
    for (int i = 0; i < powerSet.size(); i++) {
        cout << "{";
        for (int j = 0; j < powerSet[i].size(); j++) {
            cout << powerSet[i][j];
            if (j != powerSet[i].size() - 1) {
                cout << ", ";
            }
        }
        cout << "}" << endl;
    }
    return 0;
}
int Test5() {
    vector<string> nums = { "A", "{}","<1,2>" };
    vector<vector<string>> powerSet = generatePowerSet(nums);
    cout << "Num 5:" << '\n';
    for (int i = 0; i < powerSet.size(); i++) {
        cout << "{";
        for (int j = 0; j < powerSet[i].size(); j++) {
            cout << powerSet[i][j];
            if (j != powerSet[i].size() - 1) {
                cout << ", ";
            }
        }
        cout << "}" << endl;
    }
    return 0;
}
