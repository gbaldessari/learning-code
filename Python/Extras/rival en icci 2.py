def BuscarRival():
    Rival=input('Existe algún Rival en ICCI?: ')
    Rival=Rival.lower()
    if Rival == 'si':
        print('al fin un digno oponente nuestra batalla sera legendaria')
    elif Rival == 'no':
        print('A mimir')
    else:
        while Rival!='si' or Rival!='no':
            BuscarRival()
            break
BuscarRival()