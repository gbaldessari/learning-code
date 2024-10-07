#lang racket

(define (mult-2 l)
  (map (lambda (x) (* 2 x)) l)
)

(define (filter-men-2 l)
  (filter (lambda (x) (<= x 2)) l)
)



(define l '(1 2 3 4 5 6 7))

(println (reverse l))

(println (mult-2 l))
(println (filter-men-2 l))
