#include "Axe.inc"
	
;copy column to be shifted in into buffer (de)
;sprite format 12 rows $AAA0
;Requirements for routine
;shift left; buffer+767 in HL
;shift right; buffer in HL
;sprite table in DE
;tiles must be stored in 16x12 format
;so in order to draw tilemap...need to use bitmap function...not that bad actually
.db $4444
.db 0
ShiftTileMapLeft:
	
	;ld hl, sprite buffer
	;push de
	;ex de, hl
	;ld hl, gbuf
	ld b, 64	;number of rows to shift
scrollRowLeft:	
	ex de, hl	;put sprite buffer to hl
	rl (hl)		;shift first 4 bits
	dec hl
	rl (hl)		;shift next 8 bits
	dec hl		;shift buffer position 2 bytes
	ex de, hl	;carry flag successfully set, now for screen shifting
	;or a
	
	rl (hl) \ dec hl

	rl (hl) \ dec hl		
	rl (hl) \ dec hl

	rl (hl) \ dec hl

	rl (hl) \ dec hl

	rl (hl) \ dec hl
	
	rl (hl) \ dec hl

	rl (hl) \ dec hl

	rl (hl) \ dec hl
	rl (hl) \ dec hl
	
	rl (hl) \ dec hl

	rl (hl) \ dec hl	;shift whole bottom row 1 pixel, hooray

	djnz scrollRowLeft	;repeat for all 64 rows
	;pop de
	ret

ShiftTileMapRight:
	
	
	xor a
	ld b,72
label:
	rrd \ inc hl
	rrd \ inc hl
	rrd \ inc hl
	rrd \ inc hl
	djnz label
	
;AF0648ED6723ED6723ED6723ED672310F2

	ld b,64
scrollRowRight:

	ex de, hl
	rr (hl)
	inc hl
	rr (hl)
	inc hl
	ex de, hl
	
	rr (hl) \ inc hl
	rr (hl) \ inc hl

	rr (hl) \ inc hl

	rr (hl) \ inc hl

	rr (hl) \ inc hl

	rr (hl) \ inc hl

	rr (hl) \ inc hl

	rr (hl) \ inc hl

	rr (hl) \ inc hl

	rr (hl) \ inc hl

	rr (hl) \ inc hl

	rr (hl) \ inc hl


	djnz scrollRowRight
	ret


;213F96
;0640
;EBCB162B
;CB162BEB
;CB162BCB162BCB162BCB162BCB162BCB162BCB162BCB162BCB162BCB162BCB162BCB162B
;10D2
;C9

;214093
;0640
;EBCB1E23CB1E23EB
;CB1E23CB1E23CB1E23
;CB1E23CB1E23CB1E
;23CB1E23CB1E23CB
;1E23CB1E23CB1E23
;CB1E23
;10D2
;C9


scrollVertical:


;spritebuffer hl
;gbuf hl

;vertical +/-

	ld bc,4<<8+$FF	;some crap runer gave me, equivalent to ld b,4 but makes ldi's work
label1:
	ldi	;write first sprite byte to screen

	ld a,(hl)
	ld (de),a	;draw 3rd nibble (and draw 00 for 4th nibble)
			
	push de		;move to next sprite
	ld de, 23
	add hl, de
	pop de

	xor a
	rrd \ inc hl	;shift unaligned tile over 1 nibble
	rrd \ dec hl	;finish shifting, return to first byte

	ld a,(de)
	or (hl)	
	ld (de),a	;draw 4th nibble by or-ing $0X
	inc hl
	inc de
	
	ldi	;write 3rd sprite byte to screen

	push de
	ld de, 22
	add hl, de
	pop de		;next sprite

	djnz label1
	ret
;01FF04EDA0
;7E12D511170019D1
;AFED6723ED672B1A
;B6122313EDA0D511
;160019D110E0C9








