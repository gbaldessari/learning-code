#Giacomo Baldessari

for i in range(1,101):
    
    num = i % 3
    num2 = i % 5

    if num == 0 and num2 == 0:
        print('FizzBuzz')

    elif num == 0 and num2 != 0:
        print('Fizz')

    elif num != 0 and num2 == 0:
        print('Buzz')

    else:
        print(i)