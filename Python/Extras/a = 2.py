a = 2
b = 5
y = 0
a = a+b
if a>5:
    a = 3
else:
    a-=1
x =-1
while a<8:
    for i in range(a):
        x+=i
    y+=1
    if a % 2 ==0 and a<=x:
        a+=2
    else:
        a+=1
print(x//y)
