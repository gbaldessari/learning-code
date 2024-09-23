#lang racket

(displayln "Hello, world!")

(displayln "h")
(displayln "o")
(displayln "l")
(displayln "a")

(define f (
  lambda (x) 
    (+ x 1)
  )
)
(displayln (f 2))
(define g f)

(displayln (g 4))

(define mayor (
  lambda(a b) (
    if (> a b)
      a 
      b
    )
  )
)
(displayln (mayor 5 7))
(displayln (or #t #f #f #f))
(displayln (and #t #t #t #f))
(displayln (not #t))
(displayln (sqrt 9))
(displayln (sqrt 18))
(displayln (sqrt (/ -1 4)))

(define l (list 1 2 3 4 5 6))
(displayln l)
(car l)
(car (cdr l))
(car (cdr (cdr l)))
(cdr l)
(cdr (cdr l))
(displayln (length l))

(car(cdr (list 1 2 3 4)))
(cadr (list 1 2 3 4))

(if (=(remainder (length l) 2) 0)
  (displayln #t)
  (displayln #f)
)

;(5 * (12/3 + 8/4) + 10/(2 + 3))
(displayln (+ (* 5 (+ (/ 12 3) (/ 8 4))) (/ 10 (+ 2 3))))

(define condicion 5)
(cond
  [(> condicion 5) (displayln "mayor a 5")]
  [(< condicion 5) (displayln "menor a 5")]
  [(= condicion 5) (displayln "igual a 5")]
)

(define for (
  lambda (x) (
    if (null? x) (
      displayln "funcion terminada")
      ;else
      (begin
        (displayln (car x))
        (for (cdr x))
      )
    )
  )
)

(define myList (list 1 2 3 4 5 6))
(for myList)
