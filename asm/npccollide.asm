#include "Axe.inc"

;NPC/Trigger collision check routine
;return 0 in hl if no npc found, otherwise return address of npc data entry+1 in hl
;input words (or bytes) x,y in axv_R1,axv_R2

.dw 0 
	;For NPC, prefix routine with this:
	;ld hl,$8000	;beginning of npc array
	;ld a,(axr_L5+$17)	;how many npcs there are
	;ld de, 5
	;2100803A1F85110500
	;For Trigger tiles, use this:
	;ld hl,($8179)
	;ld a,(axr_L5+$18)
	;ld de, 4
	;2A79813A2085110400
begin:
	ld b, a		;copy to b
	xor a		;zero a
	cp b		;is it zero?
	jr nz, loop
	ld hl,0
	ret
	
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
	dec hl
	sub c
	add a,16	;a=(hl)-axv_R1+16
	jr nz, noMatch
	inc hl
	ret
	
noMatch:
	add hl, de
	djnz loop
	ld hl,0
	ret
