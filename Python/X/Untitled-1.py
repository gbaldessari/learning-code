listaA=["Joker","El","Soy","Hola"]

listaB=["Chao","No soy","El","Batman"]

listaC=[]

while len(listaB)!=0:

    listaC.append(listaA[len(listaB)-1])

    listaB.pop()

for a in range(len(listaC)):

    print(listaC[a])