#lang racket

(displayln "Hello, world!")

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

(displayln "h")
(displayln "o")
(displayln "l")
(displayln "a")

(define l (list 1 2 3 4 5 6))
(displayln l)
(car l)
(car (cdr l))
(car (cdr (cdr l)))
(cdr l)
(cdr (cdr l))
(displayln (length l))

(if (=(remainder (length l) 2) 0)
  (displayln #t)
  (displayln #f)
)
