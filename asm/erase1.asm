#include "Axe.inc"
.dw 0
fill0:
	;fill area of screen with a blank area 12x16 in size at bufaddress hl,r1
	;r2; aligned or no
	
	ld de, axr_L6
	ld c,2
	
fillLoopz:
	push bc
	ld hl,(axv_R2)
	ld c,l
	ld hl, (axv_R1)
	add hl,de
	ld b,16
	ld de, 11
loopz:	
	dec c
	inc c
	jr z, unAligned
aligned:
	ld (hl),$00
	inc hl
	ld a,(hl)
	and $0F
	ld (hl), a
	jr endLoop
unAligned:
	ld a, (hl)
	and $F0
	ld (hl), a
	inc hl
	ld (hl),$00
endLoop:

	add hl, de
	djnz loopz
	ld de, axr_L3
	pop bc
	dec c
	jr nz, fillLoopz
	
