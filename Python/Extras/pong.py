import turtle

# Configuración inicial de la ventana
window = turtle.Screen()
window.title("Pong Game")
window.bgcolor("black")
window.setup(width=600, height=400)

# Crear paleta A
paddle_a = turtle.Turtle()
paddle_a.speed(0)
paddle_a.shape("square")
paddle_a.color("white")
paddle_a.shapesize(stretch_wid=6, stretch_len=2)
paddle_a.penup()
paddle_a.goto(-250, 0)

# Crear paleta B
paddle_b = turtle.Turtle()
paddle_b.speed(0)
paddle_b.shape("square")
paddle_b.color("white")
paddle_b.shapesize(stretch_wid=6, stretch_len=2)
paddle_b.penup()
paddle_b.goto(250, 0)

# Crear pelota
ball = turtle.Turtle()
ball.speed(40)
ball.shape("circle")
ball.color("white")
ball.penup()
ball.goto(0, 0)
ball.dx = 2
ball.dy = 2

# Funciones para mover las paletas hacia arriba y hacia abajo
def paddle_a_up():
    y = paddle_a.ycor()
    y += 20
    paddle_a.sety(y)

def paddle_a_down():
    y = paddle_a.ycor()
    y -= 20
    paddle_a.sety(y)

def paddle_b_up():
    y = paddle_b.ycor()
    y += 20
    paddle_b.sety(y)

def paddle_b_down():
    y = paddle_b.ycor()
    y -= 20
    paddle_b.sety(y)

# Conexión de las teclas con las funciones de movimiento
window.listen()
window.onkeypress(paddle_a_up, "w")
window.onkeypress(paddle_a_down, "s")
window.onkeypress(paddle_b_up, "Up")
window.onkeypress(paddle_b_down, "Down")

# Bucle principal del juego
while True:
    window.update()

    # Movimiento de la pelota
    ball.setx(ball.xcor() + ball.dx)
    ball.sety(ball.ycor() + ball.dy)

    # Rebotar en la parte superior e inferior
    if ball.ycor() > 190 or ball.ycor() < -190:
        ball.dy *= -1

    # Rebotar en las paletas
    if (ball.xcor() > 240 and ball.xcor() < 250) and (ball.ycor() < paddle_b.ycor() + 60 and ball.ycor() > paddle_b.ycor() - 60):
        ball.dx *= -1

    if (ball.xcor() < -240 and ball.xcor() > -250) and (ball.ycor() < paddle_a.ycor() + 60 and ball.ycor() > paddle_a.ycor() - 60):
        ball.dx *= -1
