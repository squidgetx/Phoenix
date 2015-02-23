#include "Axe.inc"
.dw 0
;Lbl AddI
;Add item id r1
;Takes oItem in hl
;oItem->E
;while 1
;!if {e}-r1
;{e+1}++
;ret
;end
;e+2->e
;end!if {e}
;r1->{e}
;1->{e+1}
;ret
	ld a,(axv_r1)
loop:
	cp (hl)
	jr nz, noMatch
	inc hl
	inc (hl)
	ret
noMatch:
	inc hl
	inc hl
	xor a
	cp (hl)
	ld a,(axv_r1)
	jr nz, loop
	ld (hl),a
	inc hl
	ld (hl),1
	ret



