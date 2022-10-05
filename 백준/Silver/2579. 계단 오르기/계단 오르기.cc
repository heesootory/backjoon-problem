#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int stair[301];
int sum[301];

int main() {

	int n = 0;
	scanf("%d", &n);

	for (int i = 1; i <= n; i++)
		scanf("%d", &stair[i]);

	sum[1] = stair[1];
	sum[2] = stair[1] + stair[2];
	sum[3] = max(stair[1], stair[2]) + stair[3];
	for (int i = 4; i <= n; i++) {
		sum[i] = max(sum[i - 2] + stair[i], sum[i - 3] + stair[i - 1] + stair[i]);
	}

	printf("%d", sum[n]);

}