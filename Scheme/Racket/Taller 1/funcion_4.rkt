#lang racket

(define (contarVeces n lista)
  (cond
    [(empty? lista) 0]
    [(= (first lista) n) (+ 1 (contarVeces n (rest lista)))]
    [else (contarVeces n (rest lista))]
  )
)

(println (contarVeces 5 '(11 5 12 5 32 0 5 99 105 5)))
