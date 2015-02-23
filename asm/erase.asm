#include "Axe.inc"
.dw 0
;erase 24x24 or 32x32 area of screen starting at byte hl, r1 in $83A5
;input a=0, 32x32, otherwise 24x24
	ld de, axr_L6
	add hl, de
	ld c, 1
loop0:
	ld de, 10
	ld b,24
	cp 0
	jr nz, $+4
	ld b,32
loop:
	ld (hl),0 \ inc hl
	ld (hl),0 \ inc hl
	ld (hl),0
	cp 0
	jr nz, skip
	inc hl
	ld (hl),0
	dec hl
skip:
	add hl, de
	djnz loop
	ld hl, (axv_R1)
	ld de, axr_L3
	add hl, de
	dec c
	jr z, loop0
