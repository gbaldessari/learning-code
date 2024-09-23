#lang racket

(define (contadorListas lista)
  (define (contadorListasAux lista)
    (cond
      [(empty? lista) 0]
      [(list? (first lista)) (+ 1 (contadorListasAux (first lista)) (contadorListasAux (rest lista)))]
      [else (contadorListasAux (rest lista))]
    )
  )
  (if (list? lista)
      (+ 1 (contadorListasAux lista))
      0)
)

(println (contadorListas 1))
(println (contadorListas '(1 2 3 4 5 6 7 8)))
(println (contadorListas '(1 (2 3 4 5 6) 7 8)))
(println (contadorListas '(1 (2 3 (4) 5 6) 7 8)))
(println (contadorListas '((1) (2 3 (4) 5 6) 7 8)))
(println (contadorListas '((1) (2 3 (4) (5 6)) 7 8)))
(println (contadorListas '((1) ((2 3 (4) (5 6)) 7) 8)))
(println (contadorListas '((1) ((2 3 (4) (5 6)) 7) (8))))
