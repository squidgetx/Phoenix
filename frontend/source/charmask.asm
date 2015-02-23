#include "Axe.inc"

.db $00,$00


mask16:
;Grayscale mask command with 16x16 sprites

;Masked Sprite Format
;3 layers, 12x16
;Mask applied to both buffers
;Front Buffer
;Back Buffer
;SpritePointer always $8528
;byte to draw axv_R2 (X + y*12*12 + 48)
;aligned un/aligned axv_R1
	ld hl,(axv_R1)
	ld b,l
	xor a \ cp b
	jr z, draw
	ld hl,$8528
	ld b, 16
shiftMask:
	ld a, $FF
	rrd \ inc hl
	rrd \ inc hl
	djnz shiftMask
	ld b, 32
	xor a
shiftSprites:
	rrd \ inc hl
	rrd \ inc hl
	djnz shiftSprites

draw:
	ld hl,$9340		;drawposition in hl
	ld ix,$8528		;sprite mask pointer
	ld de,(axv_R2)
	add hl, de
	ld b,16
	ld de, 11
drawFront:
	
	ld a, (ix)
	and (hl)
	or (ix+32)
	ld (hl), a
	inc hl
	inc ix

	ld a, (ix)
	and (hl)
	or (ix+32)
	ld (hl), a
	add hl,de
	inc ix
	
	djnz drawFront


	ld hl,$9872	;reset registers
	ld ix,$8528	
	ld de,(axv_R2)
	add hl, de
	ld b, 16
	ld de,11
drawBack:
	ld a, (ix)
	and (hl)
	or (ix+64)
	ld (hl), a
	inc hl
	inc ix

	ld a, (ix)
	and (hl)
	or (ix+64)
	ld (hl), a
	add hl,de
	inc ix
	
	djnz drawBack
