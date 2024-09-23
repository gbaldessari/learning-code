#lang racket

(define (aplanarLista lista)
  (cond
    [(empty? lista) '()]
    [(list? (first lista)) (append (aplanarLista (first lista)) (aplanarLista (rest lista)))]
    [else (cons (first lista) (aplanarLista (rest lista)))]
  )
)

(println (aplanarLista '((1 (2 3) 4) 5 (6))))
