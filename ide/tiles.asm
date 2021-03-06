#include "tileout.asm"

 ;Tile 0
 .db $FF,$FF,$F9,$FF,$E0,$3F,$C0,$7F,$C0,$3F,$80,$3F,$C0,$3F,$C0,$3F
 .db $E0,$7F,$C0,$3F,$80,$1F,$80,$1F,$C0,$3F,$C0,$3F,$80,$1F,$80,$1F
;Tile 1
 .db $00,$00,$04,$00,$10,$00,$20,$00,$20,$00,$49,$00,$09,$40,$20,$40
 .db $1F,$80,$39,$C0,$7F,$E0,$59,$A0,$3F,$C0,$3F,$C0,$7F,$E0,$79,$E0
 .db $00,$00,$02,$00,$0B,$C0,$13,$80,$1F,$C0,$3F,$C0,$39,$C0,$20,$40
 .db $1F,$80,$39,$C0,$66,$60,$50,$A0,$20,$40,$3F,$C0,$7F,$E0,$79,$E0
 ;Tile 2
 .db $F9,$FF,$E0,$7F,$C0,$3F,$C0,$3F,$80,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$3F,$80,$1F,$80,$1F,$C0,$3F,$C0,$3F,$C0,$3F,$C6,$3F,$C7,$FF
;Tile 3
 .db $00,$00,$00,$00,$00,$00,$00,$00,$09,$00,$09,$40,$20,$40,$1F,$80
 .db $39,$C0,$7F,$E0,$79,$A0,$3F,$C0,$3F,$C0,$3F,$C0,$39,$C0,$38,$00
 .db $06,$00,$1F,$80,$33,$C0,$3F,$C0,$7F,$C0,$39,$C0,$20,$40,$1F,$80
 .db $39,$C0,$66,$60,$60,$A0,$20,$40,$3F,$C0,$3F,$C0,$39,$C0,$38,$00
 ;Tile 4
 .db $F9,$FF,$E0,$3F,$C0,$7F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$3F,$80,$1F,$80,$1F,$C0,$3F,$C0,$3F,$C0,$3F,$C6,$3F,$FE,$3F
;Tile 5
 .db $00,$00,$00,$00,$00,$00,$00,$00,$09,$00,$29,$00,$20,$40,$1F,$80
 .db $39,$C0,$7F,$E0,$59,$E0,$3F,$C0,$3F,$C0,$3F,$C0,$39,$C0,$01,$C0
 .db $06,$00,$1F,$C0,$33,$80,$3F,$C0,$3F,$C0,$39,$C0,$20,$40,$1F,$80
 .db $39,$C0,$66,$60,$50,$60,$20,$40,$3F,$C0,$3F,$C0,$39,$C0,$01,$C0
 ;Tile 6
 .db $FF,$FF,$F9,$FF,$C0,$7F,$E0,$3F,$C0,$3F,$80,$1F,$C0,$3F,$C0,$3F
 .db $E0,$7F,$C0,$3F,$80,$1F,$80,$1F,$C0,$3F,$C0,$3F,$80,$1F,$86,$1F
;Tile 7
 .db $00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$20,$40
 .db $19,$80,$3F,$C0,$79,$E0,$69,$60,$3F,$C0,$3F,$C0,$7F,$E0,$79,$E0
 .db $00,$00,$06,$00,$3F,$80,$1C,$C0,$3F,$C0,$7F,$E0,$3F,$C0,$2F,$40
 .db $19,$80,$36,$C0,$60,$60,$60,$60,$20,$40,$3F,$C0,$7F,$E0,$79,$E0
 ;Tile 8
 .db $F9,$FF,$C0,$7F,$E0,$3F,$C0,$3F,$80,$1F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$3F,$80,$1F,$00,$1F,$80,$3F,$C0,$3F,$C0,$3F,$C6,$3F,$C7,$FF
;Tile 9
 .db $00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$20,$40,$19,$80
 .db $3F,$C0,$79,$E0,$A9,$60,$7F,$C0,$3F,$C0,$3F,$C0,$39,$C0,$38,$00
 .db $06,$00,$3F,$80,$1C,$C0,$3F,$C0,$7F,$E0,$3F,$C0,$2F,$40,$19,$80
 .db $36,$C0,$60,$40,$A0,$40,$60,$40,$3F,$C0,$3F,$C0,$39,$C0,$38,$00
 ;Tile 10
 .db $F9,$FF,$C0,$7F,$E0,$3F,$C0,$3F,$80,$1F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$3F,$80,$1F,$80,$0F,$C0,$1F,$C0,$3F,$C0,$3F,$C6,$3F,$FE,$3F
;Tile 11
 .db $00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$20,$40,$19,$80
 .db $3F,$C0,$79,$E0,$69,$50,$3F,$E0,$3F,$C0,$3F,$C0,$39,$C0,$01,$C0
 .db $06,$00,$3F,$80,$1C,$C0,$3F,$C0,$7F,$E0,$3F,$C0,$2F,$40,$19,$80
 .db $36,$C0,$20,$60,$20,$50,$20,$60,$3F,$C0,$3F,$C0,$39,$C0,$01,$C0
 ;Tile 12
 .db $FF,$FF,$D1,$FF,$E0,$3F,$C0,$7F,$80,$3F,$80,$3F,$C0,$3F,$C0,$3F
 .db $E0,$7F,$F0,$3F,$E0,$3F,$E0,$3F,$E0,$3F,$E0,$3F,$C0,$3F,$C0,$7F
;Tile 13
 .db $00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$08,$00,$28,$40,$20,$40
 .db $1F,$80,$09,$C0,$16,$C0,$19,$40,$1F,$C0,$1F,$C0,$3F,$C0,$3F,$80
 .db $00,$00,$2E,$00,$1F,$C0,$33,$80,$7F,$C0,$6F,$C0,$2B,$C0,$21,$C0
 .db $1F,$80,$0A,$C0,$17,$40,$19,$C0,$16,$40,$1F,$C0,$3F,$C0,$3F,$80
 ;Tile 14
 .db $C1,$FF,$E0,$3F,$C0,$7F,$80,$3F,$80,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $F0,$3F,$E0,$3F,$E0,$1F,$E0,$3F,$E0,$3F,$C0,$3F,$E0,$1F,$FE,$1F
;Tile 15
 .db $00,$00,$00,$00,$00,$00,$00,$00,$08,$00,$28,$40,$20,$40,$1F,$80
 .db $09,$C0,$1C,$C0,$13,$60,$1F,$C0,$1F,$C0,$3F,$C0,$1F,$E0,$01,$E0
 .db $2E,$00,$1F,$C0,$33,$80,$7F,$C0,$6F,$C0,$2B,$C0,$21,$C0,$1F,$80
 .db $0A,$40,$1D,$40,$12,$60,$1C,$40,$1F,$C0,$3F,$C0,$1F,$E0,$01,$E0
 ;Tile 16
 .db $C1,$FF,$E0,$3F,$C0,$7F,$80,$3F,$80,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $F0,$3F,$E0,$3F,$E0,$3F,$E0,$3F,$E0,$1F,$E0,$0F,$C0,$0F,$C1,$FF
;Tile 17
 .db $00,$00,$00,$00,$00,$00,$00,$00,$08,$00,$28,$40,$20,$40,$1F,$80
 .db $09,$C0,$13,$C0,$14,$C0,$17,$C0,$1F,$E0,$1F,$F0,$3F,$F0,$3E,$00
 .db $2E,$00,$1F,$C0,$33,$80,$7F,$C0,$6F,$C0,$2B,$C0,$21,$C0,$1F,$80
 .db $0A,$C0,$13,$40,$14,$C0,$1B,$40,$1F,$E0,$1F,$F0,$3F,$F0,$3E,$00
 ;Tile 18
 .db $FF,$FF,$F8,$BF,$C0,$7F,$E0,$3F,$C0,$1F,$C0,$1F,$C0,$3F,$C0,$3F
 .db $E0,$7F,$C0,$FF,$C0,$7F,$C0,$7F,$C0,$7F,$C0,$7F,$C0,$3F,$E0,$3F
;Tile 19
 .db $00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$01,$00,$21,$40,$20,$40
 .db $1F,$80,$39,$00,$3E,$80,$29,$80,$3F,$80,$3F,$80,$3F,$C0,$1F,$C0
 .db $00,$00,$07,$40,$3F,$80,$1C,$C0,$3F,$E0,$3F,$60,$3D,$40,$38,$40
 .db $1F,$80,$31,$00,$26,$80,$29,$80,$26,$80,$3F,$80,$3F,$C0,$1F,$C0
 ;Tile 20
 .db $F8,$3F,$C0,$7F,$E0,$3F,$C0,$1F,$C0,$1F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$FF,$C0,$7F,$80,$7F,$C0,$7F,$C0,$7F,$C0,$3F,$80,$7F,$87,$FF
;Tile 21
 .db $00,$00,$00,$00,$00,$00,$00,$00,$01,$00,$21,$40,$20,$40,$1F,$80
 .db $39,$00,$33,$80,$6C,$80,$3B,$80,$3F,$80,$3F,$C0,$7F,$80,$78,$00
 .db $07,$40,$3F,$80,$1C,$C0,$3F,$E0,$3F,$60,$3D,$40,$38,$40,$1F,$80
 .db $31,$00,$23,$80,$64,$80,$27,$80,$3F,$80,$3F,$C0,$7F,$80,$78,$00
 ;Tile 22
 .db $F8,$3F,$C0,$7F,$E0,$3F,$C0,$1F,$C0,$1F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$FF,$C0,$7F,$C0,$7F,$C0,$7F,$80,$7F,$00,$7F,$00,$3F,$F8,$3F
;Tile 23
 .db $00,$00,$00,$00,$00,$00,$00,$00,$01,$00,$21,$40,$20,$40,$1F,$80
 .db $39,$00,$3C,$80,$32,$80,$3C,$80,$7F,$80,$FF,$80,$FF,$C0,$07,$C0
 .db $07,$40,$3F,$80,$1C,$C0,$3F,$E0,$3F,$60,$3D,$40,$38,$40,$1F,$80
 .db $31,$00,$2C,$80,$32,$80,$2D,$80,$7F,$80,$FF,$80,$FF,$C0,$07,$C0
 ;Tile 24
 .db $FF,$FF,$E0,$3F,$C0,$7F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F
 .db $80,$1F,$00,$0F,$00,$0F,$00,$0F,$80,$1F,$C0,$3F,$80,$1F,$86,$1F
;Tile 25
 .db $00,$00,$1F,$C0,$3F,$80,$20,$00,$19,$80,$09,$00,$29,$40,$20,$40
 .db $7F,$E0,$80,$10,$C0,$30,$A0,$50,$7F,$E0,$3F,$C0,$7F,$E0,$79,$E0
 .db $00,$00,$00,$00,$00,$00,$00,$C0,$20,$40,$29,$40,$29,$40,$20,$40
 .db $1F,$80,$7F,$E0,$39,$C0,$1F,$80,$20,$40,$3F,$C0,$7F,$E0,$79,$E0
 ;Tile 26
 .db $E0,$3F,$C0,$7F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$80,$1F
 .db $00,$0F,$00,$0F,$80,$0F,$C0,$1F,$C0,$3F,$C0,$3F,$C6,$3F,$C7,$FF
;Tile 27
 .db $1F,$C0,$3F,$80,$20,$00,$19,$80,$09,$00,$29,$40,$20,$40,$7F,$E0
 .db $C0,$10,$C0,$30,$40,$50,$3F,$E0,$3F,$C0,$3F,$C0,$39,$C0,$38,$00
 .db $00,$00,$00,$00,$00,$C0,$20,$40,$29,$40,$29,$40,$20,$40,$1F,$80
 .db $3F,$E0,$39,$C0,$3F,$80,$20,$40,$3F,$C0,$3F,$C0,$39,$C0,$38,$00
 ;Tile 28
 .db $E0,$3F,$C0,$7F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$80,$1F
 .db $00,$0F,$00,$0F,$00,$1F,$80,$3F,$C0,$3F,$C0,$3F,$C6,$3F,$FE,$3F
;Tile 29
 .db $1F,$C0,$3F,$80,$20,$00,$19,$80,$09,$00,$29,$40,$20,$40,$7F,$E0
 .db $80,$30,$C0,$30,$A0,$60,$7F,$C0,$3F,$C0,$3F,$C0,$39,$C0,$01,$C0
 .db $00,$00,$00,$00,$00,$C0,$20,$40,$29,$40,$29,$40,$20,$40,$1F,$80
 .db $7F,$C0,$39,$C0,$1F,$80,$20,$40,$3F,$C0,$3F,$C0,$39,$C0,$01,$C0
 ;Tile 30
 .db $FF,$FF,$E0,$7F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F
 .db $80,$1F,$00,$0F,$00,$0F,$00,$0F,$80,$1F,$80,$1F,$80,$1F,$8F,$1F
;Tile 31
 .db $00,$00,$1F,$80,$3F,$C0,$3F,$C0,$1F,$80,$00,$00,$20,$40,$20,$40
 .db $3F,$C0,$40,$20,$C0,$30,$C0,$30,$7F,$E0,$7F,$E0,$7F,$E0,$70,$E0
 .db $00,$00,$00,$00,$00,$00,$00,$00,$20,$40,$3F,$C0,$20,$40,$20,$40
 .db $40,$20,$BF,$D0,$39,$C0,$3F,$C0,$7F,$E0,$7F,$E0,$7F,$E0,$70,$E0
 ;Tile 32
 .db $E0,$7F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$80,$1F
 .db $00,$0F,$00,$0F,$00,$0F,$80,$1F,$80,$1F,$80,$1F,$87,$1F,$FF,$1F
;Tile 33
 .db $1F,$80,$3F,$C0,$3F,$C0,$1F,$80,$00,$00,$20,$40,$20,$40,$3F,$C0
 .db $40,$20,$A0,$30,$A0,$30,$7F,$E0,$7F,$E0,$7F,$E0,$78,$E0,$00,$E0
 .db $00,$00,$00,$00,$00,$00,$20,$40,$3F,$C0,$20,$40,$20,$40,$40,$20
 .db $BF,$D0,$39,$C0,$3F,$C0,$7F,$E0,$7F,$E0,$7F,$E0,$78,$E0,$00,$E0
 ;Tile 34
 .db $E0,$7F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$80,$1F
 .db $00,$0F,$00,$0F,$00,$0F,$80,$1F,$80,$1F,$80,$1F,$8F,$1F,$8F,$FF
;Tile 35
 .db $1F,$80,$3F,$C0,$3F,$C0,$1F,$80,$00,$00,$20,$40,$20,$40,$3F,$C0
 .db $40,$20,$C0,$50,$C0,$50,$7F,$E0,$7F,$E0,$7F,$E0,$70,$E0,$70,$00
 .db $00,$00,$00,$00,$00,$00,$20,$40,$3F,$C0,$20,$40,$20,$40,$40,$20
 .db $BF,$D0,$39,$C0,$3F,$C0,$7F,$E0,$7F,$E0,$7F,$E0,$70,$E0,$70,$00
 ;Tile 36
 .db $FF,$FF,$80,$7F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F
 .db $E0,$7F,$80,$3F,$80,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$80,$7F
;Tile 37
 .db $00,$00,$7F,$80,$3F,$C0,$11,$C0,$0C,$C0,$08,$40,$28,$40,$20,$40
 .db $1F,$80,$26,$40,$29,$40,$26,$40,$3F,$C0,$3F,$C0,$3F,$C0,$7F,$80
 .db $00,$00,$00,$00,$00,$00,$20,$00,$20,$00,$28,$00,$28,$40,$20,$40
 .db $1F,$80,$5F,$80,$59,$80,$1F,$40,$00,$40,$3F,$C0,$3F,$C0,$7F,$80
 ;Tile 38
 .db $80,$FF,$C0,$7F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $F0,$3F,$E0,$3F,$E0,$3F,$E0,$3F,$E0,$3F,$C0,$3F,$E0,$1F,$FE,$1F
;Tile 39
 .db $7F,$00,$3F,$80,$21,$C0,$2C,$C0,$08,$C0,$28,$40,$20,$40,$1F,$80
 .db $09,$C0,$1C,$C0,$13,$40,$1F,$C0,$1F,$C0,$3F,$C0,$1F,$E0,$01,$E0
 .db $00,$00,$00,$00,$00,$00,$00,$00,$28,$00,$28,$00,$20,$40,$1F,$80
 .db $02,$00,$0D,$00,$12,$00,$0C,$00,$1F,$C0,$3F,$C0,$1F,$E0,$01,$E0
 ;Tile 40
 .db $80,$7F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $F0,$3F,$E0,$3F,$E0,$3F,$E0,$3F,$E0,$1F,$E0,$0F,$C0,$0F,$C1,$FF
;Tile 41
 .db $7F,$80,$3F,$C0,$21,$C0,$2C,$C0,$08,$C0,$28,$40,$20,$40,$1F,$80
 .db $08,$40,$13,$40,$14,$C0,$13,$40,$1F,$E0,$1F,$F0,$3F,$F0,$3E,$00
 .db $00,$00,$00,$00,$02,$00,$00,$00,$28,$00,$28,$40,$20,$40,$1F,$80
 .db $07,$80,$0F,$80,$0C,$80,$0F,$80,$1F,$E0,$1F,$F0,$3F,$F0,$3E,$00
 ;Tile 42
 .db $FF,$FF,$E0,$1F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F
 .db $E0,$7F,$C0,$1F,$C0,$1F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$E0,$1F
;Tile 43
 .db $00,$00,$1F,$E0,$3F,$C0,$38,$80,$33,$00,$21,$00,$21,$40,$20,$40
 .db $1F,$80,$26,$40,$29,$40,$26,$40,$3F,$C0,$3F,$C0,$3F,$C0,$1F,$E0
 .db $00,$00,$00,$00,$00,$00,$00,$40,$00,$40,$01,$40,$21,$40,$20,$40
 .db $1F,$80,$1F,$A0,$19,$A0,$2F,$80,$20,$00,$3F,$C0,$3F,$C0,$1F,$E0
 ;Tile 44
 .db $F0,$1F,$E0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$FF,$C0,$7F,$C0,$7F,$C0,$7F,$C0,$7F,$C0,$3F,$80,$7F,$87,$FF
;Tile 45
 .db $0F,$E0,$1F,$C0,$38,$40,$33,$40,$31,$00,$21,$40,$20,$40,$1F,$80
 .db $39,$00,$33,$80,$2C,$80,$3F,$80,$3F,$80,$3F,$C0,$7F,$80,$78,$00
 .db $00,$00,$00,$00,$00,$00,$00,$00,$01,$40,$01,$40,$20,$40,$1F,$80
 .db $04,$00,$0B,$00,$04,$80,$03,$00,$3F,$80,$3F,$C0,$7F,$80,$78,$00
 ;Tile 46
 .db $E0,$1F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$FF,$C0,$7F,$C0,$7F,$C0,$7F,$80,$7F,$00,$7F,$00,$3F,$00,$3F
;Tile 47
 .db $1F,$E0,$3F,$C0,$38,$40,$33,$40,$31,$00,$21,$40,$20,$40,$1F,$80
 .db $21,$00,$2C,$80,$32,$80,$2C,$80,$7F,$80,$FF,$80,$FF,$C0,$07,$C0
 .db $00,$00,$00,$00,$04,$00,$00,$00,$01,$40,$21,$40,$20,$40,$1F,$80
 .db $1E,$00,$1F,$00,$13,$00,$1F,$00,$7F,$80,$FF,$80,$FF,$C0,$07,$C0
 ;Tile 48
 .db $EF,$FF,$E1,$FF,$A0,$7F,$C0,$3F,$C0,$3F,$80,$3F,$C0,$3F,$C0,$3F
 .db $E0,$7F,$C0,$3F,$80,$1F,$80,$1F,$C0,$3F,$C0,$3F,$80,$1F,$80,$1F
;Tile 49
 .db $00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$09,$00,$09,$40,$20,$40
 .db $1F,$80,$39,$C0,$60,$60,$50,$A0,$20,$40,$3F,$C0,$7F,$E0,$79,$E0
 .db $10,$00,$1E,$00,$5F,$80,$3F,$C0,$30,$C0,$70,$40,$39,$40,$20,$40
 .db $1F,$80,$3F,$C0,$66,$60,$56,$A0,$26,$40,$3F,$C0,$6F,$60,$79,$E0
 ;Tile 50
 .db $E1,$FF,$A0,$7F,$C0,$3F,$C0,$3F,$80,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$3F,$80,$1F,$80,$1F,$C0,$3F,$C0,$3F,$C0,$3F,$C6,$3F,$FE,$3F
;Tile 51
 .db $00,$00,$00,$00,$00,$00,$00,$00,$09,$00,$09,$40,$20,$40,$1F,$80
 .db $39,$C0,$60,$60,$50,$60,$20,$40,$3F,$C0,$3F,$C0,$39,$C0,$01,$C0
 .db $1E,$00,$5F,$80,$3F,$C0,$30,$C0,$70,$40,$39,$40,$20,$40,$1F,$80
 .db $3F,$C0,$66,$60,$56,$60,$26,$40,$3F,$C0,$2F,$40,$39,$40,$01,$C0
 ;Tile 52
 .db $E1,$FF,$A0,$7F,$C0,$3F,$C0,$3F,$80,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$3F,$80,$1F,$80,$1F,$C0,$3F,$C0,$3F,$C0,$3F,$C6,$3F,$C7,$FF
;Tile 53
 .db $00,$00,$00,$00,$00,$00,$00,$00,$09,$00,$09,$40,$20,$40,$1F,$80
 .db $39,$C0,$60,$60,$60,$A0,$20,$40,$3F,$C0,$3F,$C0,$39,$C0,$38,$00
 .db $1E,$00,$5F,$80,$3F,$C0,$30,$C0,$70,$40,$39,$40,$20,$40,$1F,$80
 .db $3F,$C0,$66,$60,$66,$A0,$26,$40,$3F,$C0,$2F,$40,$29,$C0,$38,$00
 ;Tile 54
 .db $FF,$7F,$F8,$7F,$E0,$5F,$C0,$3F,$C0,$3F,$C0,$1F,$C0,$3F,$C0,$3F
 .db $E0,$7F,$C0,$3F,$80,$1F,$80,$1F,$C0,$3F,$C0,$3F,$80,$1F,$80,$1F
;Tile 55
 .db $00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$20,$00,$20,$40
 .db $1F,$80,$39,$C0,$60,$60,$60,$60,$20,$40,$3F,$C0,$7F,$E0,$79,$E0
 .db $00,$80,$07,$80,$1F,$A0,$3F,$C0,$3F,$C0,$3F,$E0,$3F,$C0,$2F,$40
 .db $1F,$80,$39,$C0,$60,$60,$62,$60,$24,$40,$3F,$C0,$7F,$E0,$79,$E0
 ;Tile 56
 .db $F8,$7F,$E0,$5F,$C0,$3F,$C0,$3F,$C0,$1F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$3F,$80,$1F,$80,$0F,$C0,$1F,$C0,$3F,$C0,$3F,$C6,$3F,$FE,$3F
;Tile 57
 .db $00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$20,$00,$20,$40,$1F,$80
 .db $39,$C0,$60,$60,$60,$50,$20,$60,$3F,$C0,$3F,$C0,$39,$C0,$01,$C0
 .db $07,$80,$1F,$A0,$3F,$C0,$3F,$C0,$3F,$E0,$3F,$C0,$2F,$40,$1F,$80
 .db $39,$C0,$60,$60,$62,$50,$24,$60,$3F,$C0,$3F,$C0,$39,$C0,$01,$C0
 ;Tile 58
 .db $F8,$7F,$E0,$5F,$C0,$3F,$C0,$3F,$C0,$1F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$3F,$80,$1F,$00,$1F,$80,$3F,$C0,$3F,$C0,$3F,$C6,$3F,$C7,$FF
;Tile 59
 .db $00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$20,$00,$20,$40,$1F,$80
 .db $39,$C0,$60,$60,$A0,$60,$60,$40,$3F,$C0,$3F,$C0,$39,$C0,$38,$00
 .db $07,$80,$1F,$A0,$3F,$C0,$3F,$C0,$3F,$E0,$3F,$C0,$2F,$40,$1F,$80
 .db $39,$C0,$60,$60,$A2,$60,$64,$40,$3F,$C0,$3F,$C0,$39,$C0,$38,$00
 ;Tile 60
 .db $EF,$FF,$E1,$FF,$A0,$7F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F
 .db $E0,$7F,$E0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$80,$7F
;Tile 61
 .db $00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$08,$00,$28,$40,$20,$40
 .db $1F,$80,$10,$40,$26,$40,$29,$40,$26,$40,$3F,$C0,$3F,$C0,$7F,$80
 .db $10,$00,$1E,$00,$5F,$80,$3F,$C0,$31,$C0,$21,$C0,$28,$C0,$20,$40
 .db $1F,$80,$0F,$C0,$26,$40,$29,$40,$26,$40,$3F,$C0,$27,$C0,$7F,$80
 ;Tile 62
 .db $E1,$FF,$A0,$7F,$80,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $F0,$3F,$E0,$3F,$E0,$1F,$E0,$3F,$E0,$3F,$C0,$3F,$E0,$1F,$FE,$1F
;Tile 63
 .db $00,$00,$00,$00,$00,$00,$00,$00,$08,$00,$28,$40,$20,$40,$1F,$80
 .db $08,$40,$1C,$40,$12,$60,$1C,$40,$1F,$C0,$3F,$C0,$1F,$E0,$01,$E0
 .db $1E,$00,$5F,$80,$3F,$C0,$31,$C0,$29,$C0,$28,$C0,$20,$40,$1F,$80
 .db $08,$40,$1C,$40,$12,$60,$1C,$40,$1F,$C0,$33,$C0,$1F,$E0,$01,$E0
 ;Tile 64
 .db $D1,$FF,$E0,$3F,$C0,$7F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $F0,$3F,$E0,$3F,$E0,$3F,$E0,$3F,$E0,$1F,$E0,$0F,$C0,$0F,$C1,$FF
;Tile 65
 .db $00,$00,$00,$00,$00,$00,$00,$00,$08,$00,$28,$40,$20,$40,$1F,$80
 .db $08,$C0,$13,$40,$14,$C0,$13,$40,$1F,$E0,$1F,$F0,$3F,$F0,$3E,$00
 .db $2E,$00,$1F,$C0,$3F,$80,$23,$C0,$29,$C0,$29,$C0,$20,$C0,$1F,$80
 .db $08,$C0,$13,$40,$14,$C0,$1B,$40,$1F,$E0,$13,$F0,$3F,$F0,$3E,$00
 ;Tile 66
 .db $FF,$7F,$F8,$7F,$E0,$5F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F
 .db $E0,$7F,$C0,$7F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$E0,$1F
;Tile 67
 .db $00,$00,$00,$00,$00,$00,$00,$00,$00,$00,$01,$00,$21,$40,$20,$40
 .db $1F,$80,$20,$80,$26,$40,$29,$40,$26,$40,$3F,$C0,$3F,$C0,$1F,$E0
 .db $00,$80,$07,$80,$1F,$A0,$3F,$C0,$38,$C0,$38,$40,$31,$40,$20,$40
 .db $1F,$80,$3F,$00,$26,$40,$29,$40,$26,$40,$3F,$C0,$3E,$40,$1F,$E0
 ;Tile 68
 .db $F8,$BF,$C0,$7F,$E0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$FF,$C0,$7F,$C0,$7F,$C0,$7F,$80,$7F,$00,$7F,$00,$3F,$F8,$3F
;Tile 69
 .db $00,$00,$00,$00,$00,$00,$00,$00,$01,$00,$21,$40,$20,$40,$1F,$80
 .db $31,$00,$2C,$80,$32,$80,$2C,$80,$7F,$80,$FF,$80,$FF,$C0,$07,$C0
 .db $07,$40,$3F,$80,$1F,$C0,$3C,$40,$39,$40,$39,$40,$30,$40,$1F,$80
 .db $31,$00,$2C,$80,$32,$80,$2D,$80,$7F,$80,$FC,$80,$FF,$C0,$07,$C0
 ;Tile 70
 .db $F8,$7F,$E0,$5F,$C0,$1F,$C0,$3F,$C0,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$FF,$C0,$7F,$80,$7F,$C0,$7F,$C0,$7F,$C0,$3F,$80,$7F,$87,$FF
;Tile 71
 .db $00,$00,$00,$00,$00,$00,$00,$00,$01,$00,$21,$40,$20,$40,$1F,$80
 .db $21,$00,$23,$80,$64,$80,$23,$80,$3F,$80,$3F,$C0,$7F,$80,$78,$00
 .db $07,$80,$1F,$A0,$3F,$C0,$38,$C0,$39,$40,$31,$40,$20,$40,$1F,$80
 .db $21,$00,$23,$80,$64,$80,$23,$80,$3F,$80,$3C,$C0,$7F,$80,$78,$00
 ;Tile 72
 .db $FF,$FF,$F8,$FF,$E0,$7F,$C0,$3F,$C0,$3F,$80,$3F,$C0,$3F,$C0,$3F
 .db $E0,$7F,$C0,$3F,$80,$1F,$80,$1F,$C0,$3F,$C0,$3F,$80,$1F,$86,$1F
;Tile 73
 .db $00,$00,$07,$00,$1F,$80,$3F,$C0,$3C,$40,$7F,$40,$3B,$C0,$21,$C0
 .db $1F,$80,$3F,$C0,$70,$E0,$50,$A0,$39,$C0,$3F,$C0,$7F,$E0,$79,$E0
 .db $00,$00,$04,$00,$10,$00,$20,$00,$03,$00,$08,$80,$0C,$40,$3E,$40
 .db $1F,$00,$19,$80,$69,$60,$79,$E0,$26,$40,$3F,$C0,$7F,$E0,$79,$E0
 ;Tile 74
 .db $F8,$FF,$E0,$7F,$C0,$3F,$C0,$3F,$80,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$3F,$80,$1F,$80,$1F,$C0,$3F,$C0,$3F,$C0,$3F,$C6,$3F,$C7,$FF
;Tile 75
 .db $07,$00,$1F,$80,$3F,$C0,$3C,$40,$7F,$40,$3B,$C0,$21,$C0,$1F,$80
 .db $3F,$C0,$70,$E0,$70,$A0,$39,$C0,$3F,$C0,$3F,$C0,$39,$C0,$38,$00
 .db $04,$00,$10,$00,$20,$00,$03,$00,$08,$80,$0C,$40,$3E,$40,$1F,$00
 .db $19,$80,$29,$60,$29,$E0,$26,$40,$3F,$C0,$3F,$C0,$39,$C0,$38,$00
 ;Tile 76
 .db $F8,$FF,$E0,$7F,$C0,$3F,$C0,$3F,$80,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$3F,$80,$1F,$80,$1F,$C0,$3F,$C0,$3F,$C0,$3F,$C6,$3F,$FE,$3F
;Tile 77
 .db $07,$00,$1F,$80,$3F,$C0,$3C,$40,$7F,$40,$3B,$C0,$21,$C0,$1F,$80
 .db $3F,$C0,$70,$E0,$50,$E0,$39,$C0,$3F,$C0,$3F,$C0,$39,$C0,$01,$C0
 .db $04,$00,$10,$00,$20,$00,$03,$00,$08,$80,$0C,$40,$3E,$40,$1F,$00
 .db $19,$80,$69,$40,$79,$40,$26,$40,$3F,$C0,$3F,$C0,$39,$C0,$01,$C0
 ;Tile 78
 .db $FF,$FF,$F8,$FF,$E0,$7F,$C0,$3F,$C0,$3F,$80,$3F,$C0,$3F,$C0,$3F
 .db $E0,$7F,$C0,$3F,$80,$1F,$80,$1F,$C0,$3F,$C0,$3F,$80,$1F,$80,$1F
;Tile 79
 .db $00,$00,$07,$00,$1F,$80,$3F,$C0,$3B,$C0,$67,$C0,$3F,$C0,$3F,$C0
 .db $1F,$80,$3F,$C0,$70,$E0,$70,$E0,$39,$C0,$3F,$C0,$7F,$E0,$79,$E0
 .db $00,$00,$04,$00,$10,$00,$20,$00,$04,$00,$18,$00,$00,$40,$20,$40
 .db $19,$80,$16,$80,$6F,$60,$6F,$60,$26,$40,$3F,$C0,$7F,$E0,$79,$E0
 ;Tile 80
 .db $F8,$FF,$E0,$7F,$C0,$3F,$C0,$3F,$80,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$7F,$80,$1F,$80,$1F,$C0,$3F,$C0,$3F,$C1,$FF,$C7,$FF,$C7,$FF
;Tile 81
 .db $07,$00,$1F,$80,$3F,$C0,$3B,$C0,$67,$C0,$3F,$C0,$3F,$C0,$1F,$80
 .db $3F,$C0,$70,$E0,$50,$E0,$39,$C0,$3F,$C0,$3F,$C0,$39,$C0,$38,$00
 .db $04,$00,$10,$00,$20,$00,$04,$00,$18,$00,$00,$40,$20,$40,$19,$80
 .db $16,$80,$6F,$60,$6F,$60,$26,$40,$3F,$C0,$3E,$00,$38,$00,$38,$00
 ;Tile 82
 .db $F8,$FF,$E0,$7F,$C0,$3F,$C0,$3F,$80,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$3F,$80,$1F,$80,$1F,$C0,$3F,$C0,$3F,$C0,$3F,$C6,$3F,$FE,$3F
;Tile 83
 .db $07,$00,$1F,$80,$3F,$C0,$3B,$C0,$67,$C0,$3F,$C0,$3F,$C0,$1F,$80
 .db $3F,$C0,$70,$E0,$70,$A0,$39,$C0,$3F,$C0,$3F,$C0,$39,$C0,$01,$C0
 .db $04,$00,$10,$00,$20,$00,$04,$00,$18,$00,$00,$40,$20,$40,$19,$80
 .db $16,$80,$6F,$60,$6F,$60,$26,$40,$3F,$C0,$07,$C0,$01,$C0,$01,$C0
 ;Tile 84
 .db $FF,$FF,$F8,$FF,$E0,$7F,$C0,$3F,$C0,$3F,$80,$3F,$80,$3F,$C0,$3F
 .db $E0,$7F,$F0,$7F,$C0,$3F,$C0,$3F,$C0,$3F,$E0,$3F,$E0,$3F,$C0,$7F
;Tile 85
 .db $00,$00,$02,$00,$1F,$80,$3F,$C0,$3C,$40,$3F,$40,$2F,$C0,$2C,$C0
 .db $1B,$00,$0F,$80,$1F,$C0,$19,$C0,$1F,$C0,$1F,$C0,$1F,$C0,$3F,$80
 .db $00,$00,$05,$00,$00,$00,$00,$00,$03,$80,$60,$80,$70,$40,$33,$40
 .db $1F,$80,$0D,$80,$26,$40,$2F,$40,$26,$40,$1F,$C0,$1F,$C0,$3F,$80
 ;Tile 86
 .db $C1,$FF,$C0,$3F,$C0,$7F,$80,$3F,$80,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $F0,$3F,$E0,$3F,$E0,$1F,$E0,$3F,$E0,$3F,$C0,$3F,$E0,$1F,$FE,$1F
;Tile 87
 .db $0E,$00,$3F,$80,$3F,$80,$78,$80,$7E,$C0,$3F,$C0,$2C,$C0,$1F,$80
 .db $0F,$C0,$1F,$C0,$13,$E0,$1F,$C0,$1F,$C0,$3F,$C0,$1F,$E0,$01,$E0
 .db $20,$00,$00,$40,$00,$00,$07,$40,$01,$00,$20,$00,$33,$00,$1B,$80
 .db $08,$40,$1C,$40,$1E,$60,$1C,$40,$1F,$C0,$3F,$C0,$1F,$E0,$01,$E0
 ;Tile 88
 .db $C1,$FF,$E0,$3F,$C0,$7F,$80,$3F,$80,$3F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $F0,$3F,$E0,$3F,$E0,$3F,$E0,$3F,$E0,$1F,$E0,$0F,$C0,$0F,$C1,$FF
;Tile 89
 .db $2C,$00,$1F,$C0,$3F,$80,$3C,$C0,$3F,$C0,$2F,$C0,$25,$C0,$1F,$80
 .db $0F,$C0,$17,$C0,$14,$C0,$17,$C0,$1F,$E0,$1F,$F0,$3F,$F0,$3E,$00
 .db $02,$00,$00,$00,$00,$00,$43,$00,$40,$00,$30,$00,$3A,$40,$1F,$80
 .db $08,$C0,$1B,$40,$1F,$C0,$1B,$40,$1F,$E0,$1F,$F0,$3F,$F0,$3E,$00
 ;Tile 90
 .db $FF,$FF,$E3,$FF,$C0,$FF,$80,$7F,$80,$7F,$80,$3F,$80,$3F,$80,$7F
 .db $C0,$FF,$C1,$FF,$80,$7F,$80,$7F,$80,$7F,$80,$FF,$80,$FF,$C0,$7F
;Tile 91
 .db $00,$00,$08,$00,$3F,$00,$7F,$80,$47,$80,$5F,$80,$7E,$80,$66,$80
 .db $1B,$00,$3E,$00,$7F,$00,$73,$00,$7F,$00,$7F,$00,$7F,$00,$3F,$80
 .db $00,$00,$14,$00,$00,$00,$00,$00,$38,$00,$20,$C0,$41,$C0,$59,$80
 .db $3F,$00,$36,$00,$4C,$80,$5E,$80,$4C,$80,$7F,$00,$7F,$00,$3F,$80
 ;Tile 92
 .db $F8,$3F,$C0,$3F,$E0,$3F,$C0,$1F,$C0,$1F,$C0,$3F,$C0,$3F,$E0,$7F
 .db $C0,$FF,$C0,$7F,$80,$7F,$C0,$7F,$C0,$7F,$C0,$3F,$80,$7F,$87,$FF
;Tile 93
 .db $07,$00,$1F,$C0,$1F,$C0,$11,$E0,$37,$E0,$3F,$C0,$33,$40,$1F,$80
 .db $3F,$00,$3F,$80,$7C,$80,$3F,$80,$3F,$80,$3F,$C0,$7F,$80,$78,$00
 .db $00,$40,$20,$00,$00,$00,$2E,$00,$08,$00,$00,$40,$0C,$C0,$1D,$80
 .db $21,$00,$23,$80,$67,$80,$23,$80,$3F,$80,$3F,$C0,$7F,$80,$78,$00
 ;Tile 94
 .db $FC,$1F,$E0,$3F,$F0,$1F,$E0,$0F,$E0,$0F,$E0,$1F,$E0,$1F,$F0,$3F
 .db $E0,$7F,$E0,$3F,$E0,$3F,$E0,$3F,$C0,$3F,$80,$3F,$80,$1F,$FC,$1F
 ;Tile 95
 .db $03,$40,$3F,$80,$1F,$C0,$33,$C0,$3F,$C0,$3F,$40,$3A,$40,$1F,$80
 .db $3F,$00,$3E,$80,$32,$80,$3E,$80,$7F,$80,$FF,$80,$FF,$C0,$07,$C0
 .db $04,$00,$00,$00,$00,$00,$0C,$20,$00,$20,$00,$C0,$25,$C0,$1F,$80
 .db $31,$00,$2D,$80,$3F,$80,$2D,$80,$7F,$80,$FF,$80,$FF,$C0,$07,$C0
 .block 2304


 #include "npcsprites.asm"
