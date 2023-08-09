#include <iostream>
#include <vector>
#include <fstream>
#include <sstream>
#include <conio.h>
#include <string>


using namespace std;

// ФУНКЦИИ

// Парсинг строки как запись вершины
vector<int> GetVertexFromString(string& str) {
	vector<int> Output;
	string temp1;
	temp1 = str.substr(0, str.find(" ")); // Парсинг имени вершины
	str.erase(0, temp1.size() + 1);
	istringstream currentstring(str);
	string temp;
	while (getline(currentstring, temp, ' ')) { // Парсинг списка инцидентности

		try {
			Output.push_back(stoi(temp) - 1);
		}
		catch (...) {
			cout << "Ingnored invalid edge number input!\n";
		}
	}
	return Output;
}

// Парсинг графа из файла
vector<vector<int>> GetGraphFromFile(string& filename) {
	ifstream input(filename);
	if (!input.is_open()) {
		cout << "Error opening file, try again.\n";
		return {};
	}

	vector<vector<int>> Output;
	string temp;
	while (getline(input, temp))  Output.push_back(GetVertexFromString(temp));
	input.close();

	cout << "Opened file " << filename << "\n";
	return Output;
}

void sol(int vertex, bool* used, vector<vector<int>>& graph, int parent, bool* ans)// parent - предок текущей вершины
{
	used[vertex] = true;
	for (auto neighbor : graph[vertex])
	{
		if (!used[neighbor])
			sol(neighbor, used, graph, vertex, ans);

		else if (neighbor != parent)
		{
			*ans = true;
		}
	}
}
// MAIN

int main() {

	string filename = { "test_inputN.txt" };
	vector<vector<int>> input;
	bool ans = false;
	for (int i = 49; i < 54; i++) {
		filename[10] = (char)i;
		input = GetGraphFromFile(filename);
		if (input.size() == 1)
		{
			cout << "Graph hasn't tree" << endl;;
			continue;
		}
		bool* used = new bool[input.size()];
		for (size_t i = 0; i < input.size(); i++)
		{
			used[i] = false;
		}
		sol(0, used, input, -1, &ans);
		if (ans)
			cout << "Graph hasn't tree";
		else
		{
			cout << "Graph has tree";
		}
		cout << endl;
		ans = false;
		delete[]used;
	}
	system("pause");
	return 0;
}
