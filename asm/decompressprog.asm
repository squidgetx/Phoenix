#include "Axe.inc"

.dw 0

;DECOMPRESSMAP
;axv_R2:output-where to write
;DEFAULT ADD 48TO output WHEN ROW FULL
;"the difference for an app is instead you would ret z, use port 7, and ld h,$80"
;hl already has the offset in it (y2+offset)
	in a,(6)		;backup page
	push af
	ld c,$FF		;c is bytes to go
	ld de, (axv_Y2)
	add hl,de
	ld de,(axv_R2)
	ld a,(axv_Y2Page)
	ld b,a
	ld a,h \ rlca \ rlca \ ;dec a 
	and %00000011
	add a,b
	out (6),a
	res 7, h \ set 6, h
	
				;hl now pointing to mem properly
deCompLoop:
	bit 6,h \ jr nz, $+9 \ in a,(6) \ inc a \ out (6),a \ ld h,$40
	ld a,$FF
	cp (hl)						;check if run
	jr nz, noRun
	inc hl
	bit 6,h \ jr nz, $+9 \ in a,(6) \ inc a \ out (6),a \ ld h,$40
	

	ld b, (hl)					;how many times to copy byte
	inc hl
	bit 6,h \ jr nz, $+9 \ in a,(6) \ inc a \ out (6),a \ ld h,$40			
							;now hl points to byte to be drawn
run:
	ld a,c
	ldi \ dec hl					;copy byte, change c, but keep hl the same
	and %00001111					;c mod 16
	jr nz, noNewRow
;newRow								a is already 0 from the and %00001111
	inc c
	jr z, done
	dec c						;quit if c is 256
	ld a,e \ add a,32 \ ld e,a \ jr nc,$+3 \ inc d	;add 32 to de
noNewRow:
	djnz run

	inc hl						;point hl to next entry in map data
	jr deCompLoop


noRun:
	ld a,c
	ldi
	and %00001111	
	jr nz, deCompLoop
;newRow;
	inc c
	jr z, done
	dec c
	ld a,e \ add a,32 \ ld e,a \ jr nc,$+3 \ inc d	
	jr deCompLoop
done:
	pop af
	out (6),a
