#Giacomo Baldessari

print('Notas de Cátedra:')
print('(Ejemplo: 7, 4.2, 5.0)')
print()
print('---------------------------------------------------')
not1 = float(input('Ingrese su primera nota: '))
print()
if not1 < 1 or not1 > 7:
    print('Error: Ingrese una nota válida')
else:
    not2 = float(input('Ingrese su segunda nota: '))
    print()
    if not2 <1 or not2 >7:
        print('Error: Ingrese una nota válida')
    else:
        not3 = float(input('Ingrese su tercera nota: '))
        print()
        if not3 <1 or not3 >7:
            print('Error: Ingrese una nota válida')
        else:
            print('---------------------------------------------------')
            print()
            print('Notas de Evaluaciones cortas:')
            print()
            print('---------------------------------------------------')
            ev1 = float(input('Ingrese su primera nota: '))
            print()
            if ev1 <1 or ev1 >7:
                print('Error: Ingrese una nota válida')
            else:
                ev2 = float(input('Ingrese su segunda nota: '))
                print()
                if ev2 <1 or ev2 >7:
                    print('Error: Ingrese una nota válida')
                else:
                    print('---------------------------------------------------')
                    print()

                    evT = (ev1*0.5)+(ev2*0.5)
                    notF = (not1*0.2)+(not2*0.3)+(not3*0.4)+(evT*0.1)

                    if notF >= 4:
                        print('¡Felicidades! tu nota de cátedra es:', notF)
                        print()
                        print('¡Aprobaste la cátedra!')
                        exa = notF
                    elif notF > 3.4 and notF < 4:
                        print('Tu nota es:', notF)
                        exa = float(input('Ingrese su nota del examen: '))
                        if exa <1 or exa >7:
                            print('Error: Ingrese una nota válida')
                        else:
                            if exa >= 4:
                                print('¡Aprobaste la cátedra!')
                                print('¡Felicidades!')
                            else:
                                print('No aprovaste la cátedra :(')
                                print('¡Suerte el proximo año!')
                        if notF < 3.4:
                            exa = notF
                            print('Tu nota es:', notF)
                            print('No aprovaste la cátedra :(')
                            print('¡Suerte el proximo año!')
                        print()
                        print()
                        print('Nota de Taller')
                        print()
                        print('---------------------------------------------------')
                        tall = float(input('Ingrese su nota: '))
                        print()
                        if tall <1 or tall >7:
                            print('Error: Ingrese una nota válida')
                        else:
                            alum = float(input('Ingrese la cantidad de alumnos en el taller: '))
                            print('---------------------------------------------------')
                            if alum !=2 and alum !=3:
                                print('Error: Número de alumnos inválido')
                            else:
                                if alum == 2:
                                    tallF = tall + 0.3
                                    if tallF > 7:
                                        tallF = 73
                                    print('Tu nota final de Taller es:', tallF)
                                else:
                                    tallF = tall
                                if tallF >= 4:
                                    print('¡Aprobaste el Taller!')
                                else:
                                    print('No aprovaste el Taller :(')
                                    print('¡Suerte el proximo año!')

                                notFA = tallF*0.3 + exa*0.7
                                print('Tu nota final de la asignatura es:', notFA)