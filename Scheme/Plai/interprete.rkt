#lang plai

(define factorial (
  lambda (n) (
    if (< n 0)
      (error ("no se puede calcular el factorial de un numero negativo"))
      (if (= n 0)
        1
        (* n (factorial (- n 1)))
      )
    )
  )
)

(define (ejecutar expr)
  (cond
    [(list? expr)
      (let ([left (first expr)]
            [mid (second expr)]
            [right (third expr)])
        (cond
          [(and (eq? mid '+) (eq? right '+)) (+ (ejecutar left) 1)]
          [(and (eq? mid '-) (eq? right '-)) (- (ejecutar left) 1)]
          [(eq? mid '+) (+ (ejecutar left) (ejecutar right))]
          [(eq? mid '-) (- (ejecutar left) (ejecutar right))]
          [(eq? mid '*) (* (ejecutar left) (ejecutar right))]
          [(eq? mid '^) (expt (ejecutar left) (ejecutar right))]
          [(eq? mid '%) (modulo (ejecutar left) (ejecutar right))]
          [(eq? mid '/) 
            (cond
              [(zero? (ejecutar right)) (error "Error division por 0")]
              [else (/ (ejecutar left) (ejecutar right))]
            )
          ]
          [((eq? mid '!))(factorial (ejecutar left))]
         [else (error "operación desconocida")])
      )
    ]
    [else expr]
  )
)



; Prueba de la función ejecutar
(test (ejecutar 3) 3)
(test (ejecutar '(2 + +)) 3)
(test (ejecutar '(2 - -)) 1)
(test (ejecutar '(3 + 4)) 7)
(test (ejecutar '(3 + (3 + 4))) 10)
(test (ejecutar '(3 - 4)) -1)
(test (ejecutar '(3 - (3 - 4))) 4)
(test (ejecutar '(3 * 4)) 12)
(test (ejecutar '(3 * (3 * 4))) 36)
(test (ejecutar '(3 ^ 4)) 81)
(test (ejecutar '(1 ^ (3 ^ 4))) 1)
(test (ejecutar '(3 % 4)) 3)
(test (ejecutar '(3 % (3 % 4))) 0)
(test (ejecutar '(3 / 4)) 3/4)
(test (ejecutar '(3 / (3 / 4))) 4)
(test (ejecutar '(3 !)) 6)

(test/exn (ejecutar '(3 / 0)) "Error division por 0")
(test/exn (ejecutar '(3 / (3 / 0))) "Error division por 0")
