#include <iostream>
using namespace std;

int d[1001] = { 0,1,3 };

int main() {
	int n; 
	cin >> n;

	for (int i = 3; i <= n; i++) {
		d[i] = (d[i - 1] + d[i - 2] * 2) % 10007;
	}

	cout << d[n];

}

