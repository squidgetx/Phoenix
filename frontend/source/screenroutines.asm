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
	
	
	
	




	
