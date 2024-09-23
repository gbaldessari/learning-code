#lang racket

; palindromo lista

; (define lista (list 1 2 3 2 1))

; (define palindromo
;   (lambda (l)
;     (if (null? l)
;       #t
;       (if (= (car l) (car (reverse l)))
;         (palindromo (cdr (reverse (cdr l))))
;         #f
;       )
;     )
;   )
; )

; (println (palindromo lista))

; promedio lista

(define lista2 (list 1 2 3 4 5 6 7 8 9 10))

(define promedio
  (lambda (l)
    (if (null? l)
      0
      (/ (+ (car l) (promedio (cdr l))) (length l))
    )
  )
)

(println (promedio lista2))