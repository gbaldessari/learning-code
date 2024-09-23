#lang racket

(define (ascendente lista)
  (cond
    [(empty? lista) #t]
    [(empty? (rest lista)) #t]
    [(<= (first lista) (second lista)) (ascendente (rest lista))]
    [else #f]
  )
)

(define (descendente lista)
  (cond
    [(empty? lista) #t]
    [(empty? (rest lista)) #t]
    [(>= (first lista) (second lista)) (descendente (rest lista))]
    [else #f]
  )
)

(define (estaOrdenada lista)
  (or (ascendente lista) (descendente lista))
)


(println (estaOrdenada '(1 2 3 4 5)))
(println (estaOrdenada '(5 4 3 2 1)))
(println (estaOrdenada '()))
(println (estaOrdenada '(1 2 3 2 1)))
