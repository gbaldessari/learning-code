import pygame
import random

# Inicializar pygame
pygame.init()

# Configuración de la ventana
WIDTH = 800
HEIGHT = 600
FPS = 60
window = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Carrera")

# Definir colores
BLACK = (0, 0, 0)
WHITE = (255, 255, 255)
RED = (255, 0, 0)
GREEN = (0, 255, 0)
BLUE = (0, 0, 255)

# Cargar imágenes
car_image = pygame.image.load("car.png")
car_image = pygame.transform.scale(car_image, (50, 80))
background_image = pygame.image.load("background.png")
background_image = pygame.transform.scale(background_image, (WIDTH, HEIGHT))

# Clase para los objetos que aparecen en la pantalla
class Object(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.image = pygame.Surface([30, 30])
        self.image.fill(GREEN)
        self.rect = self.image.get_rect()
        self.rect.x = random.randrange(0, WIDTH - self.rect.width)
        self.rect.y = random.randrange(-100, -40)
        self.speedy = random.randrange(1, 8)

    def update(self):
        self.rect.y += self.speedy
        if self.rect.top > HEIGHT + 10:
            self.rect.x = random.randrange(0, WIDTH - self.rect.width)
            self.rect.y = random.randrange(-100, -40)
            self.speedy = random.randrange(1, 8)

# Clase para la nave del jugador
class Player(pygame.sprite.Sprite):
    def __init__(self):
        super().__init__()
        self.image = car_image
        self.rect = self.image.get_rect()
        self.rect.centerx = WIDTH / 2
        self.rect.bottom = HEIGHT - 10
        self.speedx = 0

    def update(self):
        self.speedx = 0
        keystate = pygame.key.get_pressed()
        if keystate[pygame.K_LEFT]:
            self.speedx = -5
        if keystate[pygame.K_RIGHT]:
            self.speedx = 5
        self.rect.x += self.speedx
        if self.rect.right > WIDTH:
            self.rect.right = WIDTH
        if self.rect.left < 0:
            self.rect.left = 0

# Grupos de sprites
all_sprites = pygame.sprite.Group()
objects = pygame.sprite.Group()

# Crear objetos que aparecen en la pantalla
for i in range(10):
    obj = Object()
    all_sprites.add(obj)
    objects.add(obj)

# Crear jugador
player = Player()
all_sprites.add(player)

# Loop principal del juego
running = True
while running:
    # Manejo de eventos
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    # Actualizar objetos
    all_sprites.update()

    # Verificar colisión
    hits = pygame.sprite.spritecollide(player, objects, False)
    if hits:
        running = False

    # Dibujar
    window.blit(background_image, (0, 0))
    all_sprites.draw(window)

    # Actualizar pantalla
    pygame.display.flip()

# Salir del juego
pygame.quit()
