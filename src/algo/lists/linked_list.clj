(ns cds.linked-list
  )

(definterface INode
  (getCar [])
  (getCdr [])
  (setCar [new-car])
  (setCdr [new-cdr])
  (reverse []))

(deftype Node
  [^:volatile-mutable car
   ^:volatile-mutable cdr]
  INode
  (getCar [_] car)
  (getCdr [_] cdr)
  (setCar [_ new-car] (set! car new-car))
  (setCdr [_ new-cdr] (set! cdr new-cdr))
  (reverse [this]
    (loop [cur this new-head nil]
      (if-not cur
        new-head
        (recur (.getCdr cur) (Node. (.getCar cur) new-head)))))
  )

(def list-simple (Node. "b" (Node. "a" nil)))
(def list-cmplx (Node. "d" (Node. "c" (Node. "b" (Node. "a" nil)))))
