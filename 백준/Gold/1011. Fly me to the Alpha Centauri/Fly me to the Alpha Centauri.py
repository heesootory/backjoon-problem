n = int(input())

for i in range(0,n):
    start, end = map(int, input().split(' '))
    term = end - start

    if term == 1: print("1")
    elif term == 2 : print("2")
    else:
        num1 = 2
        num_plus = 1
        num2 = 3
        cnt = 2

        while(True):
            cnt+=1
            num1 += num_plus
            num_plus+=1
            num2 += num_plus
            if num1 <= term and term < num2 : break

            cnt+=1
            num1 += num_plus
            num2 += num_plus
            if num1 <= term and term < num2 : break
        print(cnt)