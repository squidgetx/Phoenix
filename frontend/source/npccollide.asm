#include "Axe.inc"

;NPC collision check routine
;return 0 in hl if no npc found, otherwise return address of npc data entry+1 in hl
;input words (or bytes) x,y in $83A5 and $83A7 (Axe axv_R1,axv_R2)

.dw 0 
	ld hl,$8000	;beginning of npc array
	ld a,($851F)	;how many npcs there are
	ld b, a		;copy to b
	xor a		;zero a
	cp b		;is it zero?
	jr nz, check
	ld hl,0
	ret
	
check:
	ld de, 4
loop:
	ld a,(axv_R1)	;load axv_R1 to a
	ld c,a		;copy to c
	ld a,(hl)	
	sub c
	add a,16	;a=(hl)-axv_R1+16
	jr nz, noMatch	

	inc hl		;next byte in npc entry
	ld a,(axv_R2)	;load axv_R2 to a
	ld c,a		;copy to c
	ld a,(hl)	
	sub c
	add a,16	;a=(hl)-axv_R1+16
	jr nz, noMatch
	
	ret
	
noMatch:
	add hl, de
	djnz loop
	ld hl,0
	ret
