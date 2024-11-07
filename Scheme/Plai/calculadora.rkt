#lang plai

(define-type ExpArit
  [Number (n number?)]
  [add (e1 ExpArit?) (e2 ExpArit?)]
  [sub (e1 ExpArit?) (e2 ExpArit?)]
  [mul (e1 ExpArit?) (e2 ExpArit?)]
  [div (e1 ExpArit?) (e2 ExpArit?)]
)

(define (interprete exp)
  (type-case ExpArit exp
    [Number (n) n]
    [add (e1 e2) (+ (interprete e1) (interprete e2))]
    [sub (e1 e2) (- (interprete e1) (interprete e2))]
    [mul (e1 e2) (* (interprete e1) (interprete e2))]
    [div (e1 e2) 
      (cond
        [(zero? (interprete e2)) (error "Error division por 0")]
        [else (/ (interprete e1) (interprete e2))]
      )
    ]
  )
)

(test (number? 3) #t)
(test (Number? (Number 3)) #t)
(test (add? (add (Number 3) (Number 4))) #t)
(test (sub? (sub (Number 3) (Number 4))) #t)
(test (mul? (mul (Number 3) (Number 4))) #t)
(test (div? (div (Number 3) (Number 4))) #t)

(test (interprete (Number 3)) 3)
(test (interprete (add (Number 3) (Number 4))) 7)
(test (interprete (add (Number 3) (add (Number 3) (Number 4)))) 10)
(test (interprete (sub (Number 3) (Number 4))) -1)
(test (interprete (sub (Number 3) (sub (Number 3) (Number 4)))) 4)
(test (interprete (mul (Number 3) (Number 4))) 12)
(test (interprete (mul (Number 3) (mul (Number 3) (Number 4)))) 36)
(test (interprete (div (Number 3) (Number 4))) 3/4)
(test (interprete (div (Number 3) (div (Number 3) (Number 4)))) 4)
(test/exn (interprete (div (Number 3) (Number 0))) "Error division por 0")
