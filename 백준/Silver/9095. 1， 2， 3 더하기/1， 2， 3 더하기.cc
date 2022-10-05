#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int dp(int n, int& count) {
	if (n <= 0) {
		if (n == 0) count++;
		return n;
	}
	
	if (n >= 3) dp(n - 3, count);
	dp(n - 1, count);
	dp(n - 2, count);

	return 0;
}


int main() {
	
	int N = 0;
	scanf("%d", &N);

	while (N--) {
		int n = 0;
		int count = 0;
		scanf("%d", &n);
		dp(n, count);
		printf("%d\n", count);
	}
	return 0;
}