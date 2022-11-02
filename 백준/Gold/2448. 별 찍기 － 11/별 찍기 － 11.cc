#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>		//malloc
#include <iostream>
#include <string.h>		//memset, memcpy

char arr[3100][6200];

void set(int n) {
	int row = n;
	int col = 2 * n - 1;

	int p = 3;

	while (p < n) {
		int p_col = 2 * p - 1;

		for (int i = 0; i < p; i++) {
			memcpy(arr[p + i] + (n - 1) - p_col, arr[i] + n - p, p_col);
			memcpy(arr[p + i] + (n - 1) + 1, arr[i] + n - p, p_col);

		}
	
		p *= 2;
	}


}

int main() {

	int N;
	scanf("%d", &N);

	int row = N;
	int col = 2 * N - 1;

	for (int i = 0; i < row; i++) {
		for (int j = 0; j < col+1; j++) {
			arr[i][j] = ' ';
		}
	}
	memset(arr[0] + col / 2, '*', 1);
	memset(arr[1] + col / 2 - 1, '*', 1);
	memset(arr[1] + col / 2 + 1, '*', 1);
	memset(arr[2] + col / 2 - 2, '*', 5);

	set(N);

	for (int i = 0; i < row; i++) printf("%s\n", arr[i]);

	return 0;
}