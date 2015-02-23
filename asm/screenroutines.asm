#include "Axe.inc"


.dw 0
backupScreen:
;take 16x16 sprite from r1 and store to L1+384
	ld de, axr_L6			;r1 already in hl
	add hl, de				;source
	ld de,axr_L1 + 384		;destination
	ld c,2
loop1:
	ld b,16
loop:
	ldi
	ldi
	inc bc
	inc bc
	ld a,l
	add a,10
	ld l,a
	jr nc, $+3
	inc h
	djnz loop
	ld de, axr_L3
	ld hl,(axv_R1)
	add hl, de
	ld de,axr_L1 + 384 + 32
	dec c
	jr nz, loop1
	
.dw 0
.dw 0

restoreScreen:
	ld de, axr_L6
	add hl, de
	ex de, hl
	ld hl,axr_L1 + 384
	ld c,2
looop1:
	ld b,16
looop:
	ldi
	ldi
	inc bc
	inc bc
	ld a,e
	add a,10
	ld e,a
	jr nc, $+3
	inc d
	djnz looop
	ld hl, (axv_R1)
	ld de, axr_L3
	add hl, de
	ex de, hl
	ld hl,axr_L1 + 384 + 32
	dec c
	jr nz,looop1
.dw 0
.dw 0
fillM:
;hl aready has address in it
	ld a,72
	ld c,16
	ld de,32
fillLoop:
	ld b,16
copyLoop:
	ld (hl),a
	inc hl
	djnz copyLoop
	add hl,de
	dec c
	jr nz,fillLoop



	
	
	




	
