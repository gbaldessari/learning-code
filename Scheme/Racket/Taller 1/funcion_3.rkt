#lang racket

(define (eliminarMenores n lista)
  (cond
    [(empty? lista) '()]
    [(<= (first lista) n) (eliminarMenores n (rest lista))]
    [else (cons (first lista) (eliminarMenores n (rest lista)))]
  )
)

(eliminarMenores 10 '(15 8 10 11 9 22 -12 40)) 
